package com.isoft.bean3;

import java.util.Scanner;

public class Bank extends Thread{
    Account account;
    Object obj;
    Scanner scanner;
    public Bank(Account account,Object obj){
        scanner=new Scanner(System.in);
        this.account=account;
        this.obj=obj;
    }

    @Override
    public void run() {
      synchronized (obj){
          while (account.getMoney()>0){
              System.out.println("请到"+Thread.currentThread().getName()+"进行取款");
              System.out.println("请输入要取款的金额：");
              double drawMoney=scanner.nextDouble();
              if(account.getMoney()<drawMoney){
                  System.out.println("账户余额不足,剩余金额为"+account.getMoney()+"元");
              }else{
                  account.draw(drawMoney);
                  System.out.println(account.getName()+"成功取了"+drawMoney
                          +"元，剩余余额为"+account.getMoney()+"元");
                  break;
              }
          }
      }
    }
}
