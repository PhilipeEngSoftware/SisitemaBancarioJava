

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nome;
    private String cpf;
    private List<Conta> contas;

    public Cliente(String nome, String cpf){
        this.nome = nome;
        this.cpf = cpf;
        this.contas = new ArrayList<>();
    }
    public String getNome(){
        return this.nome;
    }
    public String getCpf(){
        return this.cpf;
    }
    public List<Conta> getContas(){
        return this.contas;
    }
    public void cadastrarConta(Conta conta){
        this.contas.add(conta);
    }

}

