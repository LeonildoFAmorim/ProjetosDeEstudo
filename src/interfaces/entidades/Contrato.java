package interfaces.entidades;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contrato {
    private int numero;
    private Date data;
    private double valor;

    private static List<Parcela> parcelas = new ArrayList<Parcela>();

    public Contrato(){

    }

    public Contrato(int numero, Date data, double valor) {
        this.numero = numero;
        this.data = data;
        this.valor = valor;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public List<Parcela> getParcelas() {
        return parcelas;
    }

    public void removerParcela(Parcela parcela){
        parcelas.remove(parcela);
    }

    public void adicionarParcela(Parcela parcela){
        parcelas.add(parcela);
    }
}
