package com.mycompany.banco;
import java.util.Scanner;

public class AppBanco {

    public static void main(String[] args) {
        
        Banco banco = new Banco();
        Scanner ler = new Scanner(System.in);
        
        banco.CriarConta(ler, banco);
        
        System.out.print("Conta bancária criada com sucesso.\n");
        
        banco.OpcoesConta(ler, banco);
        
    }
}
