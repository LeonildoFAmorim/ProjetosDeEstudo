package arquivos.alunos;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("digite o caminho: ");
        String caminho = scanner.nextLine();
        List<Aluno> alunos = new ArrayList<>();

        File file = new File(caminho);
        String raiz = file.getParent();
        String local = raiz + "\\mediasAlunos.txt";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(caminho))) {
            String linha = bufferedReader.readLine();
            while (linha != null) {
                String[] campos = linha.split(",");
                String nome = campos[0];
                List<Double> notas = new ArrayList<>();
                for (int i = 1; i < campos.length; i++) {
                    notas.add(Double.parseDouble(campos[i]));
                }
                alunos.add(new Aluno(nome, notas));
                linha = bufferedReader.readLine();
            }
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(local))) {
                for (Aluno aluno : alunos) {
                    bufferedWriter.write((aluno).toString());
                    bufferedWriter.newLine();
                }
            } catch (Exception e) {
                System.out.println("erro na escrita: " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("erro na leitura: " + e.getMessage());
        }
        scanner.close();
    }
}


