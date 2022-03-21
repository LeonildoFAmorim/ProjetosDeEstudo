package interfaces.servicos;

public class SericoPayPal implements ServicoPagamentoOnline{
    private static final double JURO_SIMPLES = 0.01;
    private static final double TAXA_PAGAMENTO = 0.02;


    @Override
    public double calculaJuros(double valor, int meses) {
        return valor * JURO_SIMPLES * meses;
    }

    @Override
    public double calculaTaxaPagamento(double valor) {
        return valor * TAXA_PAGAMENTO;
    }
}
