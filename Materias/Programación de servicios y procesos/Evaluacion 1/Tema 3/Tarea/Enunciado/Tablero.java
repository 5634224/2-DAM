package org.example;

import java.util.Random;

/**
 * Clase para gestionar un tablero 3x3 para las 3 en raya
 */
public class Tablero {
    String [][] tablero;
    public Tablero(){
        tablero  = new String [3][3]; //Creación del tablero
    }

    /**
     * Inicializa todas las posiciones del tablero con un -
     */
    public  void inicializaTablero(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tablero[i][j] = "-";
            }
        }
    }

    /**
     * Comprueba si existe alguna línea del símbolo indicado y por lo tanto tendríamos ya un ganador
     * @param simbolo "o" ó "x"
     * @return Si existe alguna línea del símbolo indicado
     */
    public boolean compruebaGanador(String simbolo){
        return (tablero[0][0].equals(simbolo) && tablero[0][1].equals(simbolo) && tablero[0][2].equals(simbolo))
                || (tablero[1][0].equals(simbolo) && tablero[1][1].equals(simbolo) && tablero[1][2].equals(simbolo))
                || (tablero[2][0].equals(simbolo) && tablero[2][1].equals(simbolo) && tablero[2][2].equals(simbolo))

                || (tablero[0][0].equals(simbolo) && tablero[1][0].equals(simbolo) && tablero[2][0].equals(simbolo))
                || (tablero[0][1].equals(simbolo) && tablero[1][1].equals(simbolo) && tablero[2][1].equals(simbolo))
                || (tablero[0][2].equals(simbolo) && tablero[1][2].equals(simbolo) && tablero[2][2].equals(simbolo))

                || (tablero[0][0].equals(simbolo) && tablero[1][1].equals(simbolo) && tablero[2][2].equals(simbolo))
                || (tablero[0][2].equals(simbolo) && tablero[1][1].equals(simbolo) && tablero[2][0].equals(simbolo));
    }

    /**
     * Genera una jugada aleatoria para el servidor que juega con "o" o minúscula
     */
    public  void generarJugadaServidor(){
        Random randomGenerator = new Random();
        int i, j;
        boolean ok= false;
        do{
            i = randomGenerator.nextInt(3); //0-2
            j = randomGenerator.nextInt(3);//0-2
        }while(!tablero[i][j].equals("-")); //Genero números del 0 al 2 hasta que encuentre una posición libre
        tablero[i][j] = "o"; //Guardo en esa posición la "o" o minúscula
    }

    /**
     * Imprimo cada fila en una línea separada y las posiciones separadas por espacio
     */
    public  void imprimeTablero(){
        for (int i = 0; i < 3; i++) {
            System.out.println(tablero[i][0] +" "+ tablero[i][1] +" "+ tablero[i][2]);
        }
    }

    /**
     * Guarda una jugada en la fila y columna indicada
     * Precondición: La fila y columna son válidas
     * @param fila Entero con la fila del tablero
     * @param columna Entero con la columna del tablero
     * @param valor "o" ó "x" dependiendo del jugador
     */
    public void setTableroPosicion(int fila, int columna, String valor){
        tablero[fila][columna] = valor;
    }

    /**
     * Devuelve el contenido de una posición dada del tablero
     * Precondición: La fila y columna son válidas
     * @param fila Entero con la fila del tablero
     * @param columna Entero con la columna del tablero
     * @return Devuelve el valor de esa posición
     */
    public String getTableroPosicion(int fila, int columna){
        return tablero[fila][columna];
    }

    /**
     * Imprime por pantalla una fila del tablero
     * @param i Entero con la fila a imprimir
     * @return Un string correspondiente a la fila con las posiciones separadas por espacios
     */
    public String getFila(int i){
        return tablero[i][0] +" "+ tablero[i][1] +" "+ tablero[i][2];
    }

    /**
     * Comprueba si hay un empate.
     */
    public boolean empate(){

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(tablero[i][j].equals("-")) return false; //En el momento que hay un espacio no hay empate
            }
        }
        return true;
    }
}
