package br.inatel.dm110.api.partner;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/partners")
public interface PartnerService {
	
	@POST
	@Path("/new")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public PartnerTO savePartner(@FormParam("partner") PartnerTO partner);

	@GET
	@Path("/partner/{partner-code}")
	@Produces(MediaType.APPLICATION_JSON)
	public PartnerTO getPartner(@PathParam("partner-code") Integer partnerCode);
	
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<PartnerTO> listAllPartners();

	@PUT
	@Path("/partner")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public PartnerTO updatePartner(@FormParam("partner") PartnerTO partner);

}
