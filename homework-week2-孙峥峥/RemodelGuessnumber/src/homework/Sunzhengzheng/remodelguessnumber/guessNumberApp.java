package homework.Sunzhengzheng.remodelguessnumber;
/*week2-homework-孙峥峥
猜数字游戏升级版，利用类的方法改造游戏，将游戏的功能封装到类中。
主要包括：
1、构建一个类（猜数字游戏）
2、用构造方法使得对象创建时被自动调用。
3、使用方法，让游戏自己描述自己；
4、结合方法，参数和返回值，使得游戏自己判断游戏结果并返回结果；

*/
public class guessNumberApp {
    public static void main(String[] args) {
        //引用已创建的猜数字游戏类；
        remodelGuessNumber m = new remodelGuessNumber(1, 15, 5);
        int correctNumber= m.getcorrectNumber();
        m.judgeGuess(correctNumber);
    }

}

