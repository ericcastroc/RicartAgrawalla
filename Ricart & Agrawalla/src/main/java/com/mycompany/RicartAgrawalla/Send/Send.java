/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.RicartAgrawalla.Send;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author Eric Castro
 */
public class Send {

    private final Socket socket;
    private final DataOutputStream out;
    private final DataInputStream in;

    public Send(Socket socket) throws IOException {
        this.socket = socket;
        this.out = new DataOutputStream(socket.getOutputStream());
        this.in = new DataInputStream(socket.getInputStream());
    }

    public void send(String message) throws IOException {
        try {
            out.writeUTF(message);
            System.err.println("Received: " + in.readUTF());
        } catch (IOException e) {
            System.err.println("IO:" + e.getMessage());
        }

    }

}
