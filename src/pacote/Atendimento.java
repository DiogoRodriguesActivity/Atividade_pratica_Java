package pacote;

public class Atendimento {
	private Sala sala;
	private String Codigo_Atendimento;
	private String nome_animal;
	private String especie;
	private String nome_Tutor;
	private String data;
	private String horario;
	private String status;
	private String observacoes;
	
	private int finaliza;
	
	public Atendimento(Sala sala, String codigo_Atendimento, String nome_animal, String especie, String nome_Tutor, String data, String horario, String status, String observacoes) {
		this.sala = sala;
		this.Codigo_Atendimento = codigo_Atendimento;
		this.nome_animal = nome_animal;
		this.especie = especie;
		this.nome_Tutor = nome_Tutor;
		this.data = data;
		this.horario = horario;
		this.status = status;
		this.observacoes = observacoes;
		this.finaliza = somaFinalizados();
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
	
	public int getfinaliza() {
		return finaliza;
	}
	
	
	public int somaFinalizados() {
		
		int cont = 0;
		if (this.getStatus() == "finalizado") {
		  cont++;
	  }
		return cont;
		
	}
	
	
	
}
