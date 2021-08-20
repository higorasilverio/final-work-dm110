package br.inatel.dm110.impl.partner;

import java.util.List;
import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;

import br.inatel.dm110.api.partner.PartnerService;
import br.inatel.dm110.api.partner.PartnerTO;

@RequestScoped
public class PartnerServiceImpl implements PartnerService {

	private PartnerMemoryDAO dao = new PartnerMemoryDAO();

	private static Logger log = Logger
			.getLogger(PartnerServiceImpl.class.getName());

	@Override
	public PartnerTO savePartner(PartnerTO partner) {
		log.info("Saving new partner with savePartner!");
		return dao.savePartner(partner);
	}

	@Override
	public PartnerTO getPartner(Integer partnerCode) {
		log.info("Get a partner from its partnerCode with getPartner!");
		return dao.getPartner(partnerCode);
	}

	@Override
	public List<PartnerTO> listAllPartners() {
		log.info("Get a list of partners with listAllPartners!");
		return dao.listAllPartners();
	}

	@Override
	public PartnerTO updatePartner(PartnerTO partner) {
		log.info("Updating a partner with updatePartner!");
		return dao.updatePartner(
				partner.getEmail(), 
				partner.getName(), 
				partner.getPartnerCode(), 
				partner.getPhone(), 
				partner.getRating()
		);
	}

}
