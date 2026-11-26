package pacote;

public class Procedimento {
	private String nome;
	private String tipoSalaExigido;
	private double valor;

	public Procedimento(String nome, String tipoSalaExigido, double valor) {
		this.nome = nome;
		this.tipoSalaExigido = tipoSalaExigido;
		this.valor = valor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipoSalaExigido() {
		return tipoSalaExigido;
	}

	public void setTipoSalaExigido(String tipoSalaExigido) {
		this.tipoSalaExigido = tipoSalaExigido;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return nome + " | Sala exigida: " + tipoSalaExigido + " | R$ " + valor;
	}
}
