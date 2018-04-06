package webservice;

import java.util.HashSet;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import redhat.Cliente;
import redhat.Pessoa;
import redhat.RedHatter;

@Path("pessoa")
public class PessoaRest {

	static HashSet<Pessoa> pessoas = new HashSet<>();
	static HashSet<RedHatter> redHatters = new HashSet<>();
	static HashSet<Cliente> clientes = new HashSet<>();

	/*
	 * Método de inclusão de objeto do tipo RedHatter nas coleções "redHatters" e
	 * "pessoas", a fim de que sejam exibidos nos casos de uso de exibição de
	 * funcionários Red Hat bem como na exibição de stakeholders. Recebe parâmetros
	 * através de url do POST e utiliza o construtor completo para instanciação.
	 */
	@POST
	@Path("incluiRedHatter")
	public void postRedHatter(@QueryParam("nome") String nome, @QueryParam("idade") Integer idade,
			@QueryParam("email") String email, @QueryParam("cpf") Long cpf,
			@QueryParam("centroDeCusto") Integer centroDeCusto, @QueryParam("salario") Double salario,
			@QueryParam("especialidade") String especialidade, @QueryParam("cargo") String cargo) {

		RedHatter inclusao = new RedHatter(nome, idade, email, cpf, centroDeCusto, salario, especialidade, cargo);

		redHatters.add(inclusao);
		pessoas.add(inclusao);
	}

	/*
	 * Método de inclusão de objeto do tipo Cliente nas coleções "clientes" e
	 * "pessoas", a fim de que sejam exibidos nos casos de uso de exibição de
	 * cleintes Red Hat bem como na exibição de stakeholders. Recebe parâmetros
	 * através de url do POST e utiliza o construtor completo para instanciação.
	 */
	@POST
	@Path("incluiCliente")
	public void postCliente(@QueryParam("nome") String nome, @QueryParam("email") String email,
			@QueryParam("cpfVendedor") Long cpfVendedor, @QueryParam("cnpj") Long cnpj,
			@QueryParam("subscricaoAtiva") Boolean subscricaoAtiva) {

		Cliente inclusao = new Cliente(nome, email, cpfVendedor, cnpj, subscricaoAtiva);

		clientes.add(inclusao);
		pessoas.add(inclusao);
	}

	/*
	 * Produz uma view de todos stakeholders (funcionários e clientes) envolvidos na
	 * aplicação através de um arquivo json. Este é obtido através de uma
	 * solicitação GET. Como argumento para construção do arquivo json utiliza-se a
	 * coleção "pessoas".
	 */
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("pessoas")
	public Response getPessoas() {
		return Response.ok(pessoas).header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON).build();
	}

	/*
	 * Produz uma view de funcionários Red Hat envolvidos na aplicação através de um
	 * arquivo json. Este é obtido através de uma solicitação GET. Como argumento
	 * para construção do arquivo json utiliza-se a coleção "redHatter".
	 */

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("redHatters")
	public Response getRedHatters() {
		return Response.ok(redHatters).header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON).build();
	}

	/*
	 * Produz uma view de clientes Red Hat envolvidos na aplicação através de um
	 * arquivo json. Este é obtido através de uma solicitação GET. Como argumento
	 * para construção do arquivo json utiliza-se a coleção "clientes".
	 */

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("clientes")
	public Response getClientes() {
		return Response.ok(clientes).header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON).build();
	}
}