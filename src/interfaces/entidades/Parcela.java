package interfaces.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Parcela {

    private Date dataVencimento;
    private double valorParcela;

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Parcela(){

    }

    public Parcela(Date dataVencimento, double valorParcela) {
        this.dataVencimento = dataVencimento;
        this.valorParcela = valorParcela;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public double getValorParcela() {
        return valorParcela;
    }

    public void setValorParcela(double valorParcela) {
        this.valorParcela = valorParcela;
    }

    @Override
    public String toString() {
        return "Parcela{" +
                "dataVencimento=" + sdf.format(dataVencimento) +
                ", valorParcela=" + String.format("%.2f", valorParcela) +
                '}';
    }
}
