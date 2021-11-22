package associacao_enumercao_pedido.aplicacao;

import associacao_enumercao_pedido.entidades.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Programa {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Entre com os dados do cliente:");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.next();
        System.out.print("Data de aniversário: ");
        Date dataAniversario = sdf.parse(scanner.next());
        Cliente cliente = new Cliente(nome, email, dataAniversario);

        System.out.println("Entre com os dados do pedido:");
        Date momentoDoPedido = new Date();
        System.out.print("Status: ");
        String statusPedido = scanner.next();
        Pedido pedido = new Pedido(momentoDoPedido, StatusPedido.valueOf(statusPedido), cliente);

        System.out.print("Quantos itens para este pedido? ");
        int itens = scanner.nextInt();
        scanner.nextLine();
        for (int i = 1; i <= itens; i++) {
            System.out.println("Entre com os dados do item #" + i);
            System.out.print("Nome do produto: ");
            String nomeProduto = scanner.next();
            System.out.print("Preço do produto: ");
            double preco = scanner.nextDouble();
            Produto produto = new Produto(nomeProduto, preco);
            System.out.print("Quantidade: ");
            int quantidade = scanner.nextInt();

            ItemPedido itemPedido = new ItemPedido(quantidade, preco, produto);
            pedido.adicionaItem(itemPedido);
        }
        System.out.println();
        System.out.println("Resumo do pedido:");
        System.out.println(pedido);
        scanner.close();
    }
}
