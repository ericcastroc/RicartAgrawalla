/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.RicartAgrawalla.Receive;

import com.mycompany.RicartAgrawalla.Connection.Connection;
import com.mycompany.RicartAgrawalla.EnumNodeState.EnumNodeState;
import com.mycompany.RicartAgrawalla.Node.Node;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Eric Castro
 */
public class Receive {

    ServerSocket listenSocket;

    public Receive(ServerSocket listenSocket, Node node) {
        this.listenSocket = listenSocket;
    }

    public void run() throws IOException {
        while (true) {
            Socket clientSocket = listenSocket.accept();
            System.err.println("Servidor: Conexão estabelecida com: " + clientSocket.getInetAddress());
            new Connection(clientSocket).start();

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
            DataInputStream inp = new DataInputStream(clientSocket.getInputStream());

            if (in.readLine() == EnumNodeState.LIVRE.getDescricao()) {
                node.s
            } else {
                if (in.readLine() == EnumNodeState.OCUPANDO.getDescricao()) {

                } else if (in.readLine() == EnumNodeState.AGUARDANDO.getDescricao()) {

                }
            }
        }
    }
}
