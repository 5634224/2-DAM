/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.psp.ejemplocountdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author profesoro
 */
public class EjemploCountDownLatch {

    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(3);
        
        Thread hiloCafe = new HiloHacerCafe(latch);
        Thread hiloTostadas = new HiloTostadas(latch);
        Thread hiloZumo = new HiloZumoNaranja(latch);
      
        
        System.out.println("Preparando desayuno...");
        
        hiloCafe.start();
        hiloTostadas.start();
        hiloZumo.start();
        
        try {
            latch.await();
        } catch (InterruptedException ex) {
            Logger.getLogger(EjemploCountDownLatch.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Desayuno servido.");
    }
}
