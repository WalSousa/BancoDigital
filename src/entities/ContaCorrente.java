package entities;

public class ContaCorrente extends Conta {

    public ContaCorrente(Cliente cliente) {
        super(cliente);
    }

    public ContaCorrente(int agencia, int conta, Cliente destinatario) {
        super(agencia,conta,destinatario);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("\n************** Extrato Conta Corrente *******************");
        super.imprimirInformacoes("Conta Corrente");
    }
}
