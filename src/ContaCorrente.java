import org.w3c.dom.ls.LSOutput;

public class ContaCorrente extends Conta {

    public ContaCorrente(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("===Extrato Conta Corrente====");
        imprimirInfoComuns();

    }




}
