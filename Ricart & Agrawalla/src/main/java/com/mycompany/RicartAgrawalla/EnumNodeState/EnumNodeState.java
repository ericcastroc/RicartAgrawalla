/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.RicartAgrawalla.EnumNodeState;

/**
 *
 * @author Eric Castro
 */
public enum EnumNodeState {
    LIVRE((short) 0, "Livre"),
    OCUPANDO((short) 1, "Ocupando"),
    AGUARDANDO((short) 2, "Aguardando");

    private final Short codigo;
    private final String descricao;

    EnumNodeState(Short codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Short getValue() {
        return getCodigo();
    }

    public static EnumNodeState get(Object value) {
        for (EnumNodeState value1 : values()) {
            if (String.valueOf(value).equalsIgnoreCase(String.valueOf(value1.getCodigo()))) {
                return value1;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return getDescricao();
    }

    /**
     * @return the codigo
     */
    public Short getCodigo() {
        return codigo;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }
}
