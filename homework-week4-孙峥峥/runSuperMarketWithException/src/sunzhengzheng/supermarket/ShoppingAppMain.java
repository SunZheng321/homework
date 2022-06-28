package sunzhengzheng.supermarket;
/*实例1-week4-让小超市运转起来-孙峥峥
程序主要步骤：
1:首先对超市需要实现的功能进行设计：(购物卡、种类、会员等级、折扣）
2、抽象出最本质的特性，放在接口中；
3、在impl类中继承各接口，然后经行功能填充。
4、练习抛出异常的语法(throws、throw）；throws常用在声明方法时，指定方法可能抛出的异常。throw常用来抛出自定义异常。
5、熟悉异常的传递：要么沿着方法调栈一路抛出，要么出错退出当前线程或者被捕获。
tips：由于时间原因，本周无法独立完成这个小超市例程，该例程使用的为视频课中的例程，非常抱歉。在后续的学习中会试着自己完成，本周的其他作业为自己独立完成。
 */
import sunzhengzheng.supermarket.impl.SimpleShopman;
import sunzhengzheng.supermarket.interfaces.Customer;
import sunzhengzheng.supermarket.interfaces.Shopman;
import sunzhengzheng.supermarket.interfaces.SuperMarket;

import static sunzhengzheng.supermarket.util.ShoppingUtil.*;

public class ShoppingAppMain {
    public static void main(String[] args) {
        SuperMarket superMarket = createSuperMarket();

        Shopman shopman = new SimpleShopman(superMarket);

        boolean open = true;
        while (open) {
            new ShoppingTask(shopman).executeTask();
            output("是否继续营业？(Yes)");
            open = ! input().next().trim().equalsIgnoreCase("no");
        }
        superMarket.dailyReport();
    }
}

class ShoppingTask {

    private Shopman shopman;

    public ShoppingTask(Shopman shopman) {
        this.shopman = shopman;
    }

    public void executeTask() {
        Customer customer = createCustomer(true);

        shopman.serveCustomer(customer);

    }

}
