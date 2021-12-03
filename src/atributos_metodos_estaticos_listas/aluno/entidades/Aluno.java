package atributos_metodos_estaticos_listas.aluno.entidades;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Aluno {
    private String nome;
    private int matricula;
    private double[] notas;

    public static List<Aluno> alunos = new ArrayList<>();
    public static List<Aluno> maioresMedias;
    public static List<Aluno> menoresMedias;
    public static List<Aluno>[] statusAlunos;

    public Aluno() {

    }

    public Aluno(String nome, int matricula, double[] notas) {
        this.nome = nome;
        this.matricula = matricula;
        this.notas = notas;
    }

    public static void adicionaAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public double[] getNotas() {
        return notas;
    }

    public void setNotas(double[] notas) {
        this.notas = notas;
    }

    private static double calculaMedia(double[] notas) {
        double somaNotas = 0;
        for (int i = 0; i < notas.length; i++) {
            somaNotas += notas[i];
        }
        return somaNotas / notas.length;
    }

    public static List<Aluno> verificaMaiorMedia(List<Aluno> alunos) {
        List<Aluno> maioresMedias = new ArrayList<>();
        double maiorMediaEncontrada = 0;
        for (int i = 0; i < alunos.size(); i++) {
            double mediaAtual = calculaMedia(alunos.get(i).notas);
            if (mediaAtual > maiorMediaEncontrada) {
                maioresMedias.clear();
                maioresMedias.add(alunos.get(i));
                maiorMediaEncontrada = mediaAtual;
            } else if (mediaAtual == maiorMediaEncontrada) {
                maioresMedias.add(alunos.get(i));
            }
        }
        return maioresMedias;
    }

    public static List<Aluno> verificaMenorMedia(List<Aluno> alunos) {
        List<Aluno> menoresMedias = new ArrayList<>();
        double menorMediaEncontrada = 0;
        for (int i = 0; i < alunos.size(); i++) {
            double mediaAtual = calculaMedia(alunos.get(i).notas);
            if (menoresMedias.size() == 0) {
                menoresMedias.add(alunos.get(i));
                menorMediaEncontrada = mediaAtual;
            } else if (mediaAtual < menorMediaEncontrada) {
                menoresMedias.clear();
                menoresMedias.add(alunos.get(i));
                menorMediaEncontrada = mediaAtual;
            } else if (mediaAtual == menorMediaEncontrada) {
                menoresMedias.add(alunos.get(i));
            }
        }
        return menoresMedias;
    }

    public static List<Aluno>[] veririficaStatusDosAlunos(List<Aluno> alunos, double mediaAprovado, double mediaRecuperacao) {
        List<Aluno> alunosAprovados = new ArrayList<>();
        List<Aluno> alunosEmRecuperacao = new ArrayList<>();
        List<Aluno> alunosReprovados = new ArrayList<>();
        for (int i = 0; i < alunos.size(); i++) {
            double mediaAtual = calculaMedia(alunos.get(i).notas);
            if (mediaAtual >= mediaAprovado) {
                alunosAprovados.add(alunos.get(i));
            } else if (mediaAtual < mediaAprovado && mediaAtual >= mediaRecuperacao) {
                alunosEmRecuperacao.add(alunos.get(i));
            } else {
                alunosReprovados.add(alunos.get(i));
            }
        }
        List<Aluno>[] statusAlunos = new List[]{alunosAprovados, alunosEmRecuperacao, alunosReprovados};
        return statusAlunos;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "nome : '" + nome + '\'' +
                ", matrícula : " + matricula +
                ", notas : " + Arrays.toString(notas) +
                ", média : " + calculaMedia(this.notas) +
                '}';
    }
}
