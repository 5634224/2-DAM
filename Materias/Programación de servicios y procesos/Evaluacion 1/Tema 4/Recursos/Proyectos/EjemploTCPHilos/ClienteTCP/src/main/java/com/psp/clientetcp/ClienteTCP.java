/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.psp.clientetcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

/**
 *
 * @author Usuario
 */
public class ClienteTCP {

    static final String HOST = "localhost";
    static final int Puerto = 2000;

    public ClienteTCP() {
        try {
            Socket skCliente = new Socket(HOST, Puerto);
            // Creo los flujos de entrada y salida
            DataInputStream flujo_entrada = new DataInputStream(skCliente.getInputStream());
            DataOutputStream flujo_salida = new DataOutputStream(skCliente.getOutputStream());

            // TAREAS QUE REALIZA EL CLIENTE
            String datos = flujo_entrada.readUTF();
            System.out.println(datos);

            skCliente.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] arg) {
        new ClienteTCP();
    }
}
