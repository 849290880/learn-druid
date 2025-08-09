package com.example.logdemo.trace;

public class TraceMain {

    /**
     * 预判行情是下行，套牢的情况下，解盘方法 （第二天开盘不能是低开，低开是解决不了问题的，买入之后是不能卖掉股票的）
     * @param args
     */
    public static void main(String[] args) {
        double currentShares = 1200; // 已持有的股票数
        double initialPrice = 0.880;   // 买入时的价格
        double targetPrice = 0.840;    // 目标平均价格
        double availableMoney = 2407;
//        double availableMoney = countMoney(1400,4.037); // 可用的资金
        System.out.println("当前可以用资金:" + availableMoney);
        double currentPrice = 0.79;   // 当前股票价格

        int additionalShares = calculateAdditionalShares(currentShares, initialPrice, targetPrice, availableMoney, currentPrice);
        System.out.println("需要购买的额外股票数量: " + additionalShares);
        double needMoney = countMoney(additionalShares, currentPrice);
        System.out.println("需要购买的额外股票的金额: " + needMoney);

        double percentageChange = calculatePercentageChange(targetPrice, currentPrice);

        printPercent(percentageChange);

        double money = countMoney((int) (additionalShares + currentShares), targetPrice);

        System.out.println("达到目标价格后卖出金额:" + money);

        System.out.println("利润:"+ (money - needMoney -countMoney((int) currentShares,currentPrice)));

        double thirdPrice = calculatePrice(0.005, needMoney);

        System.out.println("买入手续费:" + thirdPrice);

        double thirdPrice1 = calculatePrice(0.005, money);

        System.out.println("卖出手续费:" + thirdPrice1);

        System.out.println("总手续费："+ (thirdPrice + thirdPrice1));
    }

    public static double calculatePrice(double currentPrice, double price) {
        return currentPrice * price;
    }


    private static void printPercent(double percentageChange) {
        if (percentageChange > 0) {
            System.out.printf("股价上涨了 %.2f%%\n", percentageChange);
        } else if (percentageChange < 0) {
            System.out.printf("股价下跌了 %.2f%%\n", Math.abs(percentageChange));
        } else {
            System.out.println("股价没有变化。");
        }
    }

    // 计算某个价格相对于当前价格的涨跌百分比
    public static double calculatePercentageChange(double currentPrice, double previousPrice) {
        // 计算百分比变化
        double percentageChange = ((currentPrice - previousPrice) / previousPrice) * 100;
        return percentageChange;
    }

    public static double countMoney(Integer number,double price){
        return number * price;
    }


    // 计算要购买多少股才能将平均价格降低到z元
    public static int calculateAdditionalShares(double currentShares, double initialPrice, double targetPrice,
                                                double availableMoney, double currentPrice) {
        // 如果当前股价已经低于目标价，无需再购买
        if (currentPrice >= targetPrice) {
            System.out.println("当前股价已经低于目标价格，无需再购买。");
            return 0;
        }

        // 计算你当前持有股票的总成本
        double currentCost = currentShares * initialPrice;

        // 需要额外购买的股数才能将平均价格降到目标价
        int additionalShares = 0;

        while (true) {
            // 计算总的股数
            double totalShares = currentShares + additionalShares;

            // 计算新的平均价格
            double newAveragePrice = (currentCost + additionalShares * currentPrice) / totalShares;

            // 判断新的平均价格是否达到了目标价格
            if (newAveragePrice <= targetPrice) {
                break;
            }

            // 判断是否还有足够的现金来购买额外的股票
            if ((additionalShares + 1) * currentPrice > availableMoney) {
                System.out.println("现金不足，无法达到目标价格。");
                return additionalShares;
            }

            additionalShares=additionalShares+100;
        }

        return additionalShares;
    }
}
