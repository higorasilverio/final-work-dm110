package br.inatel.dm110.client.partner;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.inatel.dm110.api.partner.PartnerTO;

public class PartnerClient {

	private static final String REST_URI_POST = 
			"http://localhost:8080/dm110-web/api/partners/new";
	private static final String REST_URI_GET_OR_UPDATE_ONE = 
			"http://localhost:8080/dm110-web/api/partners/partner";
	private static final String REST_URI_GET_ALL = 
			"http://localhost:8080/dm110-web/api/partners/all";

	private static Client client = ClientBuilder.newClient();

	public static void main(String[] args) {
		System.out.println("Message service:");
		
		PartnerTO partner00 = new PartnerTO();
		partner00.setEmail("partner00@email.com");
		partner00.setName("Partner Silva");
		partner00.setPartnerCode(0);
		partner00.setPhone("+5535990707010");
		partner00.setRating(4);
		
		System.out.println(
				"Result from POST first partner: " 
				+ createPartner(partner00)
		);
		
		PartnerTO partner01 = new PartnerTO();
		partner01.setEmail("partner01@email.com");
		partner01.setName("Partner Ramos");
		partner01.setPartnerCode(1);
		partner01.setPhone("+5535991717111");
		partner01.setRating(5);
		
		System.out.println(
				"Result from POST second partner: " 
				+ createPartner(partner01)
		);

		System.out.println("Result from GET 0: " + getPartner(0));
		System.out.println("Result from GET 1: " + getPartner(1));
		
		partner00.setPhone("+5535992727212");
		partner00.setRating(3);
		
		System.out.println(
				"Result from PUT on first partner: " 
				+ updatePartner(partner00)
		);
		
		System.out.println("Result of all partners: " + getAllPartners());
	}
	
	private static PartnerTO createPartner(PartnerTO partner) {
		return client
				.target(REST_URI_POST)
				.request(MediaType.APPLICATION_JSON)
				.post(Entity.entity(partner, MediaType.APPLICATION_JSON))
				.readEntity(partner.getClass());
	}

	private static PartnerTO getPartner(int partnerCode) {
		return client
				.target(REST_URI_GET_OR_UPDATE_ONE)
				.path(String.valueOf(partnerCode))
				.request(MediaType.APPLICATION_JSON)
				.get(PartnerTO.class);
	}
	
	private static PartnerTO updatePartner(PartnerTO partner) {
		return client
			      .target(REST_URI_GET_OR_UPDATE_ONE)
			      .request(MediaType.APPLICATION_JSON)
			      .put(Entity.entity(partner, MediaType.APPLICATION_JSON))
			      .readEntity(partner.getClass());
	}

	private static List<PartnerTO> getAllPartners() {
		return client
                .target(REST_URI_GET_ALL)
                .request(MediaType.APPLICATION_JSON)
                .get(Response.class)
                .readEntity(new GenericType<List<PartnerTO>>() {});
	}


	
}
