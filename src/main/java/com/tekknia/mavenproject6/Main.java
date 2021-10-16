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
public class Main {
    public static void main(String[] args) throws Exception{
        //Scanner para atrapar las variables
        Scanner scan = new Scanner(System.in);
        Banco.agregarCuenta(new Cuenta(1,100000f));
        Banco.agregarCuenta(new Cuenta(2,50000f));
        while(true){
            System.out.println("1)Agregar\n2)Eliminar\n3)Consultar\n4)Depositar\n5)Retirar");
            int opcion = Integer.parseInt(scan.nextLine());
            int id, fecha;
            float saldo, monto;
            Transaccion transaccion;
            switch(opcion){
                case 1:
                    System.out.println("Digite el Id de la cuenta: ");
                    id = Integer.parseInt(scan.nextLine());
                    System.out.println("Digite el saldo actual: ");
                    saldo = Float.parseFloat(scan.nextLine());
                    Banco.agregarCuenta(new Cuenta(id, saldo));
                    break;
                case 2:
                    System.out.println("Digite el Id de la cuenta: ");
                    id = Integer.parseInt(scan.nextLine());
                    Banco.eliminarCuenta(id);
                    break;
                case 3:
                    System.out.println("Digite el Id de la cuenta: ");
                    id = Integer.parseInt(scan.nextLine());
                    try{
                        System.out.println("El saldo actual es: " + Banco.consultarCuenta(id).getSaldo());
                    }
                    catch(CuentaInexistente e){
                        System.out.println(e.getMessage() + "\n");
                    }
                    break;
                case 4:
                    System.out.println("Digite el Id de la cuenta: ");
                    id = Integer.parseInt(scan.nextLine());
                    System.out.println("Digite fecha actual: ");
                    fecha = Integer.parseInt(scan.nextLine());
                    System.out.println("Digite el valor del depósito: ");
                    monto = Float.parseFloat(scan.nextLine());
                    transaccion = new Transaccion(id,'D', fecha, monto);
                    Banco.realizarTransaccion(transaccion, Banco.consultarCuenta(id));
                    break;
                case 5:
                    System.out.println("Digite el Id de la cuenta: ");
                    id = Integer.parseInt(scan.nextLine());
                    System.out.println("Digite fecha actual: ");
                    fecha = Integer.parseInt(scan.nextLine());
                    System.out.println("Digite el valor del retiro: ");
                    monto = Float.parseFloat(scan.nextLine());
                    transaccion = new Transaccion(id,'R', fecha, monto);
                    Banco.realizarTransaccion(transaccion, Banco.consultarCuenta(id));
                    break;
            }
        }
    }
}
