package associacao_enumeracao.pedido.entidades;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    private Date momentoDoPedido;
    private StatusPedido statusPedido;
    private Cliente cliente;
    public List<ItemPedido> itensPedidos = new ArrayList<>();

    private Pedido() {

    }

    public Pedido(Date dataHora, StatusPedido statusPedido, Cliente cliente) {
        this.momentoDoPedido = dataHora;
        this.statusPedido = statusPedido;
        this.cliente = cliente;
    }

    public void adicionaItem(ItemPedido itemPedido) {
        itensPedidos.add(itemPedido);
    }

    public void removeItem(ItemPedido itemPedido) {
        itensPedidos.remove(itemPedido);
    }

    public double calculaPrecoTotal() {
        double soma = 0;
        for (ItemPedido itemPedido : itensPedidos) {
            soma += itemPedido.subTotal();
        }
        return soma;
    }

    public Date getMomentoDoPedido() {
        return momentoDoPedido;
    }

    public void setMomentoDoPedido(Date dataHora) {
        this.momentoDoPedido = dataHora;
    }

    public StatusPedido getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(StatusPedido statusPedido) {
        this.statusPedido = statusPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Momento do pedido: ");
        sb.append(sdf.format(momentoDoPedido) + "\n");
        sb.append("Status do pedido: ");
        sb.append(statusPedido + "\n");
        sb.append("Cliente: \n");
        sb.append(cliente + "\n");
        sb.append("Itens pedidos: \n");
        for (ItemPedido itemPedido : itensPedidos) {
            sb.append(itemPedido + "\n");
        }
        sb.append("Preço total: ");
        sb.append(String.format("%.2f", calculaPrecoTotal()));
        return sb.toString();
    }
}


