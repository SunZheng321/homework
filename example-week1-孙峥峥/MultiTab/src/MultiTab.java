//第一周例程练习-例程1乘法口诀表-孙峥峥
public class MultiTab {
    public static void main(String[] args) {
        //利用两层for语句嵌套，第一层做乘数，第二层做被乘数
        for (int i = 1; i <= 9; i++) {
            String line = new String();//String line字符串用来保存结果；
            for (int j = 1; j <= 9; j++) {
                if (j > i) {
                    break;
                }//删去重复结果
                int result = i * j;
                line += i + "*" + j + "=" + result + "\t";
            }
            System.out.println(line);
        }
    }
}
