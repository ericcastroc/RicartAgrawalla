/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.computacaoparalelasistemasdistribuidos.AERicart;

/**
 *
 * @author Eric Castro
 */
import java.util.concurrent.locks.ReentrantLock;

public class SecaoCritica {
    private ReentrantLock lock = new ReentrantLock();

    public void entrar() {
        lock.lock();
    }

    public void sair() {
        lock.unlock();
    }
}

