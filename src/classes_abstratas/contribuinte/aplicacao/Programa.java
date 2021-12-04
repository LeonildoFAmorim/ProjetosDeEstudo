package classes_abstratas.contribuinte.aplicacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import classes_abstratas.contribuinte.entidades.Contribuinte;
import classes_abstratas.contribuinte.entidades.PessoaJuridica;
import classes_abstratas.contribuinte.entidades.PessoaFisica;


public class Programa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Contribuinte> contribuintes = new ArrayList<>();

        System.out.print("Quantos contribuintes? ");
        int qtdC = scanner.nextInt();
        for (int i = 1; i <= qtdC; i++) {
            System.out.print("pessoa fisica ou juridica? (f / j): ");
            char pessoa = scanner.next().charAt(0);
            System.out.print("Nome: ");
            scanner.nextLine();
            String nome = scanner.nextLine();
            System.out.print("Renda anual: ");
            double rendaAnual = scanner.nextDouble();
            if (pessoa == 'f') {
                System.out.print("Gastos com saude: ");
                double gastosSaude = scanner.nextDouble();
                contribuintes.add(new PessoaFisica(nome, rendaAnual, gastosSaude));
            } else {
                System.out.print("Numero de funcionarios: ");
                int numeroFuncionarios = scanner.nextInt();
                contribuintes.add(new PessoaJuridica(nome, rendaAnual, numeroFuncionarios));
            }
        }

        System.out.println();
        System.out.println("Impostos pagos:");
        double totalImpostoPago = 0;
        for (Contribuinte contribuinte : contribuintes) {
            System.out.println(contribuinte.getNome() + " $ " + String.format("%.2f", contribuinte.calculaImposto()));
            totalImpostoPago += contribuinte.calculaImposto();
        }

        System.out.println();
        System.out.println("Imposto total pago: " + String.format("%.2f", totalImpostoPago));
    }
}
