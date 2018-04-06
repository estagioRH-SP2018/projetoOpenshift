package redhat;

public class Cliente extends Pessoa {

	private Long cpfVendedor;
	private Long cnpj;
	private Boolean subscricaoAtiva;

	public Long getCpfVendedor() {
		return cpfVendedor;
	}

	public void setCpfVendedor(Long vendedor) {
		this.cpfVendedor = vendedor;
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

	public Cliente(String nome, String email, Long cpfVendedor, Long cnpj,
			Boolean subscricaoAtiva) {
		super(nome, email);
		this.cpfVendedor = cpfVendedor;
		this.cnpj = cnpj;
		this.subscricaoAtiva = subscricaoAtiva;
	}
	
	public Cliente() {
		super();
	}

}
