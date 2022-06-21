package sunzhengzheng.supermarket;

import java.util.Date;

public class gamePointsCard extends  Merchandise implements ExpireDateMerchandise {

        private Date produceDate;
        private Date expirationDate;


        public gamePointsCard(String name, String id, int count, double soldPrice, double purchasePrice, Date produceDate, Date expirationDate,Category category) {
            super(name, id, count, soldPrice, purchasePrice, category);
            this.produceDate = produceDate;
            this.expirationDate = expirationDate;
            this.category=category;
        }
       public void Categorydescribe()
        {
            System.out.println("注意！此商品为虚拟产品，需充值后使用！");
        }
    public void describe() {
        System.out.println("注意！此商品为虚拟产品，需充值后使用！");
        super.describe();

    }
        @Override
        public Date getProducedDate() {
            return produceDate;
        }

        @Override
        public Date getExpireDate() {
            return expirationDate;
        }

        @Override
        public double actualValueNow(double leftDatePercentage) {
            return super.getSoldPrice();
        }


    }
