package excecoes.conta_bancaria.modelo.excecoes;

public class ExcecaoDeNegocio extends RuntimeException {
    public ExcecaoDeNegocio(String msg) {
        super(msg);
    }
}

