package associacao_enumeracao_trabalhador.aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import associacao_enumeracao_trabalhador.entidades.ContratoHora;
import associacao_enumeracao_trabalhador.entidades.Departamento;
import associacao_enumeracao_trabalhador.entidades.NivelTrabalhador;
import associacao_enumeracao_trabalhador.entidades.Trabalhador;

public class Programa {

    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);

        System.out.print("Entre com o departamento: ");
        String departamento = sc.next();
        System.out.println("Entre com os dados do trabalhador:");
        System.out.print("Nome: ");
        String nome = sc.next();
        System.out.print("Nível (JUNIOR, PLENO, SENIOR): ");
        String nivel = sc.next();
        System.out.print("Salário base: ");
        double salarioBase = sc.nextDouble();
        Trabalhador trabalhador = new Trabalhador(nome, NivelTrabalhador.valueOf(nivel), salarioBase, new Departamento(departamento));

        System.out.print("Quantos contratos para esse trabalhador? ");
        int qtc = sc.nextInt();
        for (int i = 1; i <= qtc; i++) {
            System.out.println("Entre com os dados do contrato #" + i);
            System.out.print("Data (DD/MM/AAAA): ");
            Date data = sdf.parse(sc.next());
            System.out.print("Valor por hora: ");
            double valorHora = sc.nextDouble();
            System.out.print("Duração (horas): ");
            int qtdHoras = sc.nextInt();
            ContratoHora contrato = new ContratoHora(data, valorHora, qtdHoras);
            trabalhador.adicionarContrato(contrato);
        }
        System.out.print("Entre com o mês e ano para calcular a renda (MM/AAAA): ");
        String mesAno = sc.next();
        int mes = Integer.parseInt(mesAno.substring(0, 2));
        int ano = Integer.parseInt(mesAno.substring(3));
        System.out.println();
        System.out.println("Nome: " + nome);
        System.out.println("Departamento: " + departamento);
        System.out.println("Renda para " + mesAno + " : " + String.format("%.2f", trabalhador.calculaMensal(mes, ano)));
        sc.close();
    }
}
