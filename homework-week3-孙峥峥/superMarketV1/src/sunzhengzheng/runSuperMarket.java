package sunzhengzheng;
/*week3-例程1-给商品添加手机-孙峥峥
程序要点：
1、在商品中添加手机，通过继承来继承父类（Merchandise）的属性，同时也添加手机这个子类的特有成员变量（属性）；
2、通过覆盖（override），来使子类中的方法覆盖父类的方法，如利用buy方法来限制手机子类的购买数量，注意返回值必须一样。
3、利用super来调用父类的方法和属性，注意super不是对父类的引用；
4、引用的赋值问题：可以通过子类的引用给父类的引用，反之不行，因为子类中包含父类的所有属性和方法，但是反之却不是。“名”（即引用类型）决定了能做哪些操作。
5、protected是继承专属的权限修饰词，访问权限为本包中的类。注意子类覆盖父类的方法时，不能用更低的权限修饰符。
*/

import sunzhengzheng.person.customer;
import sunzhengzheng.supermarket.*;

import java.util.Scanner;

public class runSuperMarket {
    public static void main(String[] args) {

        // 创建一个小超市类
        littleSuperMarket LittleSuperMarket = new littleSuperMarket("真心超市", "济学路8号", 200, 200, 200);

        // 统计用的数组
        LittleSuperMarket.merchandiseSold = new int[LittleSuperMarket.merchandises.length];

        // 为了使用方便，创建一个商品数组引用，和littleSuperMarket.merchandises指向同一个数组对象
        Merchandise[] all = LittleSuperMarket.merchandises;

        System.out.println("欢迎来到小超市升级版V1！");

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
                m.describe();
                System.out.println("您选购的商品名字" + m.name + "。单价是" + m.soldPrice + "。请问您要购买多少个？");
                //输入要买的数量；
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
