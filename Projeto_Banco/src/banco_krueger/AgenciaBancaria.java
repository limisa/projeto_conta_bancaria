package banco_krueger;

import java.util.ArrayList;
import java.util.Scanner;

public class AgenciaBancaria {

	static Scanner input = new Scanner(System.in);
	static ArrayList<Conta> contasBancarias;
	
	public static void main(String[] args) {
		contasBancarias = new ArrayList<Conta>();
		operacoes();	
	}
	
	public static void operacoes () {
		
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("---------------------Bem vinda ao Banco Krueger------------------------");
		System.out.println("------------Onde estamos com você até nos seus sonhos------------------");
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("*******************Selecione uma das opções abaixo*********************");
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("|		Opção 1 - Conta Poupança		|");
		System.out.println("|		Opção 2 - Conta Corrente		|");
		System.out.println("|		Opção 3 - Conta Especial		|");
		System.out.println("|		Opção 4 - Conta Empresa			|");
		System.out.println("|		Opção 5 - Conta Estudantil		|");
		System.out.println("|		Opção 6 - Sair					|");
		System.out.println("Digite o código da opção selecionada:	 ");
		
		int operacao = input.nextInt();
		
		switch (operacao) {
		case 1:
			ContaPoupanca();
			break;
		case 2:
			ContaCorrente();
			break;
		case 3:
			ContaEspecial();
			break;
		case 4:
			ContaEmpresa();
			break;
		case 5:
			ContaEstudantil();
			break;
		case 6:
			System.out.println("Obrigada por usar o banco dos sonhos, nos vemos mais tarde!");
			System.exit(0);
			
		default:
			System.out.println("Opção inválida!");
			operacoes();
			break;
		
		}
	}
	
	public static void ContaPoupanca() {
		System.out.println("\nBanco Krueger");
		System.out.println("\nOnde estamos com você até nos seus sonhos");
		
		System.out.println("Conta Poupança");
		String contaPoupanca = input.next();
		
		System.out.println("Saldo atual: R$#####.#");
		String saldo = input.next();
		
		System.out.println("Movimento D-Débito ou C-Crédito: ");
		System.out.println("Valor movimentado: R$#####.#");
		
		Conta conta = new Conta(contaPoupanca, saldo);
		
		contasBancarias.add(conta);
		
		operacoes();
	}
	private static void ContaCorrente() {
		System.out.println("\nBanco Krueger");
		System.out.println("\nOnde estamos com você até nos seus sonhos");
		
		System.out.println("Conta Corrente");
		String contaCorrente = input.next();
		
		System.out.println("Saldo atual: R$#####.#");
		String saldo = input.next();
		
		System.out.println("Movimento D-Débito ou C-Crédito: ");
		System.out.println("Valor movimentado: R$#####.#");
		
		
		Conta conta = new Conta(contaCorrente, saldo);
		
		contasBancarias.add(conta);
		
		operacoes();
		
	}
	public static void ContaEspecial() {
		System.out.println("\nBanco Krueger");
		System.out.println("\nOnde estamos com você até nos seus sonhos");
		
		System.out.println("Conta Especial");
		String contaEspecial = input.next();
		
		System.out.println("Saldo atual: R$#####.#");
		String saldo = input.next();
		
		System.out.println("Movimento D-Débito ou C-Crédito: ");
		System.out.println("Valor movimentado: R$#####.#");
		
		Conta conta = new Conta(contaEspecial, saldo);
		
		contasBancarias.add(conta);
		
		operacoes();
		
	}
	public static void ContaEmpresa() {
		System.out.println("\nBanco Krueger");
		System.out.println("\nOnde estamos com você até nos seus sonhos");
		
		System.out.println("Conta Empresa");
		String contaEmpresa = input.next();
		
		System.out.println("Saldo atual: R$#####.#");
		String saldo = input.next();
		
		System.out.println("Movimento D-Débito ou C-Crédito: ");
		System.out.println("Valor movimentado: R$#####.#");
		System.out.println("Você topa um emprestimo? 10 mil agora mesmo na sua conta! Aceita?");
		String resposta;
		if (resposta.equalsIgnoreCase("S")) {
            System.out.println("Empréstimo aceito!");
        } else {
            System.out.println("Empréstimo recusado!");
        }
		Conta conta = new Conta(contaEmpresa, saldo);
		
		contasBancarias.add(conta);
		
		operacoes();
		
	}	
	public static void ContaEstudantil() {
		System.out.println("\nBanco Krueger");
		System.out.println("\nOnde estamos com você até nos seus sonhos");
		
		System.out.println("Conta Estudantil");
		String contaEstudantil = input.next();
		
		System.out.println("Saldo atual: R$#####.#");
		String saldo = input.next();
		
		System.out.println("Movimento D-Débito ou C-Crédito: ");
		System.out.println("Valor movimentado: R$#####.#");
		System.out.println("Você topa um emprestimo? 5 mil agora mesmo na sua conta! Deseja aceitar (S/N)?");
		String resposta;
		if (resposta.equalsIgnoreCase("S")) {
            System.out.println("Empréstimo aceito!");
        } else {
            System.out.println("Empréstimo recusado!");
        }
		
		Conta conta = new Conta(contaEstudantil, saldo);
		
		contasBancarias.add(conta);
		
		operacoes();
		
	}
	
	

		
	
		
	
}
