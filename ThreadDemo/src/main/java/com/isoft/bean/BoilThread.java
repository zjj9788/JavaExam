package com.isoft.bean;

public class BoilThread extends Thread {

    @Override
    public void run() {
        System.out.println("烧水...");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("水被烧开");
    }
}
