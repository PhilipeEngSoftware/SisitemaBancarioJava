import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import exception.ContaNaoEncontradaException;


public class Banco {
    private Map<String, Cliente> clientes;
    private Map<String, Conta> contas;

    public Banco(){
        this.clientes = new HashMap<>();
        this.contas = new HashMap<>();

    }
    public void adicionarCliente(Cliente cliente){
        this.clientes.put(cliente.getCpf(), cliente);
    }

    public Conta buscarConta(String numeroConta){
        Conta conta = this.contas.get(numeroConta);
        if (conta == null) {
            throw new ContaNaoEncontradaException("Conta não encontrada.");
        }
        return conta;
    }

    public void listaContas(){
        for(Conta conta : contas.values()){
            System.out.println("Conta: " + conta.getNumeroConta());
            System.out.println("Titular: " + conta.getTitular());
            System.out.println("Saldo: " + conta.getSaldo());
        }
    }

    public void abrirConta(String cpf, String tipo){
        Cliente cliente = this.clientes.get(cpf);
        String numeroConta = String.valueOf(contas.size() + 1);
    
        if(tipo.equals("corrente")){
            ContaCorrente contaCorrente = new ContaCorrente(numeroConta, cliente, 1000.0);
            this.contas.put(numeroConta, contaCorrente);
            cliente.cadastrarConta(contaCorrente);
        }else if(tipo.equals("poupanca")){
            ContaPoupanca contaPoupanca = new ContaPoupanca(numeroConta, cliente, 0);
            this.contas.put(numeroConta, contaPoupanca);
            cliente.cadastrarConta(contaPoupanca);
        }
    }





}
