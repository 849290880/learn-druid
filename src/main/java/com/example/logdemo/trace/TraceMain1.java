package com.example.logdemo.trace;

import static com.example.logdemo.trace.TraceMain.calculatePrice;
import static com.example.logdemo.trace.TraceMain.countMoney;

public class TraceMain1 {

    /**
     * 第二天早开的冲高回落计算，开盘卖出的方案
     *
     */
    public static void main(String[] args) {

        double currentShares = 200; // 已持有的股票数
        double initialPrice = 0.808;   // 买入时的价格
        double money = countMoney((int) currentShares, initialPrice);

        System.out.println("原来购买的金额:"+money);

        double risePercent = 0.05;    // 目标上升多少个点

        double risePrice = calculateRicePrice(risePercent, initialPrice);

        System.out.println("上升之后单价"+ risePrice);

        double riseMoney = countMoney((int) currentShares, risePrice);

        System.out.println("上升之后卖出的金额:"+riseMoney);

        double getMoney = riseMoney - money;

        System.out.println("利润:"+getMoney);

        double thirdPrice1 = calculatePrice(0.005, money);

        System.out.println("卖出手续费:" + thirdPrice1);
    }



    public static double calculateRicePrice(double risePercent, double price) {
        return (risePercent+1) * price;
    }


}
