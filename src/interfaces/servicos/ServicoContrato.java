package interfaces.servicos;

import interfaces.entidades.Contrato;
import interfaces.entidades.Parcela;

import java.util.Calendar;
import java.util.Date;

public class ServicoContrato {
    ServicoPagamentoOnline servicoPagamentoOnline;

    public ServicoContrato (ServicoPagamentoOnline servicoPagamentoOnline){
        this.servicoPagamentoOnline = servicoPagamentoOnline;
    }

    public void processarContrato (Contrato contrato, int meses){
        double parcelaBasica = contrato.getValor() / meses;
        for (int i = 1; i <= meses; i++){
            double parcelaAtualizada = parcelaBasica + servicoPagamentoOnline.calculaJuros(parcelaBasica, i);
            double valorTotal = parcelaAtualizada + servicoPagamentoOnline.calculaTaxaPagamento(parcelaAtualizada);
            Date dataVencimento = adicinaMes(contrato.getData(), i);
            contrato.getParcelas().add(new Parcela(dataVencimento, valorTotal));
        }
    }

    private Date adicinaMes(Date data, int N){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(data);
        calendar.add(Calendar.MONTH, N);
        return calendar.getTime();
    }
}
