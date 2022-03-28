package generics.set.usuario.aplicacao;

import generics.set.usuario.entidades.Usuario;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Programa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Usuario> conjuntoUsuarios = new HashSet<>();

        System.out.println("Entre com o caminho");
        String caminho = scanner.nextLine();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(caminho))) {
            String linha = bufferedReader.readLine();
            while (linha != null) {
                String[] campos = linha.split(" ");
                String nome = campos[0];
                Date data = Date.from(Instant.parse(campos[1]));
                conjuntoUsuarios.add(new Usuario(nome, data));
                linha = bufferedReader.readLine();
            }
            System.out.println("Total de usuarios: " + conjuntoUsuarios.size());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        scanner.close();
    }
}
