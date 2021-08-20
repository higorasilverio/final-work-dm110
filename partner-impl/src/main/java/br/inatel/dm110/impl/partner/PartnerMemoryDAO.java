package br.inatel.dm110.impl.partner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.inatel.dm110.api.partner.PartnerTO;

public class PartnerMemoryDAO {

	private static int count = 0;

	private static Map<Integer, PartnerTO> cache = new HashMap<>();

	public PartnerTO savePartner(PartnerTO partner) {
		partner.setEmail("partner@email.com");
		partner.setName("Phil");
		partner.setPartnerCode(count);
		partner.setPhone("+5535991547862");
		partner.setRating(1);
		cache.put(count, partner);
		count++;
		return partner;
	}

	public PartnerTO getPartner(int partnerCode) {
		return cache.get(partnerCode);
	}
	
	public List<PartnerTO> listAllPartners() {
		List<PartnerTO> result = new ArrayList<PartnerTO>();
		for (int index = 0; index < count; index++) {
			result.add(cache.get(index));
		}
		return result;
	}

	public PartnerTO updatePartner(
			String email, 
			String name,
			Integer partnerCode,
			String phone,
			Integer rating
	) {
		PartnerTO result = cache.get(partnerCode);
		result.setEmail(email);
		result.setName(name);
		result.setPhone(phone);
		result.setRating(rating);
		return result;
	}
}

