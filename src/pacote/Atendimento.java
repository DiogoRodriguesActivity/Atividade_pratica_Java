package pacote;

public class Atendimento {
	private Sala sala;
	private Procedimento procedimento;
	private String Codigo_Atendimento;
	private String nome_animal;
	private String especie;
	private String nome_Tutor;
	private String data;
	private String horario;
	private String status;
	private String observacoes;

	public Atendimento(Sala sala, Procedimento procedimento, String codigo_Atendimento, String nome_animal,
			String especie, String nome_Tutor, String data, String horario, String status, String observacoes) {
		this.sala = sala;
		this.procedimento = procedimento;
		this.Codigo_Atendimento = codigo_Atendimento;
		this.nome_animal = nome_animal;
		this.especie = especie;
		this.nome_Tutor = nome_Tutor;
		this.data = data;
		this.horario = horario;
		this.status = status;
		this.observacoes = observacoes;
	}

	public String getCodigo_Atendimento() {
		return Codigo_Atendimento;
	}

	public void setCodigo_Atendimento(String codigo_Atendimento) {
		Codigo_Atendimento = codigo_Atendimento;
	}

	public String getNome_animal() {
		return nome_animal;
	}

	public void setNome_animal(String nome_animal) {
		this.nome_animal = nome_animal;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public String getNome_Tutor() {
		return nome_Tutor;
	}

	public void setNome_Tutor(String nome_Tutor) {
		this.nome_Tutor = nome_Tutor;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public Sala getSala() {
		return sala;
	}

	public Procedimento getProcedimento() {
		return procedimento;
	}

	// Compara o CONTEÚDO da string (equals), não a referência (==)
	public boolean isFinalizado() {
		return status.equalsIgnoreCase("finalizado");
	}

	@Override
	public String toString() {
		return "Atendimento " + Codigo_Atendimento + " | Animal: " + nome_animal + " (" + especie + ")"
				+ " | Tutor: " + nome_Tutor + " | " + data + " " + horario
				+ " | Status: " + status
				+ "\n    Veterinário: " + sala.getVeterinario().getNome()
				+ " | Sala: " + sala.getNumero()
				+ " | Procedimento: " + procedimento.getNome()
				+ "\n    Obs: " + observacoes;
	}
}
