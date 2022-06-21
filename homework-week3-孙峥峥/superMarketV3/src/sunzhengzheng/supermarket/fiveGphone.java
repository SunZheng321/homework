package sunzhengzheng.supermarket;

import java.util.Date;

public class fiveGphone extends phone{
    private boolean enable5G;

    public fiveGphone(String name, String id, int count, double soldPrice, double purchasePrice,
                                 double screenSize, double cpuHZ, int memoryG, int storageG, String brand, String os,
                      Date produceDate, Date expirationDate,Category category) {
        super(name, id, count, soldPrice, purchasePrice, screenSize, cpuHZ, memoryG, storageG, brand, os,
                produceDate, expirationDate,category);
        enable5G = false;
    }

    public boolean isEnable5G() {
        return enable5G;
    }

    public void setEnable5G(boolean enable5G) {
        this.enable5G = enable5G;
    }
    public void Categorydescribe()
    {
        System.out.println("注意！此商品为手机产品（支持5G），激活后无法退换！");
    }
    @Override
    public void describe() {
        super.describe();
        System.out.println("5G功能开启状态：" + enable5G);
    }

    @Override
    public double calculateProfit() {
        // TODO 厂家提供10个点的返点
        return super.calculateProfit() + super.getPurchasePrice() * 0.1;
    }
}
