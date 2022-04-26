package arquivos.alunos;

import java.util.List;

public class Aluno {
    private String nome;
    private List<Double> notas;

    public Aluno() {
    }

    public Aluno(String nome, List<Double> notas) {
        this.nome = nome;
        this.notas = notas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Double> getNotas() {
        return notas;
    }

    private double media(List<Double> notas) {
        double soma = 0;
        for (Double nota : notas) {
            soma += nota;
        }
        return soma / notas.size();
    }

    @Override
    public String toString() {
        return nome + " = " + " media: " + String.format("%.2f", media(notas));
    }
}



