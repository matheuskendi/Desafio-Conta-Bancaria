import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public abstract class Conta implements IConta {
    //Atributos
    private List<Transacao> historicoTransacoes = new ArrayList<>();
    protected static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;


    protected int agencia;
    protected int numero;
    protected double saldo;
    private Cliente cliente;



    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;

    }


    //Implements da interface IConta
    //sacar
    @Override
    public void sacar(double valor) {
        if (valor > 0  && saldo >= valor){
        saldo -= valor;
        } else {
            System.out.println("Saldo insuficiente");
        }
    }

    //Depositar
    @Override
    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
        }else {
            System.out.println("Saldo insuficiente");
        }
    }

    //No transferir foi adicionado uma função de mostrar quem fez a transferencia.
    @Override
    public void transferir(double valor, Conta contaDestino) {
        if (valor > 0 && saldo >= valor) {
            this.sacar(valor);
            contaDestino.depositar(valor);
            historicoTransacoes.add(new Transacao(valor, contaDestino, LocalDateTime.now().toString()));
        } else {
            System.out.println("Saldo insuficiente ou valor inválido.");
        }
    }

    @Override
    public boolean imprimirHistorico() {
        if (historicoTransacoes.isEmpty()) {
            System.out.println("Nenhuma transação realizada.");
        } else {
            System.out.println("Histórico de Transações:");
            for (Transacao transacao : historicoTransacoes) {
                System.out.println(transacao);
            }
        }
        return false;
    }

    //Get
    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }


    protected void imprimirInfoComuns() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.getAgencia()));
        System.out.println(String.format("Numero: %d", this.getNumero()));
        System.out.println(String.format("Saldo: %.2f", this.getSaldo()));

    }


    public abstract void imprimirExtrato();
}
