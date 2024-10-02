package service;

import entities.Cliente;
import entities.Conta;
import entities.ContaCorrente;
import entities.ContaPoupanca;

import java.util.Scanner;

public class BancoDigital {

    BancoDigital() {}
    public static void banco() {

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Digite seu nome:");
            String nome = scanner.nextLine();

            System.out.println("Digite o valor para deposito:");
            double deposito = scanner.nextDouble();
            scanner.nextLine();

            System.out.println("\nTransferencia para mesma tituralidade?");
            String transfer = scanner.nextLine();

            Conta cc;
            Conta ccd;

            Cliente cliente = new Cliente();
            cliente.setNome(nome);

            cc = new ContaCorrente(cliente);
            cc.depositar(deposito);

            while (!"S".equalsIgnoreCase(transfer) && !"N".equalsIgnoreCase(transfer)) {
                System.out.println("\nDigite 'S' ou 'N' ==> Transferencia para mesma tituralidade?");
                transfer = scanner.nextLine();
            }

            if ("S".equalsIgnoreCase(transfer)) {
                System.out.println("Digite o valor a ser transferido para a poupanca:");
                double transferir = scanner.nextDouble();
                scanner.nextLine();

                Conta cp = new ContaPoupanca(cliente);

                cc.transferir(transferir, cp);
                cc.imprimirExtrato();
                cp.imprimirExtrato();
            } else {
                System.out.println("Digite a agencia do destinatario:");
                int agenciaDestino = scanner.nextInt();
                System.out.println("Digite a conta do destinatario:");
                int contaDestino = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Digite o nome do destinatario:");
                String destinatario = scanner.nextLine();

                System.out.println("Digite o valor a ser transferido para a conta destinatario:");
                double tranfDest = scanner.nextDouble();

                Cliente clienteDestino = new Cliente();
                clienteDestino.setNome(destinatario);
                ccd = new ContaCorrente(agenciaDestino, contaDestino, clienteDestino);
                cc.transferir(tranfDest, ccd);
                cc.imprimirExtrato();
                ccd.imprimirExtrato();
            }

            scanner.close();
        } catch (Exception e) {
            System.out.println("\n" + e.getMessage());
        }
    }
}
