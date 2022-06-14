package homework.Sunzhengzheng.remodelguessnumber;
//创建猜数字游戏类

import java.util.Scanner;

public class remodelGuessNumber {
    public int rangeStart;//开始数字
    public int rangeEnd;//结束数字
    public int guesscount;//

    Scanner in = new Scanner(System.in);//读取控制器输入

    //构建方法，使得自调用对象
    public remodelGuessNumber(int rangeStart, int rangeEnd, int guesscount) {
        this.rangeStart = rangeStart;
        this.rangeEnd = rangeEnd;
        this.guesscount = guesscount;
    }


    //创建描述方法，使得游戏自我描述；
    public void describe() {
        System.out.println("\t\t===========欢迎来到猜数字游戏升级版！============\n请输入" + rangeStart + "到" + rangeEnd + "范围内的整数" +
                "（不包括这两个数字），" + "您共有" + guesscount + "次机会。输入数字0退出游戏！");
    }

    //创建方法，使得输出随机整数
    public int getcorrectNumber() {
        int mod = rangeEnd - rangeStart;//取模
        double random = Math.random();
        int correctNum = rangeStart + (int) (random * rangeEnd * 1000) % mod;//选取随机范围内整数；

        //防止目标数越界
        if (correctNum <= rangeStart) {
            correctNum = rangeStart + 1;
        }
        if (correctNum >= rangeEnd) {
            correctNum = rangeEnd - 1;
        }
        return correctNum;//返回值
    }

    //创建猜数结果判断方法；
    public void judgeGuess(int correctNumber) {
        //给循环外所需变量赋值，使得程序开始
        boolean gameStop = false;
        int totalGameCount = 0;
        int totalCorrectCount = 0;
        while (!gameStop) {
            correctNumber = getcorrectNumber();//获取本轮游戏的正确数字
            describe();//描述一下游戏规则
           //给循环内所需变量赋值
            int guessLeft = guesscount;
            boolean gameStart = true;
            boolean guessCorrect = false;

            //当猜测次数还剩余时，让玩家继续猜
            while (guessLeft > 0) {

                System.out.println("您还有" + guessLeft + "机会，请输入猜测的数字");
                int guessNum = in.nextInt();
                // 输入0，结束游戏
                if (guessNum == 0) {
                    gameStop = true;
                    guessCorrect = true;
                    break;
                }
                //判断输入是否在范围内
                if (guessNum <= rangeStart || guessNum >= rangeEnd) {
                    System.out.println("请输入范围内数字！");
                    continue;
                }
                //只要输入了合法范围数字，就使得猜测次数加一
                if (gameStart) {
                    totalGameCount++;
                    gameStart = false;
                }
                //猜对时输出
                if (guessNum == correctNumber) {
                    guessCorrect = true;
                    totalCorrectCount++;
                    System.out.println("恭喜你，太厉害了！猜测正确！" + "本次的数字为" + correctNumber + "\t\t" + "共猜测了" + totalGameCount + "次,猜对" + totalCorrectCount + "次");
                    break;
                } else if (guessNum > correctNumber) {
                    System.out.println("您猜测的数字大了");
                    guessLeft--;
                } else {
                    System.out.println("您猜测的数字小了");
                    guessLeft--;
                }
            }
            if (!guessCorrect) {
                System.out.println("很遗憾，本次没有猜对！正确的数字为：" + correctNumber + "\t\t" + "共猜测了" + totalGameCount + "次,猜对" + totalCorrectCount + "次");
            } else if (gameStop == true) {
                System.out.println("程序已退出！");
            }
        }
    }
}






