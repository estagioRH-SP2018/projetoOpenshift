package webservice;

import java.util.HashSet;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import redhat.Cliente;
import redhat.Pessoa;
import redhat.RedHatter;

@Path("pessoa")
public class PessoaRest {

	HashSet<Pessoa> pessoas = new HashSet<>();
	HashSet<RedHatter> redHatters = new HashSet<>();
	HashSet<Cliente> clientes = new HashSet<>();

	@POST
	@Consumes("text/plain")
	@Path("incluiRedHatter")
	public void postRedHatter(String message) {
		String[] params = message.split(" ");

		RedHatter inclusao = new RedHatter(params[0], Integer.parseInt(params[1]), params[2], Long.parseLong(params[3]),
				Integer.parseInt(params[4]), Double.parseDouble(params[5]), params[6], params[7]);

		redHatters.add(inclusao);
		pessoas.add(inclusao);
	}
	
	@POST
	@Consumes("text/plain")
	@Path("incluiCliente")
	public void postCliente(String message) {
		String[] params = message.split(" ");

		Cliente inclusao = new Cliente(params[0], params[1], Long.parseLong(params[2]), Long.parseLong(params[3]),
				Boolean.parseBoolean(params[4]));

		clientes.add(inclusao);
		pessoas.add(inclusao);
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("pessoas")
	public Response getPessoas() {
		return Response.ok(pessoas).header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON).build();
	}
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("redHatters")
	public Response getRedHatters() {
		return Response.ok(redHatters).header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON).build();
	}
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("clientes")
	public Response getClientes() {
		return Response.ok(clientes).header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON).build();
	}
}
