package heranca_polimorfismo.produto.aplicacao;

import heranca_polimorfismo.produto.entidades.Produto;
import heranca_polimorfismo.produto.entidades.ProdutoImportado;
import heranca_polimorfismo.produto.entidades.ProdutoUsado;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Programa {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        List<Produto> produtos = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Entre com a quantidade de produtos: ");
        int qtdP = scanner.nextInt();
        scanner.nextLine();
        for (int i = 1; i <= qtdP; i++) {
            System.out.print("Produto #" + i + " comum, usado ou importado? (c/u/i): ");
            char tipoProduto = scanner.next().charAt(0);
            System.out.print("Nome do produto: ");
            String nomeProduto = scanner.next();
            System.out.print("Valor do produto: ");
            double valorProduto = scanner.nextDouble();
            if (tipoProduto == 'c') {
                produtos.add(new Produto(nomeProduto, valorProduto));
            } else if (tipoProduto == 'i') {
                System.out.print("Informe o valor da taxa de alfandega: ");
                double alfandega = scanner.nextDouble();
                produtos.add(new ProdutoImportado(nomeProduto, valorProduto, alfandega));
            } else {
                System.out.print("Informe a data de fabricacao: ");
                Date dataFabricacao = sdf.parse(scanner.next());
                produtos.add(new ProdutoUsado(nomeProduto, valorProduto, dataFabricacao));
            }
        }
        System.out.println();
        System.out.println("Lista de produtos: ");
        for (Produto produto : produtos) {
            System.out.println(produto);
        }
    }
}
