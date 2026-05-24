
import java.util.ArrayList;
import java.util.List;

public abstract class Conta {
    private String numeroConta;
    private Cliente titular;
    protected  double saldo;
    private List<Transacao> historico;

    public Conta(String numeroConta, Cliente titular){
        this.numeroConta = numeroConta;
        this.titular = titular;
        this.historico = new ArrayList<>();

    }
    protected void depositar(double novoSaldo) {
        this.saldo += novoSaldo;
    }
    public abstract void sacar(double novoSaldo);
    
    public String getNumeroConta(){
        return numeroConta;
    }
    public String getTitular(){
        return this.titular.getNome();
    }
    public double getSaldo(){
        return this.saldo;
    }
    public List<Transacao> getHistorico(){
        return this.historico;
    }


    



}
