package pacote;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		System.out.println("Hello World");
		System.out.println("====================");
		System.out.println("==Sistema Clínico==");
		System.out.println("====================");
		
		
		
		Veterinario vet = new Veterinario("Joao", "100.100.100-23", "Dentista", 999929999);
		Sala sala = new Sala(vet, 102, "15A", 20, "Azul");
		Atendimento atend = new Atendimento(sala, "OX002", "Beca", "Golden", "Carlos", "10/09/2026", "10:34", "finalizado", "Cachorro calmo"); 
		Atendimento atend2 = new Atendimento(sala, "PX003", "Thor", "Xau-Xau", "Valdemir", "10/09/2026", "10:50", "em-observacao", "Cachorro bravo"); 
		
				
		
		System.out.println("Nome do Veterinario: " +   atend.getSala().getVeterinario().getNome());
		System.out.println("sala: " + 				   atend.getSala().getNumero());
		System.out.println("Numero do atendimento: " + atend.getCodigo_Atendimento());
		System.out.println("Nome do Veterinario: " +   atend2.getSala().getVeterinario().getNome());
		System.out.println("sala: " + 				   atend2.getSala().getNumero());
		System.out.println("Numero do atendimento: " + atend2.getCodigo_Atendimento());
		System.out.println("Total de atendimentos finalizados: " + (atend.getfinaliza() + atend2.getfinaliza()));
		System.out.println("===========================================");
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Informe o Status da Consulta: ");
		String status = scan.next();
		
		if(status == atend.getStatus()) {
			System.out.println("Nome do Veterinario: " +   atend.getSala().getVeterinario().getNome());
			System.out.println("sala: " + 				   atend.getSala().getNumero());
			System.out.println("Numero do atendimento: " + atend.getCodigo_Atendimento());
		}
		else if(status == atend2.getStatus()) {
			System.out.println("Nome do Veterinario: " +   atend2.getSala().getVeterinario().getNome());
			System.out.println("sala: " + 				   atend2.getSala().getNumero());
			System.out.println("Numero do atendimento: " + atend2.getCodigo_Atendimento());
		}
		else {
			
				System.out.println("Status desconhecido !");

		}
		
		
		scan.close();
		
		
		
		
		
		
//		Veterinario obj = new Veterinario("Diogo", "100.100.100-10", "Dentista", 999929999);
//		Sala sala = new Sala(obj, 102, "15A", 20, "Azul");
//		
//		System.out.println("Nome do Veterinario: " + sala.getVeterinario().getNome());
//		System.out.println("Responsavel pela sala: " + sala.getNumero());
		

	}

}
