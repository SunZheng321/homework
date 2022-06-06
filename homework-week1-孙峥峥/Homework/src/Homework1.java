//homework-week1-孙峥峥：使用冒泡排序法对用户输入的字符串进行排序（按照ASCII码从大到小）；

import java.util.Arrays;
import java.util.Scanner;

public class Homework1 {
    public static void main(String[] args) {
        System.out.println("请输入：");

        //读取控制台的输入
        Scanner in = new Scanner(System.in);
        String strIn = in.nextLine();

        //将输入的字符串依次保存在数组中
        char[] input = new char[strIn.length()];//创建一个数组，这个数组的长度和输入的字符串长度一致
        int[] asciiOut = new int[strIn.length()];//创建一个int数组来保存字符串的ASCII码
        char[] output;
        for (int i = 0; i < strIn.length(); i++) {
            input[i] = strIn.charAt(i);
        }

        //利用冒泡排序法对字符串进行排序
        for (int i = 0; i < strIn.length(); i++) {
            for (int j = 0; j < strIn.length() - i - 1; j++) {
                if (input[j] < input[j + 1]) {
                    char Temp = input[j];//利用Temp变量来交换数组中变量
                    input[j] = input[j + 1];
                    input[j + 1] = Temp;
                }

            }
        }

        //输出结果
        String strOut = new String(input);//将排序后数组转换为字符串
        output = input;//排序后数组赋值给定义的结果数组（可省略）
        for (int i = 0; i < strIn.length(); i++) {
            asciiOut[i] = output[i];//将数组中每个字符转换成ASCII码
        }
        System.out.println("有序字符串：" + strOut);
        System.out.println("ASCII码：" + (Arrays.toString(asciiOut)));

    }
}
