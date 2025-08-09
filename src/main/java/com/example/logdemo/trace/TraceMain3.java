package com.example.logdemo.trace;

import static com.example.logdemo.trace.TraceMain.countMoney;

public class TraceMain3 {

    /**
     * 被套牢的股票割掉之后，重新买这个股票，要涨多少点才能形成总体赚钱
     *
     */
    public static void main(String[] args) {

        double currentShares = 1200; // 已持有的股票数
        double initialPrice = 0.808;   // 买入时的价格

        //被套牢了，遇到第二天最高点的价格
        double maxPrice = 0.872;

        //全部卖掉亏损
        double loseMoney = (initialPrice - maxPrice) * currentShares;

        System.out.println("痛心割肉亏损金额:"+ loseMoney);

        double initMoney = countMoney((int) currentShares, initialPrice);

        System.out.println("割肉之前的金额:"+initMoney);

        double getMoney = countMoney((int) currentShares, maxPrice);

        System.out.println("割肉之后的金额:"+getMoney);

        //那天的最低点
        double downPrice = 0.833;

        double buyShares = buyShare(downPrice,getMoney);

        System.out.println("用割肉的钱可以换的股票数量:" + buyShares);

        double newMoney = countMoney((int) buyShares, downPrice);

        System.out.println("花费金额:" + newMoney);

    }

    private static double buyShare(double price, double money) {
        // One purchase is 100 shares
        int sharesPerBatch = 100;

        // Calculate how many shares can be bought with available money
        int totalBatches = (int) (money / (sharesPerBatch * price)); // How many 100-share batches can be bought

        // Calculate total shares based on batches
        int totalShares = totalBatches * sharesPerBatch;

        return totalShares;
    }


}
