package heranca_polimorfismo.produto.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ProdutoUsado extends Produto {
    private Date dataFabricacao;

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public ProdutoUsado() {

    }

    public ProdutoUsado(String nome, double preco, Date dataFabricacao) {
        super(nome, preco);
        this.dataFabricacao = dataFabricacao;
    }

    public Date getDataFabricacao() {
        return dataFabricacao;
    }

    public void setDataFabricacao(Date dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }

    @Override
    public String toString() {
        return getNome() + " (usado) " + " $ " + String.format("%.2f", getPreco()) + " (data de frabricacao " + sdf.format(dataFabricacao) + ")";
    }
}
