package com.isoft.bean1;
class Wash{
    static int count=100;
    public  synchronized void wash(String name){
        for (int i = 100; i>=0 ; i--) {
            System.out.println(name+"=还剩"+count--+"个杯子");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class T1 extends Thread{
    Wash wash;
   public T1(Wash wash){
       this.wash=wash;
   }
    public void run() {
      //  System.out.println(Thread.currentThread().getName());
        //synchronized (wash){
        wash.wash(Thread.currentThread().getName());
       // }
    }
}class T2 extends Thread{
    Wash wash;
    public T2(Wash wash){
        this.wash=wash;
    }
    @Override
    public void run() {
        //System.out.println(Thread.currentThread().getName());
       // synchronized (wash){
        wash.wash(Thread.currentThread().getName());}
  //  }
}

public class TestSynchroized {
    public static void main(String[] args) {
        Wash wash=new Wash();
        new T1(wash).start();
        new T2(wash).start();
    }
}
