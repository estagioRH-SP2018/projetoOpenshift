package redhat;

public abstract class Pessoa {

	private String nome;
	private Integer idade;
	private String email;
	private Long cpf;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public Pessoa(String nome, Integer idade, String email, Long cpf) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.email = email;
		this.cpf = cpf;
	}

	public Pessoa() {
		super();
	}

}
