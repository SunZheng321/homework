package sunzhengzheng;
/*week2-例程ai-孙峥峥
程序要点:通过String语句，可以识别一些字符串并做出适当回答；
常见用法：.startWith():以什么字符开头
        .endWith():以什么字符结尾
        .trim忽略空格；
        .toUpperCase()装换成大写；
        .toLowerCase()转换成小写；
        .substring(i)截取某个值后面的值，如果是范围，则不包括结尾
 */

import java.util.Scanner;

public class runAiApp {

    public static void main(String[] args) {
        Ai ai = new Ai();
        System.out.println("这里是不智能ai，请您提问：");
        Scanner in = new Scanner(System.in);
        while (true) {
            String input = in.next();
            if ("exit".equals(input)) {
                System.out.println("程序退出!再见！");
                break;
            }
            String answer = ai.answer(input);
            System.out.println(answer);
        }
    }
}
