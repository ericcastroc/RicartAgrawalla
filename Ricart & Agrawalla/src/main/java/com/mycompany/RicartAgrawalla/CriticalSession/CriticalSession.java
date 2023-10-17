/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.RicartAgrawalla.CriticalSession;

import com.mycompany.RicartAgrawalla.EnumNodeState.EnumNodeState;
import com.mycompany.RicartAgrawalla.Node.Node;
import com.mycompany.RicartAgrawalla.Send.Send;
import java.io.IOException;
import static java.lang.Math.random;
import java.util.Random;

/**
 *
 * @author Eric Castro
 */
public class CriticalSession{

    
    private Random random = new Random();
    private Node node = new Node();

    public CriticalSession(Node node) {
        this.node = node;
    }
    
    
    
    public void run() throws IOException, InterruptedException {
        while (true) {
            int esperaInicial = random.nextInt(301) + 30;
            Thread.sleep(esperaInicial *10000);
            node.setStatus(EnumNodeState.AGUARDANDO);
            
            
            while(node.getReceived().size() < 4){
                node.setStatus(EnumNodeState.OCUPANDO);
                Thread.sleep(1000*10);
                node.setStatus(EnumNodeState.LIVRE);
                node.getReceived().clear();
                node.getRequest().clear();
            }
        }
    }
}
