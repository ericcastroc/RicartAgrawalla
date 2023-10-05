/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.computacaoparalelasistemasdistribuidos.AERicart;

/**
 *
 * @author Eric Castro
 */
public class Main {
    
    public static void main(String[] args) {
        SecaoCritica secaoCritica = new SecaoCritica();

        // Crie uma thread para executar o processo
        new Thread(new Processo(4, secaoCritica)).start();     
        new Thread(new Processo(1, secaoCritica)).start();

    }
}
