package generics.set.instrutor;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Programa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Integer> alunosA = new HashSet<>();
        Set<Integer> alunosB = new HashSet<>();
        Set<Integer> alunosC = new HashSet<>();
        Set<Integer> totalDeAlunos = new HashSet<>();

        System.out.println();
        System.out.print("Quantos estudantes para o curso A: ");
        int A = scanner.nextInt();
        for (int i = 0; i < A; i++){
            System.out.print("Digite o codigo do estudante: ");
            int codigo = scanner.nextInt();
            alunosA.add(codigo);
        }
        System.out.println();
        System.out.print("Quantos estudantes para o curso B: ");
        int B = scanner.nextInt();
        for (int i = 0; i < B; i++){
            System.out.print("Digite o codigo do estudante: ");
            int codigo = scanner.nextInt();
            alunosB.add(codigo);
        }
        System.out.println();
        System.out.print("Quantos estudantes para o curso C: ");
        int C = scanner.nextInt();
        for (int i = 0; i < C; i++){
            System.out.print("Digite o codigo do estudante: ");
            int codigo = scanner.nextInt();
            alunosC.add(codigo);
        }

        totalDeAlunos.addAll(alunosA);
        totalDeAlunos.addAll(alunosB);
        totalDeAlunos.addAll(alunosC);

        System.out.println();
        System.out.println("Total de estudantes: " + totalDeAlunos.size());
        scanner.close();
    }
}
