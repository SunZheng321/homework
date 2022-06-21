package sunzhengzheng.supermarket;

import java.util.Date;

public interface ExpireDateMerchandise {

 //是否超过保质期；
    default boolean notExpireInDays(int days) {
        return daysBeforeExpire() > days;
    }

//商品的生产日期
    Date getProducedDate();

 //商品到期日子
    public abstract Date getExpireDate();

    //所剩保质期百分比

    default double leftDatePercentage() {
        return 1.0 * daysBeforeExpire() / (daysBeforeExpire() + daysAfterProduce());
    }

//剩余的实际价值

    double actualValueNow(double leftDatePercentage);

    private long daysBeforeExpire() {
        long expireMS = getExpireDate().getTime();
        long left = expireMS - System.currentTimeMillis();
        if (left < 0) {
            return -1;
        }
        // 返回值是long，是根据left的类型决定的
        return left / (24 * 3600 * 1000);
    }

    private long daysAfterProduce() {
        long produceMS = getProducedDate().getTime();
        long left = System.currentTimeMillis() - produceMS;
        if (left < 0) {
            return -1;
        }
        // 返回值是long，是根据left的类型决定的
        return left / (24 * 3600 * 1000);
    }
}
