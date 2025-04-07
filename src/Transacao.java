public class Transacao {

    protected double valor;
    private Conta contaDestino;
    private String dataHora;

    public Transacao(double valor, Conta contaDestino, String dataHora) {
        this.valor = valor;
        this.contaDestino = contaDestino;
        this.dataHora = dataHora;
    }

    @Override
    public String toString() {
        if (contaDestino != null) {
            return String.format("%.2f em %s para a conta %d",
                    valor , dataHora, contaDestino.getNumero());
        } else {
            return String.format("%.2f em %s para a conta",
                    valor, dataHora);
        }

    }


}