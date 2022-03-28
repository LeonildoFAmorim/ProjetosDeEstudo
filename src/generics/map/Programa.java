package generics.map;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> candidatos = new LinkedHashMap<>();

        System.out.println("Entre com o caminho: ");
        String caminho = scanner.nextLine();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(caminho))) {
            String linha = bufferedReader.readLine();
            while (linha != null) {
                String[] campos = linha.split(",");
                String nome = campos[0];
                int qtdVotos = Integer.parseInt(campos[1]);
                if (candidatos.containsKey(nome)) {
                    int votosAcumulados = candidatos.get(nome);
                    candidatos.put(nome, qtdVotos + votosAcumulados);
                } else {
                    candidatos.put(nome, qtdVotos);
                }
                linha = bufferedReader.readLine();
            }
            for (String chave : candidatos.keySet()) {
                System.out.println(chave + ": " + candidatos.get(chave));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        scanner.close();
    }
}
