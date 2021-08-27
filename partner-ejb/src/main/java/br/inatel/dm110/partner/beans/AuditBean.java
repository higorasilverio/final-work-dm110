package br.inatel.dm110.partner.beans;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.modelmapper.ModelMapper;

import javax.ejb.Local;
import javax.ejb.Stateless;

import br.inatel.dm110.api.partner.AuditTO;
import br.inatel.dm110.interfaces.partner.AuditLocal;
import br.inatel.dm110.partner.entities.Audit;

@Stateless
@Local(AuditLocal.class)
public class AuditBean implements AuditLocal {
	
	@PersistenceContext(unitName = "partner_pu")
	private EntityManager em;

	@Override
	public void saveRegister(AuditTO audit) {
		Audit entity = new ModelMapper().map(audit, Audit.class);
		em.persist(entity);
	}
}

