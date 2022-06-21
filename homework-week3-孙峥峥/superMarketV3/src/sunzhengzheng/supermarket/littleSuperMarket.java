package sunzhengzheng.supermarket;

import java.util.Date;

public class littleSuperMarket {
    public String superMarketName = "真心超市";
    public String address = "济学路8号";
    public int parkingCount = 200;
    public double incomingSum;
    public int[] merchandiseSold;
    public Merchandise[] merchandises;

    public littleSuperMarket(String superMarketName, String address, int parkingCount,
                             int merchandiseCount, int count) {
        this.superMarketName = superMarketName;
        this.address = address;
        this.parkingCount = parkingCount;
        Date produceDate = new Date();
        Date expireDate = new Date(produceDate.getTime() + 365L * 24 * 3600 * 1000);
        merchandises = new Merchandise[merchandiseCount];
        for (int i = 0; i < merchandises.length; i++) {
            // 创建手机，手机壳变色手机，和普通商品，都放在商品数组里
            Merchandise m = null;
            int rem = i % 5;
            switch (rem) {
                case 0:
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
                            "Android", produceDate,
                            expireDate,
                            Category.ELECTRIC);

                    break;
                case 1:
                    m = new fiveGphone(
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
                            "Android", produceDate,
                            expireDate,
                            Category.ELECTRIC
                    );
                    break;
                case 2:
                    m = new doubleCardPhone(
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
                            "Android", produceDate,
                            expireDate,
                            Category.ELECTRIC
                    );
                    break;
                case 3:
                    double purchasePrice = Math.random() * 200;
                    m = new Merchandise(
                            "商品" + i,
                            "ID" + i,
                            count,
                            purchasePrice * (1 + Math.random()),
                            purchasePrice,
                            Category.FOOD
                    );
                    break;
                case 4:
                    m = new gamePointsCard("商品" + i,
                            "ID" + i, 200, 300, 200, produceDate, expireDate, Category.VIRTUALPRODUCT);
                    break;
            }


            // 用创建的商品，给商品数组的第i个引用赋值，all和小超市的商品数组引用指向的是同一个数组对象
            merchandises[i] = m;
        }
        merchandiseSold = new int[merchandises.length];
    }

    public void describe() {
        System.out.println("本店叫做" + superMarketName + "\n地址为" + address + "\n共有停车位" + parkingCount + "个。");

    }
}