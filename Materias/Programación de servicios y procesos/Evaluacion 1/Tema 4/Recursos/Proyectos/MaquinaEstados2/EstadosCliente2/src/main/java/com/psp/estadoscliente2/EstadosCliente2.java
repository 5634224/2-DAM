/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.psp.estadoscliente2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class EstadosCliente2{

 // Constantes
    static final String HOST = "localhost";
    static final int PUERTO = 2020;

    /**
     * @param args sin argumentos
     */
    public static void main(String[] args) {
        
        Socket sCliente = null;
                
        try {
            // Establece conexión
            sCliente = new Socket(HOST, PUERTO);

            // Creo los flujos de entrada y salida
            DataInputStream flujoEntrada = new DataInputStream(sCliente.getInputStream());
            DataOutputStream flujoSalida = new DataOutputStream(sCliente.getOutputStream());

            // Variables para solicitar comandos por teclado
            Scanner entrada = new Scanner(System.in);
            String comando;
            String datos="";

            // Solicito comandos hasta que se introduce salir
           comando = "";
           //Observa que el usuario puede escribir exit en un momento que el servidor no lo solicita en el menú
           //Solo saldremos de la aplicación cuando el servidor nos devuelva exit
            //while (!comando.equalsIgnoreCase("exit")) { 
            while (!datos.contains("Exit")) { 
                // Leo el mensaje de vuelta del servidor
                datos = flujoEntrada.readUTF();
                System.out.println("Servidor: " + datos);
                // Pido un comando al cliente
                System.out.print("--> ");
                comando = entrada.nextLine();
                //Se lo envío al servidor
                flujoSalida.writeUTF(comando);
               // if (!comando.equals("exit")){
                    datos = flujoEntrada.readUTF();
                    
                    System.out.println("Servidor: " + datos);
                //}
                
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                // Cierro la conexión
                try {
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                sCliente.close();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    
}

