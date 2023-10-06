/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.RicartAgrawalla.Send;

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

    public Send(Socket socket) throws IOException {
        this.socket = socket;
        this.out = new DataOutputStream(socket.getOutputStream());
    }

    public void send(String message) throws IOException {
        try {
            out.writeUTF(message);
        } catch (IOException e) {

        }

    }

}
