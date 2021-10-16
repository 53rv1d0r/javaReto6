/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tekknia.mavenproject6;

/**
 *
 * @author Vladimir Ortega - Alejandro Restrepo
 * Universidad de Antioquia - Técnicas de programación2021
 */
public class Cuenta {
    //Declarando Atributos
    private int id;
    private float saldo;
    public static final float MONTO_MAXIMO = 1000000f;
    public static final int MAXIMO_TRANSACCIONES = 3;

    //private String NDocumento;
    //private final int montoMaximo = 1000000;
    //private final int trasaPermitidas = 3;
    //private String pais;
    
    //Constructor de la clase Cuenta
    public Cuenta(int id, float saldo) {
        this.id = id;
        this.saldo = saldo;
    }
    //getters y setters id

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    //getters y setters saldo
    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
    
}
