/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.computacaoparalelasistemasdistribuidos.AERicart;

/**
 *
 * @author Eric Castro
 */
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Processo implements Runnable {

    private int id;
    private Lock lock = new ReentrantLock();
    private Condition condicao = lock.newCondition();
    private SecaoCritica secaoCritica;
    private Random random = new Random();

    private boolean querAcesso = false;
    private int timestamp = 0;
    private boolean[] requisicoesPendentes;
    private int[] timestampsPendentes;

    public Processo(int id, SecaoCritica secaoCritica) {
        this.id = id;
        this.secaoCritica = secaoCritica;
        this.requisicoesPendentes = new boolean[4];
        this.timestampsPendentes = new int[4]; // Inicialize o array timestampsPendentes
    }

    @Override
    public void run() {
        while (true) {
            try {
                // Espera um tempo randômico antes de solicitar acesso à seção crítica (30 a 60 segundos)
                int esperaInicial = random.nextInt(3) + 3;
                System.out.println("Processo " + id + " vai esperar " + esperaInicial + " segundos antes de solicitar acesso.");

                Thread.sleep(esperaInicial * 1000);

                System.out.println("Processo " + id + " quer acessar a seção crítica.");

                // Solicita acesso à seção crítica
                solicitarAcesso();

                System.out.println("Processo " + id + " está na seção crítica.");
                // Realiza operações na seção crítica por 10 segundos
                Thread.sleep(10000);

                System.out.println("Processo " + id + " saiu da seção crítica.");

                // Libera o acesso à seção crítica
                liberarAcesso();

                // Aguarda um novo intervalo randômico antes de solicitar novamente (30 a 60 segundos)
                int esperaNovoAcesso = random.nextInt(31) + 30;
                System.out.println("Processo " + id + " vai esperar " + esperaNovoAcesso + " segundos antes de solicitar acesso novamente.");

                Thread.sleep(esperaNovoAcesso * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void solicitarAcesso() {
        lock.lock();
        try {
            querAcesso = true;
            timestamp++;

            for (int i = 0; i < requisicoesPendentes.length; i++) {
                if (i != id) {
                    requisicoesPendentes[i] = true;
                    timestampsPendentes[i] = timestamp;
                    enviarSolicitacao(i, timestamp);
                }
            }

            while (!todasRespostasRecebidas()) {
                condicao.await(5, TimeUnit.SECONDS);
                
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    private void liberarAcesso() {
        lock.lock();
        try {
            querAcesso = false;

            for (int i = 0; i < requisicoesPendentes.length; i++) {
                if (i != id && requisicoesPendentes[i]) {
                    enviarLiberacao(i);
                    requisicoesPendentes[i] = false;
                }
            }
        } finally {
            lock.unlock();
        }
    }

    private void enviarSolicitacao(int processo, int meuTimestamp) {
        secaoCritica.entrar();
    }

    private void enviarLiberacao(int processo) {
        secaoCritica.sair();
    }

    private boolean todasRespostasRecebidas() {
        for (int i = 0; i < timestampsPendentes.length; i++) {
            if (i != id && requisicoesPendentes[i] && (timestampsPendentes[i] < timestamp
                    || (timestampsPendentes[i] == timestamp && i < id))) {
                return false;
            }
        }
        return true;
    }
}
