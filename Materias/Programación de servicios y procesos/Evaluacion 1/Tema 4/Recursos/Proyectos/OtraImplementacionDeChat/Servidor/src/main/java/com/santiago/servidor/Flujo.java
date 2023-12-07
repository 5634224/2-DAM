package com.santiago.servidor;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Enumeration;

public class Flujo extends Thread {
    Socket nsfd;
    DataInputStream FlujoLectura;
    DataOutputStream FlujoEscritura;

    public Flujo(Socket sfd) {
        nsfd = sfd;
        try {
            FlujoLectura = new DataInputStream(new BufferedInputStream(sfd.getInputStream()));
            FlujoEscritura = new DataOutputStream(new BufferedOutputStream(sfd.getOutputStream()));
        } catch (IOException ioe) {
            System.out.println("IOException(Flujo): " + ioe);
        }
    }

    public void run() {
        broadcast(nsfd.getInetAddress() + "> se ha conectado");
        Servidor.usuarios.add((Object) this);
        while (true) {
            try {
                String linea = FlujoLectura.readUTF();
                if (!linea.equals("")) {
                    linea = nsfd.getInetAddress() + "> " + linea;
                    broadcast(linea);
                }
            } catch (IOException e) {
                Servidor.usuarios.removeElement(this);
                broadcast(nsfd.getInetAddress() + "> se ha desconectado");
                break;
            }
        }
    }

    public void broadcast(String mensaje) {
        synchronized (Servidor.usuarios) {
            Enumeration e = Servidor.usuarios.elements();
            while (e.hasMoreElements()) {
                Flujo f = (Flujo) e.nextElement();
                try {
                    synchronized (f.FlujoEscritura) {
                        f.FlujoEscritura.writeUTF(mensaje);
                        f.FlujoEscritura.flush();
                    }
                } catch (IOException ioe) {
                    System.out.println("Error: " + ioe);
                }
            }
        }
    }
}