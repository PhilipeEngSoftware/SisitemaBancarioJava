import java.util.Scanner;

import exception.ContaNaoEncontradaException;
import exception.SaldoInsuficienteException;

public class Menu {
    public void iniciar() {
        Banco banco = new Banco();
        Scanner scanner = new Scanner(System.in);
        String opcao = scanner.nextLine();

        while(!opcao.equals("0")){
                
                System.out.println("Bem-vindo ao Banco! Escolha uma opção:");
                System.out.println("1 - Cadastrar cliente");
                System.out.println("2 - Abrir conta");
                System.out.println("3 - Depositar");
                System.out.println("4 - Sacar");
                System.out.println("5 - Ver saldo");
                System.out.println("6 - Listar contas");
                System.out.println("0 - Sair");
            opcao = scanner.nextLine();
            switch(opcao){
                case "1":
                    System.out.println("Digite o nome do cliente:");
                    String nome = scanner.nextLine();
                    System.out.println("Digite o CPF do cliente:");
                    String cpf = scanner.nextLine();
                    Cliente cliente = new Cliente(nome, cpf);
                    banco.adicionarCliente(cliente);
                    break;
                case "2":   
                    System.out.println("Digite o CPF do cliente:");
                    String cpfcliente = scanner.nextLine();
                    System.out.println("Digite o da conta Corrente ou Poupança");
                    String tipo = scanner.nextLine();
                    banco.abrirConta(cpfcliente,tipo);
                    break;
                    
                     // abrir conta
                case "3": // depositar
                    try {
                        System.out.println("qual numero da conta"); 
                        String numeroConta = scanner.nextLine();
                        Conta conta = banco.buscarConta(numeroConta);
                        if(conta != null){
                            System.out.println("Qual valor deseja depositar?");
                            double valor = scanner.nextDouble();
                            conta.depositar(valor);
                        }    
                    } catch (SaldoInsuficienteException e) {
                        System.out.println("Saldo insuficiente. " + e.getMessage());
                    } catch (ContaNaoEncontradaException e) {
                        System.out.println("Conta não encontrada. " + e.getMessage());

                    
                    }

                    break;
                case "4": // sacar
                    try {
                        System.out.println("qual numero da conta"); 
                        String numeroConta1 = scanner.nextLine();
                        Conta conta1 = banco.buscarConta(numeroConta1);
                        if(conta1 != null){
                            System.out.println("Qual valor deseja sacar?");
                            double valor = scanner.nextDouble();
                            conta1.sacar(valor);
                        }
                    } catch (SaldoInsuficienteException e) {    
                        System.out.println("Saldo insuficiente. " + e.getMessage());
                    } catch (ContaNaoEncontradaException e) {
                        System.out.println("Conta não encontrada. " + e.getMessage());
                    }
                    break;
                case "5": // ver saldo
                    System.out.println("qual numero da conta");
                    String numeroConta2 = scanner.nextLine();
                    Conta conta2 = banco.buscarConta(numeroConta2);
                    if(conta2 != null){
                        System.out.println("Saldo: " + conta2.getSaldo());
                    }
                    break;
                
                case "6": // listar contas
                    System.out.println("Listando contas:");
                    banco.listaContas();
                    break;
                case "0": // sair
                    System.out.println("Saindo do sistema. Obrigado por usar o Banco!");
                    break;
                default:  // opção inválida   
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                    break;
            }
            
        }
    }   

}
