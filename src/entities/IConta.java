package entities;

import exceptions.BusinessException;

public interface IConta {

    default void sacar(double valor) throws BusinessException {}
    default void depositar(double valor){}

    /**
     */
    default void transferir(double valor, IConta contadestino) throws BusinessException {}

    void imprimirExtrato();
}
