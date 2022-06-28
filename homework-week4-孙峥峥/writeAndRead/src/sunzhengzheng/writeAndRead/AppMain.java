package sunzhengzheng.writeAndRead;

import java.io.File;
import java.io.IOException;

import static sunzhengzheng.writeAndRead.WriteAndRead.*;

/*homework-week4-设计一个读写类-孙峥峥
程序要点包括：
1、通过调用File类中的方法，实现创建、删除、重命名文件等操作。（File类的对象主要用来获取文件本身的信息，如目录，长度，读写权限等）；
2、利用输入输出流中的InputStream和OutStream类来实现写入和读出文件内容。
3、利用BufferedReader和BufferedWriter类中的缓存机制，能够每次读取或输出一行。
tips：程序从外部设备读取数据，就是输入，就是input，read
     程序写数据到外部设备，就是输出，就是output，writer
 */
public class AppMain {
    public static void main(String[] args) throws IOException {
        // 使用File类，依次创建多层文件夹，在指定文件夹创建文件，用户写入文本内容，读出已存在的文本内容
        System.out.println("===欢迎使用文档记录小程序！====");
        File dir = createDirs();
        File file = new File(createFiles(dir));
        writeToFile(file);
        READWAY(file);
        System.out.println("本次记录已结束！欢迎下次使用！");
    }
}
