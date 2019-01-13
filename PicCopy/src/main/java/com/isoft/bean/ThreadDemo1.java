package com.isoft.bean;

class T1 extends Thread {
    int i=0;
    @Override
    public void run() {

        while (i<20){
        System.out.println("T1");
        if(i>10)
        { Thread.yield();//有的小问题
            System.out.println("yield");
        }
        i++;
        }

        //System.out.println(Thread.interrupted());
    }
}

class T2 implements Runnable {

    public void run() {
        try {
           // Thread.sleep(10);
            System.out.println("T2");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

public class ThreadDemo1 {
    public static void main(String[] args) {
        T1 t1 = new T1();
        System.out.println(t1.getPriority());
        T2 t2 = new T2();
        Thread t3 = new Thread(t2);
        t3.setPriority(10);
        t1.start();
        t3.start();
        if (t3.isInterrupted()){
            System.out.println("T3暂时中断");
        }
        System.out.println(t3.getPriority());
        Thread thread = Thread.currentThread();
        System.out.println("main");
   /*     System.out.println(thread.getName() + ","
                + thread.getPriority() + "," + thread.getState() + ","
                + thread.getThreadGroup());*/
    }
}
