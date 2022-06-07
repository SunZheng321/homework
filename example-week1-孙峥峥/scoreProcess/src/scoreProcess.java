import java.util.Scanner;

//week1-例程3-孙峥峥-成绩处理；
//程序要点：1.创建大小为6的String数组来记录课程名称。2.用double数组来保存成绩。
// 实现功能：求某年最好成绩；求某年平均成绩；求所有年份最好成绩；求某门课历年最好成绩
public class scoreProcess {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // 声明六个变量作为六门科目索引
        int YuWenIndex = 0;
        int ShuXueIndex = 1;
        int WaiYuIndex = 2;
        int WuLiIndex = 3;
        int HuaXueIndex = 4;
        int ShengWuIndex = 5;

        String[] names = new String[6];
        names[0] = "语文";
        names[1] = "数学";
        names[2] = "外语";
        names[3] = "物理";
        names[4] = "化学";
        names[5] = "生物";

        // 用数组保存每门课的成绩.5年6门课各30名同学成绩；
        double[][][] scores = new double[5][6][30];
        // 用随机数给成绩赋值
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                for (int k = 0; k < 30; k++) {
                    scores[i][j][k] = 50 + Math.random() * 50;
                }
            }
        }
        // 是否结束查询操作
        boolean stopOption = false;
        double maxScore = -1;
        int maxScoreIndex = -1;
        int maxScoreyear = -1;
        int maxScoreStu = -1;
        double totalScore = 0;
        double averageScore = 0;
        while (!stopOption) {
            System.out.println("========欢迎使用成绩查询========\n请输入数字1-4来选择想进行的操作:\n1、查询某年最好成绩\n2、查询某年平均成绩\n3、查询历年最好成绩\n4、查询某门课历年最好成绩\n输入0退出程序");
            int optionNumber = in.nextInt();
            if (optionNumber == 0) {
                System.out.println("程序已退出！");
                stopOption = true;
                continue;
            }
            if (optionNumber < 0 || optionNumber > 4) {
                System.out.println("无效的操作代码！请重新输入1~4中的数字进行操作！");
                continue;
            }
            switch (optionNumber) {
                case 1:
                    System.out.println("已选择操作1，请输入想查询的年份，（查询年份为1~5）");
                    int year = in.nextInt();
                    switch (year) {
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                            for (int i = 0; i < 6; i++) {
                                for (int j = 0; j < 30; j++) {
                                    if (maxScore < scores[year - 1][i][j]) {
                                        maxScore = scores[year - 1][i][j];
                                        maxScoreIndex = i;
                                    }
                                }
                            }
                            System.out.println("您好！第" + year + "年最好成绩为：" + maxScore + "。所属科目是：" + names[maxScoreIndex]);
                    }
                    break;
                case 2:
                    System.out.println("已选择操作2，请输入想查询的年份，（查询年份为1~5）");
                    int year2 = in.nextInt();
                    switch (year2) {
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                            for (int i = 0; i < 6; i++) {
                                for (int j = 0; j < 30; j++) {
                                    totalScore += scores[year2 - 1][i][j];
                                    averageScore = totalScore % 180;
                                }
                            }
                            System.out.println("您好！第" + year2 + "年平均成绩为：" + averageScore + "。");
                            averageScore = 0;
                    }
                    break;
                case 3:
                    System.out.println("已选择操作3");
                    for (int i = 0; i < 5; i++) {
                        for (int j = 0; j < 6; j++) {
                            for (int k = 0; k < 30; k++) {
                                if (maxScore < scores[i][j][k]) {
                                    maxScore = scores[i][j][k];
                                    maxScoreyear = i;
                                    maxScoreIndex = j;
                                    maxScoreStu = k;
                                }
                            }
                        }
                    }
                    System.out.println("您好！历年最好成绩为：" + maxScore + "。由" + maxScoreStu + "同学在第" + (maxScoreyear + 1) + "年中的" + names[maxScoreIndex] + "科目中获得。");
                    break;
                case 4:
                    System.out.println("已选择操作4，请输入想查询的科目，\n1、语文\t2、数学\t3、外语\n4、物理\t5、化学\t6、生物");
                    int subject = in.nextInt();
                    switch (subject) {
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                            for (int i = 0; i < 5; i++) {
                                for (int j = 0; j < 30; j++) {
                                    if (maxScore < scores[i][subject - 1][j]) {
                                        maxScore = scores[i][subject - 1][j];
                                    }
                                }
                            }
                            System.out.println("您好！科目" + names[subject - 1] + "历年最好成绩为：" + maxScore + "。");
                            break;
                    }
            }


        }
    }
}
