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
public class HiloHacerCafe extends Thread{
    private CountDownLatch latch;
    
    public HiloHacerCafe(CountDownLatch l) {
        this.latch = l;
    }
    
    @Override
    public void run() {
        System.out.println("Haciendo el cafe...");
        try {
            // Dormimos el hilo entre 1s y 4s
            sleep((long) (Math.random()*3000+1000));
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Cafe hecho.");
        latch.countDown();
    }
}
