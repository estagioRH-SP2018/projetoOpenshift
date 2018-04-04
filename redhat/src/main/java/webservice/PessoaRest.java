package webservice;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import redhat.Pessoa;
import redhat.RedHatter;

@Path("pessoa")
public class PessoaRest {

	Pessoa p = new RedHatter("Patrick",12,"123@123",(long) 123123);
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("teste")
	public Response teste () {
		return Response.ok(p).header(HttpHeaders.CONTENT_TYPE,
				MediaType.APPLICATION_JSON).build();
	}
}
