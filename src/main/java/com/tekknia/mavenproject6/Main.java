/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tekknia.mavenproject6;
import java.io.*;
/**
 *
 * @author Vladimir Ortega - Alejandro Restrepo
 * Universidad de Antioquia - Técnicas de programación2021
 */
public class Main {
    
    public static InputStreamReader Leer = new InputStreamReader(System.in);
    public static BufferedReader Teclado = new BufferedReader(Leer);

    public static void main(String[] args) throws IOException {
        // TODO code application logic here

        System.out.println("Ingrese nombre del titular Cuenta");
        String pres;
        pres = Teclado.readLine();

        System.out.println("Ingrese # de Cuenta");
        String linea;
        linea = Teclado.readLine();

        while (linea.length() >= 11 || linea.length() < 10) {
            System.out.println("El # de la Cuenta es incorrecto");
            //System.out.println("El # de la Cuenta es mayor de 10 digitos : " + linea.length());
            linea = Teclado.readLine();
            if (linea.length() >= 10) {
                System.out.println("El # de la Cuenta es mayor de 10 digitos : " + linea.length());
            } else if (linea.length() < 10) {
                System.out.println("El # de la Cuenta es menor de 10 digitos : " + linea.length());
            }
            System.out.println("Verifique el numero de la Cuenta");
            linea = Teclado.readLine();
            //System.out.println("El # de la Cuenta es correcto es de : " + linea.length()+" digitos");
            //break;
        }

        System.out.println("El # de la Cuenta es correcto");

        System.out.println("Hola      " + pres);
        System.out.println("Ingrese el saldo de la cuenta");
        int saldo = Integer.parseInt(Teclado.readLine());
        Cuenta ban = new Cuenta(saldo);
        int as = ban.realizar(saldo);

        System.out.println("SU SALDO ES   " + as + "$");
        int menu1;

        do {
            System.out.println("QUE TRANSFERENCIA DESEA HACER");
            System.out.println("1:RETIRO");
            System.out.println("2:DEPOSITO");
            System.out.println("3:SALIR");
            menu1 = Integer.parseInt(Teclado.readLine());

// Este es un menu que pide ingresar retiro, deposito,tranferencia a hacer y salir.
            switch (menu1) {
                case 1:
                    System.out.println("Ingrese el Retiro");
                    int ret = Integer.parseInt(Teclado.readLine());
                    if (ret <= saldo) {
                        int retiro = ban.realizar(ret);
                        saldo = retiro;
                        System.out.println("Su retiro fue realizado con Éxito");
                        System.out.println("Su saldo es : ");
                        System.out.println(saldo);
                    }
                    break;
//Pide ingresar saldo y lo lee, pregunta si retiro menor que saldo, se envía  los siguientes mensajes y termina con el break.

                case 2:
                    System.out.println("Ingrese el Deposito");
                    int d = Integer.parseInt(Teclado.readLine());
                    int r = ban.realizar1(d);
                    saldo = r;
                    System.out.println("Su Deposito fue realizado con Éxito");
                    System.out.println("Su saldo actual es : ");
                    System.out.println(saldo);
                    break;
            }

        } while (menu1 < 3);
    }
    
}
