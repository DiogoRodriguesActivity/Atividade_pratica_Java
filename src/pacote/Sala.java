package pacote;

import java.util.ArrayList;
import java.util.List;

public class Sala {
	private Veterinario veterinario;
	private int numero;
	private String bloco;
	private int capacidade;
	private String tipo_sala;
	private List<Atendimento> atendimentos = new ArrayList<>();

	public Sala(Veterinario Pveterinario, int numero, String bloco, int capacidade, String tipo_sala) {
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

	public List<Atendimento> getAtendimentos() {
		return atendimentos;
	}

	// Atendimentos que ainda ocupam a sala (não finalizados)
	public int contarEmAndamento() {
		int cont = 0;
		for (Atendimento a : atendimentos) {
			if (!a.isFinalizado()) {
				cont++;
			}
		}
		return cont;
	}

	public int contarFinalizados() {
		int cont = 0;
		for (Atendimento a : atendimentos) {
			if (a.isFinalizado()) {
				cont++;
			}
		}
		return cont;
	}

	// Valida capacidade e compatibilidade antes de adicionar
	public boolean adicionarAtendimento(Atendimento a) {
		if (!tipo_sala.equalsIgnoreCase(a.getProcedimento().getTipoSalaExigido())) {
			System.out.println("Procedimento incompatível: exige sala do tipo "
					+ a.getProcedimento().getTipoSalaExigido() + ".");
			return false;
		}
		if (contarEmAndamento() >= capacidade) {
			System.out.println("Sala lotada (capacidade: " + capacidade + ").");
			return false;
		}
		atendimentos.add(a);
		return true;
	}
}
