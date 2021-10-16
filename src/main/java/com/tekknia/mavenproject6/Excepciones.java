/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tekknia.mavenproject6;

/**
 *
 * @author LENOVO
 */
//public class Excepciones {
    
//}
class CuentaInexistente extends Exception{
    public CuentaInexistente(String msg){
        super(msg);
    }
}

class SaldoInsuficiente extends Exception{
    public SaldoInsuficiente(String msg){
        super(msg);
    }
}

class MontoInvalido extends Exception{
    public MontoInvalido(String msg){
        super(msg);
    }
}

class MontoMaximo extends Exception{
    public MontoMaximo(String msg){
        super(msg);
    }
}

class NumeroMaximoTransacciones extends Exception{
    public NumeroMaximoTransacciones(String msg){
        super(msg);
    }
}
