/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.psp.servidortcphilos;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Usuario
 */
public class ServidorTCPHilos extends Thread {

    Socket skCliente;
    static final int Puerto = 2000;

    public ServidorTCPHilos(Socket sCliente) {
        skCliente = sCliente;
    }

    public static void main(String[] arg) {
        try {
            // Inicio el servidor en el puerto
            ServerSocket skServidor = new ServerSocket(Puerto);
            System.out.println("Escucho el puerto " + Puerto);

            while (true) {
                // Se conecta un cliente
                Socket skCliente = skServidor.accept();
                System.out.println("Cliente conectado");
                // Atiendo al cliente mediante un thread
                new ServidorTCPHilos(skCliente).start();
            }
        } catch (Exception e) {;
        }
    }
    //Cada hilo atiende a un cliente
    //Observa en los mensajes que es dificil saber sobre qué cliente escribe
    public void run() {
        try {
            
            // Creo los flujos de entrada y salida
            DataInputStream flujo_entrada = new DataInputStream(skCliente.getInputStream());
            DataOutputStream flujo_salida = new DataOutputStream(skCliente.getOutputStream());
            //Este sleep es para simular que estamos haciendo algo y ver que ocurre al conectarse más de un cliente a la vez
            Thread.sleep(5000);
            // ATENDER PETICIÓN DEL CLIENTE
            flujo_salida.writeUTF("Se ha conectado el cliente de forma correcta");
            
            // Se cierra la conexión del cliente
            skCliente.close();
            System.out.println("Cliente desconectado");
            //El hilo actual termina
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}

