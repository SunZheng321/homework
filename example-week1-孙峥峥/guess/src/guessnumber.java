//week1-例程练习2-孙峥峥：猜数字游戏
//程序要点：1，利用random生成随机数2，利用scanner读取输入3，利用循环语句判断；


import java.util.Scanner;

public class guessnumber {
    public static void main(String[] args) {
        //设置游戏参数变量
        int rangeStart = 1;
        int rangeEnd = 20;
        int guesscount = 6;
        //统计游戏次数；
        int totalGameCount = 0;
        int totalCorrectCount = 0;
        //读取输入
        Scanner in = new Scanner(System.in);

        boolean gameStop = false;
        while (!gameStop) {
            int mod = rangeEnd - rangeStart;
            double random = Math.random();
            int correctNumber = rangeStart + (int) (random * rangeEnd * 1000) % mod;

            //防止目标数越界
            if (correctNumber <= rangeStart) {
                correctNumber = rangeStart + 1;
            }
            if (correctNumber >= rangeEnd) {
                correctNumber = rangeEnd - 1;
            }
            System.out.println("\t\t===========猜数字游戏=========\n" + "请在" + rangeStart + "和" + rangeEnd + "范围内猜测一个整数，不包括这两个数。如想退出游戏，请输入0");

            //System.out.println(correctNumber);
            //判断游戏是否开始，放在输入范围内数字后面
            boolean gameStart = true;
            //用来判断是否猜中
            boolean guessCorrect = false;
            int guessLeft = guesscount;
            while (guessLeft > 0) {
                System.out.println("还有" + guessLeft + "机会，请输入猜测的数字");
                int guessNum = in.nextInt();
                // 输入0，结束游戏
                if (guessNum == 0) {
                    gameStop = true;
                    guessCorrect=true;
                    break;
                }
                //当输入非法数值时，用continue返回循环初始
                if (guessNum <= rangeStart || guessNum >= rangeEnd) {
                    System.out.println("请输入范围内数字！");
                    continue;
                }
                //只要输入了合法范围数字，就使得猜测次数加一
                if (gameStart) {
                    totalGameCount++;
                    gameStart = false;
                }
                if (guessNum == correctNumber) {
                    guessCorrect = true;
                    totalCorrectCount++;
                    System.out.println("恭喜你，猜测正确！" + "本次的数字为" + correctNumber + "\t\t" + "共猜测了" + totalGameCount + "次,猜对" + totalCorrectCount + "次");
                    break;
                } else if (guessNum > correctNumber) {
                    System.out.println("猜测值比正确值大");
                    guessLeft--;
                } else {
                    System.out.println("猜测的数字比正确值小");
                    guessLeft--;
                }

            }
            if (!guessCorrect) {
                System.out.println("很遗憾，本次没有猜对！正确的数字为：" + correctNumber + "\t\t" + "共猜测了" + totalGameCount + "次,猜对" + totalCorrectCount + "次");
            }else {
                System.out.println("程序已退出！");
            }
        }
    }
}
