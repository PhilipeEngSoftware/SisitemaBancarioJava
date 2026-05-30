import exception.SaldoInsuficienteException;

public class ContaPoupanca extends Conta {

    private double taxaJuros;

    public ContaPoupanca(String numeroConta, Cliente titular, double taxaJuros) {
        super(numeroConta, titular);
        this.taxaJuros = taxaJuros;
        //TODO Auto-generated constructor stub
    }

    @Override
    public void sacar(double novoSaldo) {
        // TODO Auto-generated method stub
        if(novoSaldo <= saldo){
            saldo = saldo - novoSaldo;
            Transacao transacao = new Transacao(TipoTransacao.SAQUE, novoSaldo, "Saque realizado");
            this.historico.add(transacao); 
        }else{
           throw new SaldoInsuficienteException("Saldo insuficiente para saque.");
        }

    }

    public void renderJuros() {
        saldo += saldo * taxaJuros / 100; 
    }


}
