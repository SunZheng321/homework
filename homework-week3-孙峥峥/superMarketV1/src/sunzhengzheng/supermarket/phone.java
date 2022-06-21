package sunzhengzheng.supermarket;

public class phone extends Merchandise {
    // 给phone增加新的属性和方法
    private double screenSize;
    private double cpuHZ;
    private int memoryG;
    private int storageG;
    private String brand;
    private String os;
    private static int MAX_BUY_ONE_ORDER = 5;

    public phone(String name, String id, int count, double soldPrice, double purchasePrice,
                 double screenSize, double cpuHZ, int memoryG, int storageG, String brand, String os)
    {
        this.screenSize = screenSize;
        this.cpuHZ = cpuHZ;
        this.memoryG = memoryG;
        this.storageG = storageG;
        this.brand = brand;
        this.os = os;

        this.setName(name);
        this.setId(id);
        this.setCount(count);
        this.setSoldPrice(soldPrice);
        this.setPurchasePrice(purchasePrice);
    }
//通过覆盖，使得商品有自己的购买限制，也可以设置其他子类方法来覆盖父类，如在计算利润中，不同商品打折的力度不同，通过修改利润计算方法即可。
    public double buy(int count) {
        if (count > MAX_BUY_ONE_ORDER) {
            System.out.println("购买失败，手机一次最多只能买" + MAX_BUY_ONE_ORDER + "个");
            return -2;
        }
        //当满足购买数量时，通过super来直接调用父类的buy方法即可
        return super.buy(count);
    }

    public String getName() {
        return this.brand + ":" + this.os + ":" + super.getName();
    }

    public void describe() {
        System.out.println("此商品为手机！");
        super.describe();
        System.out.println("手机厂商为" + brand + "；系统为" + os + "；硬件配置如下：\t" +
                "屏幕：" + screenSize + "寸\t" +
                "cpu主频" + cpuHZ + " GHz\t" +
                "内存" + memoryG + "Gb\t" +
                "存储空间" + storageG + "Gb");
    }

    public boolean meetCondition() {
        return true;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public double getCpuHZ() {
        return cpuHZ;
    }

    public void setCpuHZ(double cpuHZ) {
        this.cpuHZ = cpuHZ;
    }

    public int getMemoryG() {
        return memoryG;
    }

    public void setMemoryG(int memoryG) {
        this.memoryG = memoryG;
    }

    public int getStorageG() {
        return storageG;
    }

    public void setStorageG(int storageG) {
        this.storageG = storageG;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }
}

