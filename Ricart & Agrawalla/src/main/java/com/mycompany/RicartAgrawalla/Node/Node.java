/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.RicartAgrawalla.Node;

import com.mycompany.RicartAgrawalla.EnumNodeState.EnumNodeState;
import java.util.List;
import lombok.Data;

/**
 *
 * @author Eric Castro
 */
@Data
public class Node {
    private Long id = 4l;
    private EnumNodeState status;
    private int osn;
    private List request;
    private List received;
}
