package sunzhengzheng.supermarket;

import java.util.Date;

public class littleSuperMarket {
    public String superMarketName="真心超市";
    public String address="济学路8号";
    public int parkingCount=200;
    public double incomingSum;
    public int[] merchandiseSold;
    public Merchandise[] merchandises;

    public littleSuperMarket(String superMarketName, String address, int parkingCount,
                             int merchandiseCount, int count) {
        this.superMarketName = superMarketName;
        this.address = address;
        this.parkingCount = parkingCount;
        merchandises = new Merchandise[merchandiseCount];
        for (int i = 0; i < merchandises.length; i++) {
            // 创建手机，和普通商品，单数为普通商品，偶数为手机，都放在商品数组里
            Merchandise m = null;
            if (i > 0 & i % 2 == 0) {
                //利用父类的引用指向子类的实例来赋值，反之不可以
                m = new phone(
                        "商品" + i,
                        "ID" + i,
                        count,
                        1999,
                        999,
                        4.5,
                        3.5,
                        4,
                        128,
                        "三星",
                        "Android"

                );
            } else {
                double purchasePrice = Math.random() * 200;
                m = new Merchandise(
                        "商品" + i,
                        "ID" + i,
                        count,
                        purchasePrice * (1 + Math.random()),
                        purchasePrice

                );
            }
            // 用创建的商品，给商品数组的第i个引用赋值，all和小超市的商品数组引用指向的是同一个数组对象
            merchandises[i] = m;
        }
        merchandiseSold = new int[merchandises.length];
    }
    public void describe(){
        System.out.println("本店叫做"+superMarketName+"\n地址为"+address+"\n共有停车位"+parkingCount+"个。");

    }
}
