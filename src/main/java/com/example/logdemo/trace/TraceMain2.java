package com.example.logdemo.trace;

import static com.example.logdemo.trace.TraceMain.calculatePrice;
import static com.example.logdemo.trace.TraceMain.countMoney;

public class TraceMain2 {

    /**
     * 第二天 看到预判股票下跌然后购买的方法
     *
     */
    public static void main(String[] args) {

        double initialPrice = 10.39;   // 买入时的价格

        double downPercent = 0.05;    // 目标下升多少个点

        double downPrice = calculateDownPrice(downPercent, initialPrice);

        System.out.println("下降之后单价"+ downPrice);

        double currentShares = 300; // 打算的股票数

        double money = countMoney((int) currentShares, downPrice);

        double thirdPrice1 = calculatePrice(0.005, money);

        System.out.println("卖出手续费:" + thirdPrice1);



    }

    public static double calculateDownPrice(double downPercent, double price) {
        return (1-downPercent) * price;
    }


}
