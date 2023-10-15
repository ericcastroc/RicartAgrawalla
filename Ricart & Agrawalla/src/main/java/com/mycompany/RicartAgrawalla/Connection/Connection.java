/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.RicartAgrawalla.Connection;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author Eric Castro
 */
public class Connection extends Thread {

    DataInputStream in;
    DataOutputStream out;
    Socket clientSocket;

    public Connection(Socket clientSocket) throws IOException {
        this.in = new DataInputStream(clientSocket.getInputStream());
        this.out = new DataOutputStream(clientSocket.getOutputStream());
        this.clientSocket = clientSocket;
    }

    public void run() {
        try {
            out.writeUTF(in.readUTF());
        } catch (Exception e) {
            System.err.println("IO: " + e.getMessage());
        } finally {
            try {
                clientSocket.close();
                System.err.println("Conexão fechada pelo cliente: ");
            } catch (IOException e) {
                System.out.println("Falha ao Fechar: " + e.getMessage());
            }
        }
    }

}
