package com.mycompany.banco;

import java.util.Scanner;

public class Banco {

    private double Saldo;
    private String Nome;
    private int NumeroDaConta;

    public double getSaldo() {

        return Saldo;

    }

    public void setSaldo(double Saldo) {

        this.Saldo = Saldo;

    }

    public String getNome() {

        return Nome;

    }

    public void setNome(String Nome) {

        this.Nome = Nome;

    }

    public int getNumeroDaConta() {

        return NumeroDaConta;

    }

    public void setNumeroDaConta(int NumeroDaConta) {

        this.NumeroDaConta = NumeroDaConta;

    }

    public static void CriarConta(Scanner ler, Banco banco) {

        System.out.print("Informe seu nome: ");
        String nome = ler.nextLine();

        banco.setNome(nome);

        System.out.print("Número da conta: ");
        int numeroDaConta = ler.nextInt();

        banco.setNumeroDaConta(numeroDaConta);

        System.out.print("Saldo Inicial R$");
        double saldoInicial = ler.nextDouble();

        banco.setSaldo(saldoInicial);

    }

    public static void OpcoesConta(Scanner ler, Banco banco) {

        System.out.println("\nBem vindo, " + banco.getNome() + "!!!");
        System.out.println("1 - DEPOSITAR VALOR");
        System.out.println("2 - SACAR VALOR");
        System.out.println("3 - OBTER SALDO DISPONÍVEL");
        System.out.println("4 - SAIR");
        System.out.print("INFORME: ");
        int opcao = ler.nextInt();

        banco.Opcoes(ler, banco, opcao);

    }

    public void Opcoes(Scanner ler, Banco banco, int opcao) {

        double saldo;
        double retirarSaldo;

        if (opcao == 1) {

            System.out.print("\nQual valor deseja depositar: R$: ");
            saldo = ler.nextDouble();
            Saldo += saldo;

            System.out.print("Depósito de R$" + saldo + " realizado com sucesso.");
            System.out.println("");

            banco.OpcoesConta(ler, banco);

        } else if (opcao == 2) {

            System.out.print("\nSacar Valor: R$: ");
            retirarSaldo = ler.nextDouble();

            banco.validacaoSaldo(ler, banco, Saldo, retirarSaldo);

            Saldo -= retirarSaldo;

            System.out.print("Saque de R$" + retirarSaldo + " realizado com sucesso.");
            System.out.println("");

            banco.OpcoesConta(ler, banco);

        } else if (opcao == 3) {

            System.out.println("\nSeu Saldo total é de:");
            System.out.print("R$" + Saldo);
            System.out.println("");

            banco.OpcoesConta(ler, banco);

        } else if (opcao == 4) {

            banco.Sair();

        } else {

            System.out.print("Informe um valor válido");
            System.out.println("");
            
            banco.OpcoesConta(ler, banco);

        }

    }

    public static void validacaoSaldo(Scanner ler, Banco banco, double Saldo, double retirarSaldo) {

        if (retirarSaldo > 5000) {

            System.out.print("Valor do saque acima do permitido.\n");
            banco.OpcoesConta(ler, banco);

        } if (retirarSaldo > Saldo) {

            System.out.print("Saldo insuficiente para realizar a operação.\n");
            banco.OpcoesConta(ler, banco);

        }

    }

    public static void Sair() {

        System.out.print("\nATÉ A PRÓXIMA");
        System.exit(0);

    }

}
