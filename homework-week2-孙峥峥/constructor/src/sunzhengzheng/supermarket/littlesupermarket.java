package sunzhengzheng.supermarket;

public class littlesupermarket {
        public String superMarketName;
        public String address;
        public int parkingCount;
        public double incomingSum;
        public Merchandise[] merchandises;
        public int[] merchandiseSold;
        public double activityDiscount;


        public littlesupermarket(String superMarketName, String address, int parkingCount,
                                 int merchandiseCount, int count) {
            this.superMarketName = superMarketName;
            this.address = address;
            this.parkingCount = parkingCount;

            merchandises = new Merchandise[merchandiseCount];
            for (int i = 0; i < merchandises.length; i++) {
                double purchasePrice = Math.random() * 200;
                // 创建并给商品的属性赋值
                Merchandise m = new Merchandise("商品" + i, "ID" + i, count, purchasePrice * (1 + Math.random()),
                        purchasePrice);
                // 用创建的商品，给商品数组的第i个引用赋值，all和小超市的商品数组引用指向的是同一个数组对象
                merchandises[i] = m;
            }
            merchandiseSold = new int[merchandises.length];
            System.out.println("本店叫做"+superMarketName+"\n地址为"+address+"\n共有停车位"+parkingCount+"\n共有商品"+count+"个。");
            activityDiscount = 0.7;//定义折上折
        }


    //得到利润最高的商品编号
        public Merchandise getBiggestProfitMerchandise() {
            Merchandise curr = null;
            for (int i = 0; i < merchandises.length; i++) {
                Merchandise m = merchandises[i];
                if (curr == null || curr.calculateProfit() < m.calculateProfit()) {
                    curr = m;
                }
            }
            return curr;
        }
        //取出商品；
        public Merchandise getMerchandiseOf(int merchandiseIndex) {
            if (merchandiseIndex < 0 || merchandiseIndex >= merchandises.length) {
                return null;
            }
            return merchandises[merchandiseIndex];
        }

}
