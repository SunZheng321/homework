package sunzhengzheng;
/*week3-homework-丰富小超市类型-孙峥峥
程序要点：
1、利用例程里的知识要点，继续丰富小超市商品类型
2、可以建一个是否支持5G（继承手机类）的商品，在此基础上是否支持双卡双待等等
*/
import sunzhengzheng.person.customer;
import sunzhengzheng.supermarket.ExpireDateMerchandise;
import sunzhengzheng.supermarket.Merchandise;
import sunzhengzheng.supermarket.littleSuperMarket;
import java.util.Scanner;


public class runSupermarketApp {
    public static void main(String[] args) {

        // 创建一个小超市类
        littleSuperMarket LittleSuperMarket = new littleSuperMarket("真心超市",
                "济学路8号", 200, 200, 200);

        // 统计用的数组
        LittleSuperMarket.merchandiseSold = new int[LittleSuperMarket.merchandises.length];

        // 为了使用方便，创建一个商品数组引用，和littleSuperMarket.merchandises指向同一个数组对象
        Merchandise[] all = LittleSuperMarket.merchandises;

        System.out.println("====欢迎来到小超市V3版====");

        boolean open = true;
        Scanner scanner = new Scanner(System.in);

        while (open) {
            LittleSuperMarket.describe();

            customer Customer = new customer();
            Customer.name = "顾客编号" + ((int) (Math.random() * 10000));
            Customer.money = (1 + Math.random()) * 30000;
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
                System.out.println("本店提供" + all.length + "种商品，欢迎选购。请输入商品编号");
                int index = scanner.nextInt();

                if (index < 0) {
                    break;
                }

                if (index >= all.length) {
                    System.out.println("本店没有这种商品，请叙述编号在0到" + (all.length - 1) + "之内的商品编号。");
                    continue;
                }

                Merchandise m = all[index];
                m.Categorydescribe();;
                if (index % 5 == 3 ) {
                    System.out.println("您选购的商品名字" + m.name + "。单价是" + m.soldPrice + "," +
                            "所属类别为:" + m.category +"。请问您要购买多少个？");
                }else {
                    ExpireDateMerchandise mm = (ExpireDateMerchandise) m;
                    System.out.println("您选购的商品名字" + m.name + "。单价是" + m.soldPrice + "," +
                            "所属类别为:" + m.category + ",保修期剩余百分比为"+mm.leftDatePercentage()+"。请问您要购买多少个？");
                }

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
