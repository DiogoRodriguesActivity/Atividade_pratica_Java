package pacote;

import java.util.ArrayList;
import java.util.List;

public class Clinica {
	private List<Veterinario> veterinarios = new ArrayList<>();
	private List<Sala> salas = new ArrayList<>();
	private List<Procedimento> procedimentos = new ArrayList<>();
	private List<Atendimento> atendimentos = new ArrayList<>(); // histórico geral

	public List<Veterinario> getVeterinarios() {
		return veterinarios;
	}

	public List<Sala> getSalas() {
		return salas;
	}

	public List<Procedimento> getProcedimentos() {
		return procedimentos;
	}

	public List<Atendimento> getAtendimentos() {
		return atendimentos;
	}

	public void cadastrarVeterinario(Veterinario v) {
		veterinarios.add(v);
	}

	public void cadastrarProcedimento(Procedimento p) {
		procedimentos.add(p);
	}

	// Um veterinário só pode estar em uma sala
	public boolean cadastrarSala(Sala nova) {
		for (Sala s : salas) {
			if (s.getNumero() == nova.getNumero()) {
				System.out.println("Já existe uma sala com esse número.");
				return false;
			}
			if (s.getVeterinario() == nova.getVeterinario()) {
				System.out.println("Esse veterinário já está associado à sala " + s.getNumero() + ".");
				return false;
			}
		}
		salas.add(nova);
		return true;
	}

	public boolean cadastrarAtendimento(Atendimento a) {
		if (buscarAtendimento(a.getCodigo_Atendimento()) != null) {
			System.out.println("Já existe um atendimento com esse código.");
			return false;
		}
		if (a.getSala().adicionarAtendimento(a)) {
			atendimentos.add(a);
			return true;
		}
		return false;
	}

	public Veterinario buscarVeterinario(String cpf) {
		for (Veterinario v : veterinarios) {
			if (v.getCpf().equals(cpf)) {
				return v;
			}
		}
		return null;
	}

	public Sala buscarSala(int numero) {
		for (Sala s : salas) {
			if (s.getNumero() == numero) {
				return s;
			}
		}
		return null;
	}

	public Procedimento buscarProcedimento(String nome) {
		for (Procedimento p : procedimentos) {
			if (p.getNome().equalsIgnoreCase(nome)) {
				return p;
			}
		}
		return null;
	}

	public Atendimento buscarAtendimento(String codigo) {
		for (Atendimento a : atendimentos) {
			if (a.getCodigo_Atendimento().equalsIgnoreCase(codigo)) {
				return a;
			}
		}
		return null;
	}
}
