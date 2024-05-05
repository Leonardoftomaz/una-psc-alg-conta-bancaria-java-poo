import java.util.Scanner;

class ContaBancaria {
    private String nome;
    private int numeroConta;
    private double saldo;

    public ContaBancaria(String nome, int numeroConta, double saldoInicial) {
        this.nome = nome;
        this.numeroConta = numeroConta;
        this.saldo = saldoInicial;
    }

    public void depositar(double valor) {
        saldo += valor;
        System.out.println("Depósito de R$ " + valor + " realizado com sucesso.");
    }

    public void sacar(double valor) {
        if (valor > saldo) {
            System.out.println("Saldo insuficiente para realizar a operação.");
        } else if (valor > 5000) {
            System.out.println("Valor do saque acima do permitido.");
        } else {
            saldo -= valor;
            System.out.println("Saque de R$ " + valor + " realizado com sucesso.");
        }
    }

    public double getSaldo() {
        return saldo;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar informações ao usuário
        System.out.print("Digite o nome da pessoa: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o número da conta: ");
        int numeroConta = scanner.nextInt();
        System.out.print("Digite o saldo inicial: ");
        double saldoInicial = scanner.nextDouble();

        ContaBancaria conta = new ContaBancaria(nome, numeroConta, saldoInicial);
        System.out.println("Conta bancária criada com sucesso.");

        while (true) {
            System.out.println("\nEscolha uma operação:");
            System.out.println("1. Depositar");
            System.out.println("2. Sacar");
            System.out.println("3. Verificar saldo");
            System.out.println("4. Sair");

            int escolha = scanner.nextInt();
            double valor;

            switch (escolha) {
                case 1:
                    System.out.print("Digite o valor a depositar: ");
                    valor = scanner.nextDouble();
                    conta.depositar(valor);
                    break;
                case 2:
                    System.out.print("Digite o valor a sacar: ");
                    valor = scanner.nextDouble();
                    conta.sacar(valor);
                    break;
                case 3:
                    System.out.println("Saldo disponível: R$ " + conta.getSaldo());
                    break;
                case 4:
                    System.out.println("Saindo do programa...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        }
    }
}
