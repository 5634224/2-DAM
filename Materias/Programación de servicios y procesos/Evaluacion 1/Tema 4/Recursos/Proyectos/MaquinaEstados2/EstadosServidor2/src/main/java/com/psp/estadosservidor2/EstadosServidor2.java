/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.psp.estadosservidor2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Usuario
 */
public class EstadosServidor2 extends Thread {

    static final int PUERTO = 2020;

    // Constantes para los estados del servidor

    static final int COMANDO = 1;
    static final int NOMBRE_FICHERO = 3;
    static final int SALIR = -1;

    // Atributos del servidor
    Socket skCliente;
    int estado;

    // Constructor
    public EstadosServidor2(Socket sCliente) {
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
                new EstadosServidor2(sc).start();
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
            estado = COMANDO;
            // Código que maneja la máquina de estados
            do {
                // Recojo el comando del cliente
               
               // comando = flujoEntrada.readUTF();
                
                switch (estado) {
                     case COMANDO:
                        flujoSalida.writeUTF("Introduce comando (ls/get/exit)");
                        comando = flujoEntrada.readUTF();
                        if (comando.equals("ls")) {
                            System.out.println("Mostrando el contenido del fichero del directorio");
                            // Muestro el directorio     
                            flujoSalida.writeUTF("---- CONTENIDO DEL DIRECTORIO ----");
                            estado = COMANDO;
                            break;
                        } else if (comando.equals("get")) {
                            // Voy al estado 3 para mostrar el fichero
                            flujoSalida.writeUTF("Ha elegido GET");
                            estado = NOMBRE_FICHERO;
                            break;
                        } else if (comando.equals("exit")) {
                            flujoSalida.writeUTF("---- Exit ----");
                            estado = SALIR;
                        } else {
                            flujoSalida.writeUTF("---- Comando erróneo ----");
                            estado = COMANDO;
                        }
                        break;
                    case NOMBRE_FICHERO://voy a mostrar el archivo
                        flujoSalida.writeUTF("Introduce el nombre del archivo");
                        String fichero = flujoEntrada.readUTF();
                        System.out.println("Mostrando el contenido del fichero "+fichero);
                        flujoSalida.writeUTF("---- CONTENIDO DEL FICHERO ----");
                        
                        estado = COMANDO;
                        break;
                }
                System.out.println("Estado del servidor: " + estado);
            } while (estado != SALIR);
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
