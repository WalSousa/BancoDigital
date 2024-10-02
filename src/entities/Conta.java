package entities;

import exceptions.BusinessException;
import lombok.Getter;

import java.util.Random;
@Getter
public abstract class Conta implements IConta {

    private static final int AGENCIA_PADRAO = 1;
    private int agencia;
    private int numero;
    private double saldo;

    Cliente cliente;

    public Conta(Cliente cliente) {
        int random = new Random().nextInt(10000, 100000);

        this.agencia = AGENCIA_PADRAO;
        this.numero = random;
        this.cliente = cliente;
    }

    public Conta(int agencia, int numero, Cliente cliente) {

        this.agencia = agencia;
        this.numero = numero;
        this.cliente = cliente;
    }


    @Override
    public void sacar(double valor) throws BusinessException {
        if (valor > saldo) {
            System.out.println("\nLimite Cheque Especial R$ 100,00");
            if ((valor - saldo) <= 100) {
                System.out.println("Utilizando Limite do Cheque especial");
                this.saldo = saldo - valor;
            } else {
                throw new BusinessException("Saldo insuficiente! \nSeu Saldo e' de R$ " + String.format("%.2f", this.saldo));
            }
        } else {
            this.saldo = saldo - valor;
        }
    }

    @Override
    public void depositar(double valor) {
        this.saldo += valor;
    }

    @Override
    public void transferir(double valor, IConta contadestino) throws BusinessException {
        if (contadestino == null) {
            throw new BusinessException("Conta invalida");
        } else {
            this.sacar(valor);
            contadestino.depositar(valor);
        }
    }
    protected void imprimirInformacoes(String conta) {
        String msg = "";

        if (0 > this.saldo) {
            msg = " (Negativo)";
        }
        System.out.println(String.format("Titular " + conta + " : %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Numero Conta: %d", this.numero));
        System.out.println(String.format("Saldo: R$ %.2f", this.saldo) + msg);
    }
}
