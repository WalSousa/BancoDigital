package entities;

public class ContaPoupanca extends Conta {
    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }

    public ContaPoupanca(int agencia, int conta, Cliente destinatario) {
        super(agencia,conta,destinatario);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("\n************** Extrato Conta Poupanca *******************");
        super.imprimirInformacoes("Conta Poupanca");
    }
}
