package interfaces.aplicacao;

import interfaces.entidades.Contrato;
import interfaces.entidades.Parcela;
import interfaces.servicos.SericoPayPal;
import interfaces.servicos.ServicoContrato;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Programa {
    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Entre com os dados do contrato:");
        System.out.print("Numero: ");
        int numero = scanner.nextInt();
        System.out.print("Data: ");
        Date data = sdf.parse(scanner.next());
        System.out.print("Valor: ");
        double valor = scanner.nextDouble();

        Contrato contrato = new Contrato(numero, data, valor);

        System.out.print("Numero de parcelas: ");
        int parcelas = scanner.nextInt();

        ServicoContrato servicoContrato = new ServicoContrato(new SericoPayPal());
        servicoContrato.processarContrato(contrato, parcelas);

        System.out.println();
        System.out.println("Parcelas:");
        for (Parcela parcela : contrato.getParcelas()){
            System.out.println(parcela);
        }
        scanner.close();
    }
}
