package com.Sunzhengzheng.supermarket;

import java.util.Scanner;

public class littleSupermarket {
    public String superMarketName="真心超市";
    public String address="济学路8号";
    public int parkingCount=200;
    public double incomingSum;
    public int[] merchandiseSold;
    public Merchandise[] merchandises;
    public void describe(){
        System.out.println("本店叫做"+superMarketName+"\n地址为"+address+"\n共有停车位"+parkingCount+"个。");

    }
}
