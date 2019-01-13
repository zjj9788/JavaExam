package com.isoft.bean3;

import java.util.Scanner;

/*模拟银行取款功能*/
class Account {
    String name;
    double money;

    public Account() {
        System.out.println("请输入账户姓名:");
        Scanner sc = new Scanner(System.in);
        name = sc.next();
        System.out.println("请输入开户金额：");
        money = sc.nextDouble();
    }

    public void draw(double money) {
        this.money -= money;
    }

    public String getName() {
        return name;
    }

    public double getMoney() {
        return money;
    }
}

public class TestGetMoney {
    public static void main(String[] args) {
        Account account = new Account();//含有给账户复制的方法
        Bank bank = new Bank(account, "中国银行");
        Thread t1 = new Thread(bank);
        t1.setName("窗口1");
        Thread t2 = new Thread(bank);
        t2.setName("窗口2");
        t1.start();
        t2.start();
    }
}
