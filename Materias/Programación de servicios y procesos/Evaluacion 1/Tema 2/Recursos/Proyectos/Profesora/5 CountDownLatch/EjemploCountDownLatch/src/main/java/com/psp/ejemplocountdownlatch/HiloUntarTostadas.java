/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.psp.ejemplocountdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 *
 * @author profesoro
 */
public class HiloUntarTostadas extends Thread {
    private CountDownLatch latch;
    
    public HiloUntarTostadas(CountDownLatch l) {
        this.latch = l;
    } 
    
    @Override
    public void run() {
        System.out.println("Untando las tostadas...");
        try {
            // Dormimos el hilo entre 1s y 2s
            sleep((long) (Math.random() * 1000 + 1000));
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Tostadas untadas.");
        latch.countDown();
    }
}
