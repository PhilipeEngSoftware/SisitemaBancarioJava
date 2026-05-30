
import java.time.LocalDateTime;

public class Transacao {
    private TipoTransacao tipo;
    private double valor;
    private LocalDateTime data;
    private String descricao;

    public Transacao(TipoTransacao tipo, double valor, String descricao) {
        this.tipo = tipo;
        this.valor = valor;
        this.descricao = descricao;
        this.data = LocalDateTime.now();


    }
    public TipoTransacao getTipo() {
        return tipo;
    }
    public double getValor(){
        return valor;
    }
    public LocalDateTime getData(){
        return data;
    }
    public String getDescricao(){
        return descricao;
    }
    

}
