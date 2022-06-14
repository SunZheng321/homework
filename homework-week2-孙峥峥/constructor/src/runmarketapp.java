import sunzhengzheng.supermarket.Merchandise;
import sunzhengzheng.supermarket.littlesupermarket;

import java.util.Scanner;

/*week2-例程构造方法重载与调用、静态变量和方法；-孙峥峥
程序要点：
1、利用构造方法，使得对象自动调用
2、利用构造方法的重载与调用，简化类似流程的代码
3、利用静态变量和静态方法给某些参数赋值；
*/
public class runmarketapp {
    public static void main(String[] args) {
        // 创建一个小超市类
        littlesupermarket LittleSuperMarket = new littlesupermarket(
                "真心超市", "济学路8号",
                200, 200, 200);
        Scanner scanner=new Scanner(System.in);
        System.out.println("下面请利润最高的商品自我介绍：");
        LittleSuperMarket.getBiggestProfitMerchandise().describe();
        System.out.println("VIP普通折扣为："+Merchandise.getVIPDiscount());
        System.out.println("VIP的折上折折扣最终为：" + Merchandise.getDiscountOnDiscount(LittleSuperMarket));

    }
}
