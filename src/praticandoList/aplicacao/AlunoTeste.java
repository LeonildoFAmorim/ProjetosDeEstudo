package praticandoList.aplicacao;

import praticandoList.entidades.Aluno;

import java.util.Scanner;

public class AlunoTeste {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Quantos alunos serão? ");
        int qta = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < qta; i++) {
            System.out.println();
            System.out.print("Entre com o nome do " + (i + 1) + "º aluno: ");
            String nome = sc.nextLine();
            System.out.print("Entre com a matrícula de " + nome + ": ");
            int matricula = sc.nextInt();
            sc.nextLine();
            System.out.print("Quantas notas para " + nome + ": ");
            int qtn = sc.nextInt();
            sc.nextLine();
            double[] notas = new double[qtn];
            for (int j = 0; j < qtn; j++) {
                System.out.print("Entre com a " + (j + 1) + "ª nota de " + nome + ": ");
                notas[j] = sc.nextDouble();
                sc.nextLine();
            }
            Aluno aluno = new Aluno(nome, matricula, notas);
            Aluno.adicionaAluno(aluno);
        }
        System.out.println();
        System.out.print("Qual a média mínima para ser considerado aprovado? ");
        double mediaAprovacao = sc.nextDouble();
        System.out.print("Qual a média mínima para ir para a recuperação? ");
        double mediaRecuperacao = sc.nextDouble();
        while (mediaRecuperacao >= mediaAprovacao) {
            System.out.print("A média mínima para a recuperação deve ser menor que a nota mínima de aprovação! Digite novamente: ");
            mediaRecuperacao = sc.nextDouble();
        }

        Aluno.statusAlunos = Aluno.veririficaStatusDosAlunos(Aluno.alunos, mediaAprovacao, mediaRecuperacao);

        System.out.println();
        System.out.println("Relatório dos alunos:");
        for (Aluno aluno : Aluno.alunos) {
            System.out.println(aluno);
        }

        System.out.println();
        System.out.println("Alunos aprovados (considerando média mínima de " + mediaAprovacao + "):");
        for (Aluno aluno : Aluno.statusAlunos[0]) {
            System.out.println(aluno);
        }

        System.out.println();
        System.out.println("Alunos em recuperação (considerando média mínima de " + mediaRecuperacao + "):");
        for (Aluno aluno : Aluno.statusAlunos[1]) {
            System.out.println(aluno);
        }

        System.out.println();
        System.out.println("Alunos reprovados:");
        for (Aluno aluno : Aluno.statusAlunos[2]) {
            System.out.println(aluno);
        }

        System.out.println();
        System.out.println("Maiores médias:");
        Aluno.maioresMedias = Aluno.verificaMaiorMedia(Aluno.alunos);
        for (Aluno aluno : Aluno.maioresMedias) {
            System.out.println(aluno);
        }

        System.out.println();
        System.out.println("Menores médias:");
        Aluno.menoresMedias = Aluno.verificaMenorMedia((Aluno.alunos));
        for (Aluno aluno : Aluno.menoresMedias) {
            System.out.println(aluno);
        }
        sc.close();
    }
}
