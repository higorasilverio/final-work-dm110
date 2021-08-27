package br.inatel.dm110.partner.beans;

import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ejb.Local;
import javax.ejb.Stateless;

import org.modelmapper.ModelMapper;

import br.inatel.dm110.api.partner.AuditTO;
import br.inatel.dm110.api.partner.PartnerTO;
import br.inatel.dm110.interfaces.partner.PartnerLocal;
import br.inatel.dm110.partner.senders.PartnerQueueSender;
import br.inatel.dm110.partner.entities.Partner;

@Stateless
@Local(PartnerLocal.class)
public class PartnerBean implements PartnerLocal {

	private static Logger log = Logger.getLogger(PartnerBean.class.getName());
	
	@PersistenceContext(unitName = "partner_pu")
	private EntityManager em;
	
	@EJB
	private PartnerQueueSender queueSender;

	@Override
	public PartnerTO savePartner(PartnerTO partner) {
		log.info("Save partner: " + partner.getName());

		queueSender.sendObjectMessage(
				new AuditTO(
						partner.getPartnerCode(), 
						"create",
						LocalDateTime.now())
		);
		Partner entity = new ModelMapper().map(partner, Partner.class);
		em.persist(entity);
		
		return new ModelMapper().map(entity, PartnerTO.class);
	}

	@Override
	public PartnerTO getPartner(Integer partnerCode) {
		log.info("Retrieve partner: " + partnerCode);

		queueSender.sendObjectMessage(
				new AuditTO(
						partnerCode, 
						"read",
						LocalDateTime.now())
		);
		Partner entity = em.find(Partner.class, partnerCode);
		
		return new ModelMapper().map(entity, PartnerTO.class);
	}

	@Override
	public List<PartnerTO> listAllPartners() {
		log.info("Retrieving all partners");

		queueSender.sendObjectMessage(
				new AuditTO(
						null, 
						"read",
						LocalDateTime.now())
		);
		TypedQuery<Partner> query = 
				em.createQuery("from Partner p", Partner.class);
		List<Partner> partners = query.getResultList();

		return toCollectionAPIModel(partners);
	}

	@Override
	public PartnerTO updatePartner(PartnerTO partner) {
		log.info(
				"Updating partner with partnerCode: " + partner.getPartnerCode()
		);

		queueSender.sendObjectMessage(
				new AuditTO(
						partner.getPartnerCode(), 
						"update",
						LocalDateTime.now())
		);
		Partner partnerToUpdate = new ModelMapper().map(partner, Partner.class);
		Partner entity = em.merge(partnerToUpdate);

		return new ModelMapper().map(entity, PartnerTO.class);
	}

	private List<PartnerTO> toCollectionAPIModel(List<Partner> partnerList) {
		return partnerList.stream().map(partner -> {
			PartnerTO partnerTO = new PartnerTO();
			partnerTO.setPartnerCode(partner.getPartnerCode());
			partnerTO.setName(partner.getName());
			partnerTO.setPhone(partner.getPhone());
			partnerTO.setEmail(partner.getEmail());
			partnerTO.setRating(partner.getRating());
			return partnerTO;
		}).collect(Collectors.toList());
	}
}

