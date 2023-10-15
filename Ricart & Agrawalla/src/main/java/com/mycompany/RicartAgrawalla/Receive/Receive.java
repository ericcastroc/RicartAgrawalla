/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.RicartAgrawalla.Receive;

import com.mycompany.RicartAgrawalla.Connection.Connection;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Eric Castro
 */
public class Receive {

    ServerSocket listenSocket;

    public Receive(ServerSocket listenSocket) {
        this.listenSocket = listenSocket;
    }

    public void run() throws IOException {
        while (true) {
            Socket clientSocket = listenSocket.accept();
            System.err.println("Servidor: Conexão estabelecida com: " + clientSocket.getInetAddress());
            new Connection(clientSocket).start();
        }
    }
}
