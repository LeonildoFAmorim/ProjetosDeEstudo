package associacao_enumeracao_trabalhador.entidades;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Trabalhador {
    private String nome;
    private NivelTrabalhador nivel;
    private double salarioBase;
    private Departamento departamento;
    private List<ContratoHora> contratos = new ArrayList<>();

    public Trabalhador() {

    }

    public Trabalhador(String nome, NivelTrabalhador nivel, double salarioBase, Departamento departamento) {
        this.nome = nome;
        this.nivel = nivel;
        this.salarioBase = salarioBase;
        this.departamento = departamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public NivelTrabalhador getNivel() {
        return nivel;
    }

    public void setNivel(NivelTrabalhador nivel) {
        this.nivel = nivel;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public List<ContratoHora> getContratos() {
        return contratos;
    }

    public void adicionarContrato(ContratoHora contrato) {
        contratos.add(contrato);
    }

    public void removerContrato(ContratoHora contrato) {
        contratos.remove(contrato);
    }

    public double calculaMensal(int mes, int ano) {
        Calendar calendario = Calendar.getInstance();
        double rendaMensal = salarioBase;
        for (ContratoHora contrato : contratos) {
            calendario.setTime(contrato.getData());
            int mesContrato = 1 + calendario.get(Calendar.MONTH);
            int anoContrato = calendario.get(Calendar.YEAR);
            if (mes == mesContrato && ano == anoContrato) {
                rendaMensal += contrato.valorDoContrato();
            }
        }
        return rendaMensal;
    }
}
