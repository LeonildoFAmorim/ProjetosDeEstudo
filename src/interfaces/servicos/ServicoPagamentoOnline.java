package interfaces.servicos;

public interface ServicoPagamentoOnline {
    double calculaJuros (double valor, int meses);
    double calculaTaxaPagamento (double valor);
}
