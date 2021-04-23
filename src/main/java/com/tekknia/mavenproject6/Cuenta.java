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
    
    private int saldo;
// Declarar atributos.

    private String NDocumento;
    private final int montoMaximo = 1000000;
    private final int trasaPermitidas = 3;
    private String pais;

    public Cuenta(int saldo) {
        this.saldo = saldo;
    }

    public int diferencia(int saldo) {
        this.saldo = saldo;
        return this.saldo;
    }

    public int realizar(int retiro) {
        this.saldo = this.saldo - retiro;
        return this.saldo;
    }

    public int realizar1(int deposito) {
        this.saldo = this.saldo + deposito;
        return this.saldo;
    }
    
}
