/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.psp.estadosservidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Usuario
 */
public class EstadosServidor  extends Thread {

    static final int PUERTO = 2020;

    // Atributos del servidor
    Socket skCliente;
    int estado;

    // Constructor
    public EstadosServidor(Socket sCliente) {
        this.skCliente = sCliente;
    }

    /**
     * @param args sin argumentos
     */
    public static void main(String[] args) {

        try {
            // Inicio el servidor en el puerto
            ServerSocket skServidor = new ServerSocket(PUERTO);
            System.out.println("Escuchando en el puerto " + PUERTO);

            // Bucle para atender a los clientes concurrentemente
            while (true) {
                // Se conecta un cliente
                Socket sc = skServidor.accept();
                System.out.println("Cliente conectado");

                // Atiendo al cliente mediante un hilo
                new EstadosServidor(sc).start();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void run() {
        try {
            // Creo los flujos de entrada y salida
            DataInputStream flujoEntrada = new DataInputStream(skCliente.getInputStream());
            DataOutputStream flujoSalida = new DataOutputStream(skCliente.getOutputStream());

            // Variable para recoger el comando del cliente
            String comando;

            // Inicializo el estado del servidor
            estado = 1;
            // Código que maneja la máquina de estados
            do {
                switch (estado) {
                        
                    case 1:
                        flujoSalida.writeUTF("Introduce comando (ls/get/exit)");
                        comando = flujoEntrada.readUTF();
                        if (comando.equals("ls")) {
                            System.out.println("Mostrando el contenido del fichero del directorio");
                            // Muestro el directorio                            
                            estado = 1;
                            break;
                        } else if (comando.equals("get")) {
                            // Voy al estado 3 para mostrar el fichero
                            estado = 3;
                            break;
                        } else if (comando.equals("exit")) {
                            estado = -1;
                        } else {
                            estado = 1;
                        }
                        break;
                    case 3://voy a mostrar el archivo
                        flujoSalida.writeUTF("Introduce el nombre del archivo");
                        String fichero = flujoEntrada.readUTF();
                        System.out.println("Mostrando el contenido del fichero "+fichero);
                        estado = 1;
                        break;
                }
                System.out.println("Estado del servidor: " + estado);
            } while (estado != -1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                // Se cierra la conexión
                skCliente.close();
                System.out.println("Cliente desconectado");
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

}

