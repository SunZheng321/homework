package com.Sunzhengzheng.supermarket;

public class Merchandise {


    public String name;
    public String id;
    public int count;
    public double soldPrice;
    public double purchasePrice;


    //利用方法使得商品自我描述；
    public void describe() {
        System.out.println("商品名字为" + name + "，id是" + id + "。 商品零售价：" + soldPrice
                + "元。商品进价：" + purchasePrice + "元。商品库存量是" + count +
                "件。每销售一个的毛利润是" + (soldPrice - purchasePrice));
    }

    //给方法中添加返回值，使得能够自己计算利润；
    public double calculateProfit() {
        double profit = soldPrice - purchasePrice;
        if (profit <= 0) {
            return 0;
        }
        return profit;
    }

    //通过参数，使得商品可以根据数量自动计算一些数据，如价格和利润等等；
    public  double buy(int countToBuy) {
        if (count < countToBuy) {
            System.out.println("商品库存不够");
            return -1;
        }



        int fullPriceCount = countToBuy / 2 + countToBuy % 2;
        int halfPriceCount = countToBuy - fullPriceCount;
        double totalCost = soldPrice * fullPriceCount + halfPriceCount * soldPrice / 2;

        count -= countToBuy;
        System.out.println("好的，请问您还需要其他的商品吗？" );
        return totalCost;
    }
}

