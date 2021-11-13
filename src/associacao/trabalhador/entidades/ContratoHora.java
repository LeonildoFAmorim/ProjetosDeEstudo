package associacao.trabalhador.entidades;

import java.util.Date;

public class ContratoHora {
    private Date data;
    private double valorHora;
    private Integer qtdHoras;

    public ContratoHora() {

    }

    public ContratoHora(Date data, double valorHora, int qtHoras) {
        this.data = data;
        this.valorHora = valorHora;
        this.qtdHoras = qtHoras;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double getValorHora() {
        return valorHora;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }

    public int getQtHoras() {
        return qtdHoras;
    }

    public void setQtHoras(int qtHoras) {
        this.qtdHoras = qtHoras;
    }

    public double valorDoContrato() {
        return valorHora * qtdHoras;
    }
}
