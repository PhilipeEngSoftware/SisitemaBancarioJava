import exception.SaldoInsuficienteException;

public class ContaCorrente extends Conta {
    private double limite;

    public ContaCorrente(String numeroConta, Cliente titular, double limite) {
        super(numeroConta, titular);
        this.limite = limite;
    }

 
    @Override
    public void sacar(double novoSaldo) {
       double saldoDisponivel  = saldo + limite; 
        if (novoSaldo <= saldoDisponivel) {
            System.out.println("aque comcluido.");
            this.saldo -= novoSaldo;
        }else {
            throw new SaldoInsuficienteException("Saldo insuficiente para saque.");
        }
        
        
    }
    public double getLimite(){
        return this.limite;
    }
}
