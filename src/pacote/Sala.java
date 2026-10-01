package pacote;

public class Sala {
	private Veterinario veterinario;
	private int numero;
	private String bloco;
	private int capacidade;
	private String tipo_sala;
	
	public Sala(Veterinario Pveterinario, int numero, String bloco, int capacidade,String tipo_sala ) {
		this.veterinario = Pveterinario;
		this.numero = numero;
		this.bloco = bloco;
		this.capacidade = capacidade;
		this.tipo_sala = tipo_sala;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getBloco() {
		return bloco;
	}

	public void setBloco(String bloco) {
		this.bloco = bloco;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}

	public String getTipo_sala() {
		return tipo_sala;
	}

	public void setTipo_sala(String tipo_sala) {
		this.tipo_sala = tipo_sala;
	}
	
	public Veterinario getVeterinario() {
		return veterinario;
	}
	
	
}
