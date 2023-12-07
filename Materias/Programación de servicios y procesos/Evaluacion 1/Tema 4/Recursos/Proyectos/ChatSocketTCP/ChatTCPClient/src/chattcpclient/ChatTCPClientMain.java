package chattcpclient;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * Clase que implementa el cliente de un char usando un socket TCP.
 * En esta clase se realiza la conexión a un servidor, indicando el host
 * y el puerto, y se establece un socket TCP para intercambiar mensajes.
 * Para finalizar la conexión debe mandarse el mensaje "salir()".
 * 
 * @author profesoro
 */
public class ChatTCPClientMain {

    private Socket socket;
    private DataInputStream bufferDeEntrada = null;
    private DataOutputStream bufferDeSalida = null;
    Scanner teclado = new Scanner(System.in);
    final String COMANDO_TERMINACION = "salir()";

    public void levantarConexion(String ip, int puerto) {
        try {
            socket = new Socket(ip, puerto);
            mostrarTexto("Conectado a :" + socket.getInetAddress().getHostName());
        } catch (Exception e) {
            mostrarTexto("Excepción al levantar conexión: " + e.getMessage());
            System.exit(0);
        }
    }

    public static void mostrarTexto(String s) {
        System.out.println(s);
    }

    public void abrirFlujos() {
        try {
            bufferDeEntrada = new DataInputStream(socket.getInputStream());
            bufferDeSalida = new DataOutputStream(socket.getOutputStream());
            bufferDeSalida.flush();
        } catch (IOException e) {
            mostrarTexto("Error en la apertura de flujos");
        }
    }

    public void enviar(String s) {
        try {
            bufferDeSalida.writeUTF(s);
            bufferDeSalida.flush();
        } catch (IOException e) {
            mostrarTexto("IOException on enviar");
        }
    }

    public void cerrarConexion() {
        try {
            bufferDeEntrada.close();
            bufferDeSalida.close();
            socket.close();
            mostrarTexto("Conexión terminada");
        } catch (IOException e) {
            mostrarTexto("IOException on cerrarConexion()");
        } finally {
            System.exit(0);
        }
    }

    public void ejecutarConexion(String ip, int puerto) {
        Thread hilo = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    levantarConexion(ip, puerto);
                    abrirFlujos();
                    recibirDatos();
                } finally {
                    cerrarConexion();
                }
            }
        });
        hilo.start();
    }

    public void recibirDatos() {
        String st = "";
        try {
            do {
                st = (String) bufferDeEntrada.readUTF();
                mostrarTexto("\n[Servidor] => " + st);
                System.out.print("\n[Usted] => ");
            } while (!st.equals(COMANDO_TERMINACION));
        } catch (IOException e) {
        }
    }

    public void escribirDatos() {
        String entrada = "";
        while (true) {
            System.out.print("[Usted] => ");
            entrada = teclado.nextLine();
            if (entrada.length() > 0) {
                enviar(entrada);
            }
        }
    }

    public static void main(String[] argumentos) {
        ChatTCPClientMain cliente = new ChatTCPClientMain();
        Scanner escaner = new Scanner(System.in);
        mostrarTexto("Ingresa la IP: [localhost por defecto] ");
        String ip = escaner.nextLine();
        if (ip.length() <= 0) {
            ip = "localhost";
        }

        mostrarTexto("Puerto: [5050 por defecto] ");
        String puerto = escaner.nextLine();
        if (puerto.length() <= 0) {
            puerto = "5050";
        }
        cliente.ejecutarConexion(ip, Integer.parseInt(puerto));
        cliente.escribirDatos();
    }
}
