package banco_krueger;
//Esse é o projeto de entrega algumas funçoes não estão funcionado,e a outra classe nesse projeto foi apenas para me organizar melhor durante o projeto\\
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public abstract class Conta {
    private int numero;
    private String cpf;
    private double saldo;
    private boolean ativo;
    private int numMovimentos = 10;

    public Conta(int numero, String cpf) {
        this.numero = numero;
        this.cpf = cpf;
        this.saldo = 25000.0;
        this.ativo = true;
    
    }

    public int getNumero() {
        return numero;
    }

    public String getCpf() {
        return cpf;
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean isAtivo() {
        return ativo;
    }

    protected void debito(double valor) {
        saldo -= valor;
    }

    protected void credito(double valor) {
        saldo += valor;
    }

    public abstract void correcao();

    public void solicitarCheque() {
        
    }

    public void usarLimite(double valor) {
        saldo += valor;
        if (saldo < 0) {
            saldo = 0;
            double diferenca = -saldo;
            if (diferenca > 1000) {
                diferenca = 1000;
            }
            limite = diferenca;
        }
    }

    public void solicitarEmprestimo(double valor) {
        
    }

    public void solicitarEmprestimoEstudantil(double valor) {
       
    }

	public int getNumMovimentos() {
		return numMovimentos;
	}

	public void setNumMovimentos(int numMovimentos) {
		this.numMovimentos = numMovimentos;
	}
	
	public void NumMovimentos (int valor) {
		if (valor > 10) {
		System.out.println("Limite de movimentações atingido. Tente novamente amanhã.");	
		}
	}
	
}

public class ContaCorrente extends Conta {
    private int contadorTalao;

    public ContaCorrente(int numero, String cpf) {
        super(numero, cpf);
        this.contadorTalao = 0;
    }

    public int getContadorTalao() {
        return contadorTalao;
    }

    public void pedirTalao() {
        if (getSaldo() >= 30.0 && contadorTalao < 3) {
            debito(30.0);
            contadorTalao++;
        }
    }

    @Override
    public void correcao() {
        
    }
}

public class ContaPoupanca extends Conta {
    private int diaAniversario;

    public ContaPoupanca(int numero, String cpf, int diaAniversario) {
        super(numero, cpf);
        this.diaAniversario = diaAniversario;
    }

    public int getDiaAniversario() {
        return diaAniversario;
    }

    @Override
    public void correcao() {
        int diaAtual = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        if (diaAtual == diaAniversario) {
            double valorCorrecao = getSaldo() * 0.05;
            credito(valorCorrecao);
        }
    }
}

public class ContaEspecial extends Conta {
    private double limite;

    public ContaEspecial(int numero, String cpf) {
        super(numero, cpf);
        this.limite = 1000.0;
    }

    public double getLimite() {
        return limite;
    }

    @Override
    public void correcao() {
        
    }
}

public class ContaEmpresa extends Conta {
    private double emprestimo;

    public ContaEmpresa(int numero, String cpf) {
        super(numero, cpf);
        this.emprestimo = 10000.0;
        String resposta;
		if (resposta.equalsIgnoreCase("S")) {
            System.out.println("Empréstimo aceito!");
        } else {
            System.out.println("Empréstimo recusado!");
        }
	}
   
    public double getEmprestimo() {
    	return emprestimo;
    }
    @Override
    public void correcao() {
    	
    }
}   

public class ContaEstudantil extends Conta {
	private double emprestimoEstudantil;
		
	public ContaEstudantil(int numero, String cpf) {
		super(numero, cpf);
		this.emprestimoEstudantil = 5000.0;
		String resposta;
		if (resposta.equalsIgnoreCase("S")) {
            System.out.println("Empréstimo aceito!");
        } else {
            System.out.println("Empréstimo recusado!");
        }
	}
	public double getEmprestimoEstudantil() {
		return emprestimoEstudantil;
	}
	@Override
	public void correcao() {
		
	}
	
@Override
public String toString() {
	return "\nNúmero da conta: " + this.getNumero() +
		   "\nCPF: " + this.getCpf() +
		   "\nSaldo: " + this.getSaldo();}
		
	
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
		
		
		operacoes();
		
	}
	
	

		
	
		
	
}
	





   
