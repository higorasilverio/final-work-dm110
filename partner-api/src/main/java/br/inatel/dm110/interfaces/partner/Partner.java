package br.inatel.dm110.interfaces.partner;

import java.util.List;

import br.inatel.dm110.api.partner.PartnerTO;

public interface Partner {

	public PartnerTO savePartner(PartnerTO partner);
	
	public PartnerTO getPartner(Integer partnerCode);
	
	public List<PartnerTO> listAllPartners();
	
	public PartnerTO updatePartner(PartnerTO partner);
}
