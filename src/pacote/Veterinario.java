package pacote;

public class Veterinario {
	private String nome;
	private String Cpf;
	private String especialidade;
	private String telefone;
	
	public Veterinario(String Pnome, String PCpf, String Pespecialidade, String Ptelefone ) {
		this.nome = Pnome;
		this.Cpf = PCpf;
		this.especialidade = Pespecialidade;
		this.telefone = Ptelefone;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return Cpf;
	}

	public void setCpf(String cpf) {
		Cpf = cpf;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	
	
}
