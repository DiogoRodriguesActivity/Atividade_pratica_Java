package pacote;

import java.util.Scanner;

public class Main {
	private static Clinica clinica = new Clinica();
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		inicializarDados();

		int opcao;
		do {
			System.out.println("\n====================");
			System.out.println("==Sistema Clínico==");
			System.out.println("====================");
			System.out.println("1 - Cadastrar veterinário");
			System.out.println("2 - Cadastrar sala");
			System.out.println("3 - Cadastrar procedimento");
			System.out.println("4 - Cadastrar atendimento");
			System.out.println("5 - Listar atendimentos (histórico)");
			System.out.println("6 - Buscar atendimentos por status");
			System.out.println("7 - Finalizar atendimento");
			System.out.println("8 - Finalizados por sala");
			System.out.println("0 - Sair");
			opcao = lerInt("Opção: ");

			switch (opcao) {
			case 1: cadastrarVeterinario(); break;
			case 2: cadastrarSala(); break;
			case 3: cadastrarProcedimento(); break;
			case 4: cadastrarAtendimento(); break;
			case 5: listarAtendimentos(); break;
			case 6: buscarPorStatus(); break;
			case 7: finalizarAtendimento(); break;
			case 8: finalizadosPorSala(); break;
			case 0: System.out.println("Encerrando..."); break;
			default: System.out.println("Opção inválida!");
			}
		} while (opcao != 0);

		sc.close();
	}

	// Dados iniciais (os mesmos do seu Main antigo) para facilitar os testes
	private static void inicializarDados() {
		Veterinario vet = new Veterinario("Joao", "100.100.100-23", "Dentista", "999929999");
		clinica.cadastrarVeterinario(vet);

		Sala sala = new Sala(vet, 102, "15A", 20, "Azul");
		clinica.cadastrarSala(sala);

		Procedimento consulta = new Procedimento("Consulta", "Azul", 150.0);
		clinica.cadastrarProcedimento(consulta);

		clinica.cadastrarAtendimento(new Atendimento(sala, consulta, "OX002", "Beca", "Golden", "Carlos",
				"10/09/2026", "10:34", "finalizado", "Cachorro calmo"));
		clinica.cadastrarAtendimento(new Atendimento(sala, consulta, "PX003", "Thor", "Xau-Xau", "Valdemir",
				"10/09/2026", "10:50", "em-observacao", "Cachorro bravo"));
	}

	// 1
	private static void cadastrarVeterinario() {
		System.out.print("Nome: ");
		String nome = sc.nextLine();
		System.out.print("CPF: ");
		String cpf = sc.nextLine();
		System.out.print("Especialidade: ");
		String esp = sc.nextLine();
		System.out.print("Telefone: ");
		String tel = sc.nextLine();

		if (clinica.buscarVeterinario(cpf) != null) {
			System.out.println("Já existe um veterinário com esse CPF.");
			return;
		}
		clinica.cadastrarVeterinario(new Veterinario(nome, cpf, esp, tel));
		System.out.println("Veterinário cadastrado!");
	}

	// 2
	private static void cadastrarSala() {
		for (Veterinario v : clinica.getVeterinarios()) {
			System.out.println(v.getNome() + " | CPF: " + v.getCpf());
		}
		System.out.print("CPF do veterinário: ");
		Veterinario vet = clinica.buscarVeterinario(sc.nextLine());
		if (vet == null) {
			System.out.println("Veterinário não encontrado.");
			return;
		}

		int numero = lerInt("Número da sala: ");
		System.out.print("Bloco: ");
		String bloco = sc.nextLine();
		int capacidade = lerInt("Capacidade: ");
		System.out.print("Tipo da sala: ");
		String tipo = sc.nextLine();

		if (clinica.cadastrarSala(new Sala(vet, numero, bloco, capacidade, tipo))) {
			System.out.println("Sala cadastrada!");
		}
	}

	// 3
	private static void cadastrarProcedimento() {
		System.out.print("Nome do procedimento: ");
		String nome = sc.nextLine();
		System.out.print("Tipo de sala exigido: ");
		String tipo = sc.nextLine();
		System.out.print("Valor: ");
		double valor = Double.parseDouble(sc.nextLine());

		clinica.cadastrarProcedimento(new Procedimento(nome, tipo, valor));
		System.out.println("Procedimento cadastrado!");
	}

	// 4
	private static void cadastrarAtendimento() {
		for (Sala s : clinica.getSalas()) {
			System.out.println("Sala " + s.getNumero() + " | Tipo: " + s.getTipo_sala()
					+ " | Vet: " + s.getVeterinario().getNome());
		}
		Sala sala = clinica.buscarSala(lerInt("Número da sala: "));
		if (sala == null) {
			System.out.println("Sala não encontrada.");
			return;
		}

		for (Procedimento p : clinica.getProcedimentos()) {
			System.out.println(p);
		}
		System.out.print("Nome do procedimento: ");
		Procedimento proc = clinica.buscarProcedimento(sc.nextLine());
		if (proc == null) {
			System.out.println("Procedimento não encontrado.");
			return;
		}

		System.out.print("Código do atendimento: ");
		String codigo = sc.nextLine();
		System.out.print("Nome do animal: ");
		String animal = sc.nextLine();
		System.out.print("Espécie: ");
		String especie = sc.nextLine();
		System.out.print("Nome do tutor: ");
		String tutor = sc.nextLine();
		System.out.print("Data: ");
		String data = sc.nextLine();
		System.out.print("Horário: ");
		String horario = sc.nextLine();
		System.out.print("Status: ");
		String status = sc.nextLine();
		System.out.print("Observações: ");
		String obs = sc.nextLine();

		Atendimento a = new Atendimento(sala, proc, codigo, animal, especie, tutor, data, horario, status, obs);
		if (clinica.cadastrarAtendimento(a)) {
			System.out.println("Atendimento cadastrado!");
		}
	}

	// 5
	private static void listarAtendimentos() {
		System.out.println("\n--- Atendimentos ---");
		if (clinica.getAtendimentos().isEmpty()) {
			System.out.println("Nenhum atendimento cadastrado.");
		}
		for (Atendimento a : clinica.getAtendimentos()) {
			System.out.println(a);
		}
	}

	// 6 - substitui o if com == do Main antigo
	private static void buscarPorStatus() {
		System.out.print("Informe o Status da Consulta: ");
		String status = sc.nextLine();

		boolean achou = false;
		for (Atendimento a : clinica.getAtendimentos()) {
			if (a.getStatus().equalsIgnoreCase(status)) {
				System.out.println(a);
				achou = true;
			}
		}
		if (!achou) {
			System.out.println("Status desconhecido ou sem atendimentos !");
		}
	}

	// 7
	private static void finalizarAtendimento() {
		System.out.print("Código do atendimento: ");
		Atendimento a = clinica.buscarAtendimento(sc.nextLine());
		if (a == null) {
			System.out.println("Atendimento não encontrado.");
			return;
		}
		a.setStatus("finalizado");
		System.out.println("Atendimento finalizado!");
	}

	// 8
	private static void finalizadosPorSala() {
		int total = 0;
		for (Sala s : clinica.getSalas()) {
			System.out.println("Sala " + s.getNumero() + ": " + s.contarFinalizados() + " finalizado(s)");
			total += s.contarFinalizados();
		}
		System.out.println("Total de atendimentos finalizados: " + total);
	}

	private static int lerInt(String mensagem) {
		System.out.print(mensagem);
		try {
			return Integer.parseInt(sc.nextLine().trim());
		} catch (NumberFormatException e) {
			return -1;
		}
	}
}
