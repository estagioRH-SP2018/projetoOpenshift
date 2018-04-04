package redhat;

public class Cliente extends Pessoa {

	private RedHatter vendedor;
	private Long cnpj;
	private Boolean subscricaoAtiva;

	public Cliente(String nome, Integer idade, String email, Long cpf) {
		super(nome, idade, email, cpf);
	}

	public Cliente(String nome, Integer idade, String email, Long cpf, RedHatter vendedor, Long cnpj,
			Boolean subscricaoAtiva) {
		super(nome, idade, email, cpf);
		this.vendedor = vendedor;
		this.cnpj = cnpj;
		this.subscricaoAtiva = subscricaoAtiva;
	}

	public RedHatter getVendedor() {
		return vendedor;
	}

	public void setVendedor(RedHatter vendedor) {
		this.vendedor = vendedor;
	}

	public Long getCnpj() {
		return cnpj;
	}

	public void setCnpj(Long cnpj) {
		this.cnpj = cnpj;
	}

	public Boolean getSubscricaoAtiva() {
		return subscricaoAtiva;
	}

	public void setSubscricaoAtiva(Boolean subscricaoAtiva) {
		this.subscricaoAtiva = subscricaoAtiva;
	}

}
