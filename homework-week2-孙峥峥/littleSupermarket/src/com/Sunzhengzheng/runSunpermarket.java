package com.Sunzhengzheng;

import java.util.Scanner;

import com.Sunzhengzheng.person.customer;
import com.Sunzhengzheng.supermarket.*;

/*week2-例程1打造小超市-孙峥峥；
程序要点：
1.首先通过类、对象和引用来打造一个小超市（时刻记住类是一个自定义数据类型，这样引用时思维不会乱）
2、在类中添加方法使得可以自我描述
3、通过在方法中添加返回值使得可以计算所需的数值
4、通过给方法添加参数，使得自己计算利润。
5、方法，返回值和参数是相互联系的
*/

public class runSunpermarket {
    public static void main(String[] args) {

        // 创建一个小超市类
        littleSupermarket LittleSuperMarket = new littleSupermarket();
        // 依次给超市的名字，地址，停车位赋值
        LittleSuperMarket.superMarketName = "真心超市";
        LittleSuperMarket.address = "济学路8号";
        LittleSuperMarket.parkingCount = 200;
        // 给超市200种商品
        LittleSuperMarket.merchandises = new Merchandise[200];
        // 统计用的数组
        LittleSuperMarket.merchandiseSold = new int[LittleSuperMarket.merchandises.length];

        // 为了使用方便，创建一个商品数组引用，和littleSuperMarket.merchandises指向同一个数组对象
        Merchandise[] all = LittleSuperMarket.merchandises;

        // 遍历并给200种商品赋值
        for (int i = 0; i < all.length; i++) {
            // 创建并给商品的属性赋值
            Merchandise m = new Merchandise();
            m.name = "商品" + i;
            m.count = 200;
            m.purchasePrice = Math.random() * 200;
            m.soldPrice = m.purchasePrice * (1 + Math.random());
            m.id = "ID" + i;
            // 用创建的商品，给商品数组的第i个引用赋值，all和小超市的商品数组引用指向的是同一个数组对象
            all[i] = m;
        }
        System.out.println("超市开门啦！");

        boolean open = true;
        Scanner scanner = new Scanner(System.in);

        while (open) {
            LittleSuperMarket.describe();

            customer Customer = new customer();
            Customer.name = "顾客编号" + ((int) (Math.random() * 10000));
            Customer.money = (1 + Math.random()) * 1000;
            Customer.DrivingCarorNot = Math.random() > 0.5;

            if (Customer.DrivingCarorNot) {
                if (LittleSuperMarket.parkingCount > 0) {
                    System.out.println("欢迎" + Customer.name + "驾车而来。本店已经为您安排了车位，停车免费哦。车位编号为"
                            + LittleSuperMarket.parkingCount);
                    LittleSuperMarket.parkingCount--;
                } else {
                    System.out.println("不好意思，本店车位已满。欢迎您下次光临");
                    continue;
                }
            } else {
                System.out.println("欢迎" + Customer.name + "光临本店");
            }

            double totalCost = 0;
            while (true) {
                System.out.println("本店提供" + all.length + "种商品，今天全场半价。欢迎选购。请输入商品编号");
                int index = scanner.nextInt();

                if (index < 0) {
                    break;
                }

                if (index >= all.length) {
                    System.out.println("本店没有这种商品，请叙述编号在0到" + (all.length - 1) + "之内的商品编号。");
                    continue;
                }

                Merchandise m = all[index];

                System.out.println("您选购的商品名字" + m.name + "。单价是" + m.soldPrice + "。请问您要购买多少个？");
                int numToBuy = scanner.nextInt();

                if (numToBuy <= 0) {
                    System.out.println("不买看看也好，欢迎继续挑选。");
                    continue;
                }

                if (numToBuy > m.count) {
                    System.out.println("本店此商品库存没有这么多，欢迎继续选购。");
                    continue;
                }

                if (numToBuy * m.soldPrice + totalCost > Customer.money) {
                    System.out.println("您带的钱不够，欢迎继续挑选");
                    continue;
                }
                double cost = m.buy(numToBuy);
                totalCost += cost;

                m.count -= numToBuy;
                LittleSuperMarket.merchandiseSold[index] += numToBuy;
            }

            Customer.money -= totalCost;

            if (Customer.DrivingCarorNot) {
                LittleSuperMarket.parkingCount++;
            }

            System.out.println("顾客" + Customer.name + "共消费了" + totalCost);

            LittleSuperMarket.incomingSum += totalCost;

            System.out.println("还继续营业吗？");
            open = scanner.nextBoolean();

        }

        System.out.println("超市关门了！");
        System.out.println("今天总的营业额为" + LittleSuperMarket.incomingSum + "。营业情况如下");

        for (int i = 0; i < LittleSuperMarket.merchandiseSold.length; i++) {
            Merchandise m = all[i];
            int numSold = LittleSuperMarket.merchandiseSold[i];
            if (numSold > 0) {
                double incomming = m.soldPrice * numSold;
                double netIncomming = (m.soldPrice - m.purchasePrice) * numSold;
                System.out.println(m.name + "售出了" + numSold + "个。销售额为"
                        + incomming + "。净利润为" + netIncomming);
            }
        }

    }








}

