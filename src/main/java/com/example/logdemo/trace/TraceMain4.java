package com.example.logdemo.trace;

import static com.example.logdemo.trace.TraceMain.countMoney;

public class TraceMain4 {

    /**
     * 被套牢的股票割掉之后，重新买这个股票，要涨多少点才能形成总体赚钱
     *
     */
    public static void main(String[] args) {

        double firstShares = 100; // 已持有的股票数
        double initialPrice = 0.808;   // 买入时的价格

        double secondShares = 100; // 已持有的股票数
        double price = 0.879;   // 买入时的价格

        double shares3 = 100; // 已持有的股票数
        double price3 = 0.879;   // 买入时的价格

        double v = countMoney((int) firstShares, initialPrice) +
                countMoney((int) secondShares, price) + countMoney((int) shares3,price3);

        double v1 = v / (firstShares + secondShares + shares3);

        System.out.println("平均股价:" + v1);

    }


}
