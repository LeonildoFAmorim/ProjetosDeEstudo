package expressoes_lambda.aplicacao;

import expressoes_lambda.entidades.Funcionario;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Programa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o caminho: ");
        String caminho = scanner.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            List<Funcionario> listaFuncionarios = new ArrayList<>();
            String linha = br.readLine();
            while (linha != null) {
                String[] campos = linha.split(",");
                listaFuncionarios.add(new Funcionario(campos[0], campos[1], Double.parseDouble(campos[2])));
                linha = br.readLine();
            }

            System.out.print("Digite o valor do salario: ");
            double salario = scanner.nextDouble();

            List<String> emails = listaFuncionarios.stream()
                    .filter(f -> f.getSalario() > salario)
                    .map(f -> f.getEmail())
                    .sorted()
                    .collect(Collectors.toList());

            System.out.println("emails dos funcionarios cujo o salario eh maior que " + salario);
            emails.forEach(System.out::println);

            double soma = listaFuncionarios.stream()
                    .filter(f -> f.getNome().charAt(0) == 'M')
                    .map(f -> f.getSalario())
                    .reduce(0.0, (x, y) -> x + y);

            System.out.println("Soma dos salarios cujo o nome começa com a letra M: " + soma);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        scanner.close();
    }
}
