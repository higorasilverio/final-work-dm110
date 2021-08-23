package br.inatel.dm110.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;

import br.inatel.dm110.api.partner.PartnerService;
import br.inatel.dm110.api.partner.PartnerTO;
import br.inatel.dm110.interfaces.partner.PartnerLocal;

@RequestScoped
public class PartnerServiceImpl implements PartnerService {

	@EJB
	private PartnerLocal partnerBean;

	@Override
	public PartnerTO savePartner(PartnerTO partner) {
		return partnerBean.savePartner(partner);
	}

	@Override
	public PartnerTO getPartner(Integer partnerCode) {
		return partnerBean.getPartner(partnerCode);
	}

	@Override
	public List<PartnerTO> listAllPartners() {
		return partnerBean.listAllPartners();
	}

	@Override
	public PartnerTO updatePartner(PartnerTO partner) {
		return partnerBean.updatePartner(partner);
	}

}
