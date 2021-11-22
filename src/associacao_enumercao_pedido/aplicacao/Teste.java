package associacao_enumercao_pedido.aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Teste {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date data = new Date();
        System.out.println(data);
    }
}
