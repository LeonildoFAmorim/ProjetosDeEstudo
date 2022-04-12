package arquivos.aplicacao;

import arquivos.entidades.Item;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o caminho do arquivo para a leitura");
        String caminho = scanner.nextLine();

        File file = new File(caminho);
        String pasta = file.getParent();
        boolean sucesso = new File(pasta + "\\saida").mkdir();
        String local = pasta + "\\saida\\resumo.csv";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(caminho))) {
            String linha = bufferedReader.readLine();
            List<Item> lista = new ArrayList<>();
            while (linha != null) {
                String[] campos = linha.split(",");
                lista.add(new Item(campos[0], Double.parseDouble(campos[1]), Integer.parseInt(campos[2])));
                linha = bufferedReader.readLine();
            }
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(local))) {
                for (Item item : lista) {
                    bufferedWriter.write(item.getNome() + "," + String.format("%.2f", item.total()));
                    bufferedWriter.newLine();
                }
            } catch (Exception e) {
                System.out.println("Erro de escrita do arquivo: " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Erro de leitura do arquivo: " + e.getMessage());
        }
        scanner.close();
    }
}
