package com.isoft.bean2;

//实现各个售票点售票的功能
class TicketOffice implements Runnable {
    Object obj;
    int ticketCount;

    public TicketOffice(Object obj, int ticketCount) {
        this.obj = obj;
        this.ticketCount = ticketCount;
    }

    public void run() {
        while (ticketCount >= 0) {
            synchronized (obj){
            if (ticketCount <= 0) {
                System.out.println("没有票了，停止售卖");
              // Thread.currentThread().stop();
                break;
            } else
                System.out.println(Thread.currentThread().getName()
                        + "售票点买了一张，还是剩下" + --ticketCount + "张票");
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }}
    }
}

public class TestTicketDemo {
    public static void main(String[] args) {
        TicketOffice ticketOffice = new TicketOffice("中国高铁", 1000);
        new Thread(ticketOffice, "天津高铁").start();
        new Thread(ticketOffice, "北京高铁").start();
        new Thread(ticketOffice, "重庆高铁").start();
    }
}
