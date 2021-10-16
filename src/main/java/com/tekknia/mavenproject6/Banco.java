/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tekknia.mavenproject6;
import java.io.*;
import java.util.*;
/**
 *
 * @author Vladimir Ortega - Alejandro Restrepo
 * Universidad de Antioquia - Técnicas de programación2021
 */
public class Banco {
    public static final ArrayList<Cuenta> cuentas = new ArrayList<>();
    //almacenar transacciones
    public static final ArrayList<Transaccion> transacciones = new ArrayList<>();
    
    //Método
    public static void agregarCuenta(Cuenta o){
        cuentas.add(o);
    }
    
    public static void eliminarCuenta(int id){
        Iterator<Cuenta> itera = cuentas.iterator();
        while (itera.hasNext()){
            Cuenta cuentaActual = itera.next();
                if(cuentaActual.getId() == id){
                    cuentas.remove(cuentaActual);
                    System.out.println("ATENCIÓN: Cuenta eliminada!!!");
                    return;//cierra el ciclo cuando encuentra la cuenta
                }
        }
    }
    //Método
    public static void agregarTransaccion(Transaccion o){
        transacciones.add(o);
    }
    
    public static Cuenta consultarCuenta(int id) throws CuentaInexistente{
        for (Cuenta cuenta : cuentas){
            if(cuenta.getId() == id){
                return cuenta;
            }
        }
        throw new CuentaInexistente("Atención!!! La cuenta no existe!!!");
    }
    
    public static void realizarTransaccion(Transaccion transac, Cuenta cuent) throws MontoInvalido, MontoMaximo, SaldoInsuficiente, NumeroMaximoTransacciones{
        if(autenticarTransaccion (transac)){
            if(transac.getTipo() == 'D'){
                realizarDeposito(transac, cuent);
            }else if(transac.getTipo() == 'R'){
                realizarRetiro(transac, cuent);
            }
        }
    }
    
    public static void realizarDeposito(Transaccion transac, Cuenta cuent) throws MontoInvalido, MontoMaximo{
        try{
            if(transac.getMonto() > 0f && transac.getMonto() <= Cuenta.MONTO_MAXIMO){
            cuent.setSaldo(cuent.getSaldo() + transac.getMonto());
            Banco.agregarTransaccion(transac);
        }else{
            if(transac.getMonto() < 0f)
                throw new MontoInvalido("El valor a depositar no es válido");
            else if(transac.getMonto() > Cuenta.MONTO_MAXIMO)
                throw new MontoMaximo("El valor supera el monto máximo autorizado");
        }
        }
        catch(MontoMaximo e){
            //e.printStackTrace();
            System.out.println(e.getMessage());
        }
        catch(MontoInvalido e){
            
        }
    }
    
    public static void realizarRetiro(Transaccion transac, Cuenta cuent) throws SaldoInsuficiente, MontoInvalido{
        try{
            if(transac.getMonto() <= cuent.getSaldo()){
            cuent.setSaldo(cuent.getSaldo() - transac.getMonto());
            Banco.agregarTransaccion(transac);
        }else{
            if(transac.getMonto() > cuent.getSaldo())
                throw new SaldoInsuficiente("El valor a retirar es mayor que el saldo actual");
            else if(transac.getMonto() < 0f)
                throw new MontoInvalido("El valor a retirar no es válido");
        }
        }
        catch(SaldoInsuficiente e){
            e.printStackTrace();
        }
        catch(MontoInvalido e){
            e.printStackTrace();
        }
    }
    
    public static boolean autenticarTransaccion(Transaccion transac) throws NumeroMaximoTransacciones{
        int contador = 0;
        try{
            for(Transaccion transaccion : transacciones){
            if(transaccion.getFecha() == transac.getFecha() && transaccion.getId() == transac.getId() && transaccion.getTipo() == transac.getTipo()){
                contador ++;
                if(contador == Cuenta.MAXIMO_TRANSACCIONES)
                    throw new NumeroMaximoTransacciones("Número máximo de transacciones superado");
            }
        }
        }
        catch(NumeroMaximoTransacciones e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
