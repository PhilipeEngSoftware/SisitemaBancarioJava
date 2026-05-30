
import java.util.ArrayList;
import java.util.List;

public abstract class Conta {
    private String numeroConta;
    private Cliente titular;
    protected  double saldo;
    protected List<Transacao> historico;

    public Conta(String numeroConta, Cliente titular){
        this.historico = new ArrayList<>();
        this.numeroConta = numeroConta;
        this.titular = titular;
        this.historico = new ArrayList<>();

    }
    protected void depositar(double novoSaldo) {
        this.saldo += novoSaldo;
        Transacao transacao = new Transacao(TipoTransacao.DEPOSITO, novoSaldo, "Desposito Realizado");
        this.historico.add(transacao);
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
    protected void registrarTransacao(Transacao transacao) {
        this.historico.add(transacao);
    }
    public void exibirHistorico(){
        for(Transacao transacao : historico){
            System.out.println("Tipo: " + transacao.getTipo());
            System.out.println("Valor: " + transacao.getValor());
            System.out.println("Data: " + transacao.getData());
            System.out.println("Descrição: " + transacao.getDescricao());
            System.out.println("-----------------------------");
        }
        
    }

    



}
