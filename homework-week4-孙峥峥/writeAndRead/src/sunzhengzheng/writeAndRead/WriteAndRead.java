package sunzhengzheng.writeAndRead;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class WriteAndRead {

    //设置文件创建的目录，“."代表当前目录，”~“为根目录，File.separator为分隔符。（放在桌面会报错，需要设置权限？）
    //private static final String ROOT = "C:" + File.separator+"Users"+File.separator+"sunzhengzheng"+File.separator+"Desktop";

    protected static final String ROOT = "." + File.separator;
    protected static Scanner scanner = new Scanner(System.in);

    //创建文件夹1：输入文件夹路径
    protected static File createDirs() {
        List<String> pathList = new ArrayList<>();
        while (true) {
            System.out.println("首先请输入文件路径，如果为空则结束");
            String path = scanner.nextLine();
            //判断是否为空；
            if (path.isBlank()) {
                break;
            }
            pathList.add(path);//利用List集合中的add接口方法，实现路径添加
        }
        return createDir(pathList.toArray(new String[0]));//路径创建成功后，利用creatdir方法创建文件夹
    }

    //创建文件夹2；在设定的路径下创建文件夹
    protected static File createDir(String... restPaths) {
        String rest = joinRestDir(restPaths);
        System.out.println("将在" + ROOT + "下创建" + rest+"文件夹！");
        File dir = new File(ROOT, rest);
        if (dir.exists() && dir.isDirectory()) {
            System.out.println("文件夹已经存在！" + dir.toString());
            return dir;
        } else {
            boolean createSuccess = dir.mkdirs();//mkdirs是创建多级目录；
            if (createSuccess) {
                return dir;
            } else {
                throw new IllegalArgumentException("无法在" + ROOT + "下创建" + rest);
            }
        }
    }

    //创建文件
    protected static String createFiles(File dir) throws IOException {
        System.out.println("接下来请输入文件名的前缀：");
        String fileName = scanner.next().trim();
        File f = new File(dir, fileName + ".txt");
        System.out.println("创建文件" + f.getName() + "：" + f.createNewFile());
        return fileName;
    }

    //重命名文件夹的方法；
    protected static File renameDir(File dir) {
        System.out.println("请输入新的文件夹的名字：");
        String newDirName = scanner.nextLine().trim();
        File newDir = new File(dir.getParentFile(), newDirName);
        //利用renameTo()方法重命名；
        boolean renameSuccess = dir.renameTo(newDir);

        if (renameSuccess) {
            System.out.println("改名为" + newDirName + "成功");
        } else {
            System.out.println("改名为" + newDirName + "失败");
            return null;
        }
        return newDir;
    }

    //重命名文件的方法
    protected static String renameFiles(File newDir, String fileName) {
        System.out.println("请输入新的文件名的前缀：");
        String fileNameNew = scanner.next().trim();
        File f = new File(newDir, fileName + ".txt");
        File fn = new File(newDir, fileNameNew + ".txt");
        System.out.println("重命名文件" + f.getName() + "：" + f.renameTo(fn));
        return fileNameNew;
    }

    //删除文件夹方法
    protected static void deleteDir(File newDir) {
        System.out.println("删除文件夹？");
        boolean deleteDir = scanner.nextBoolean();
        //如果选择删除，则利用File类中delete方法删除文件夹
        if (deleteDir) {
            System.out.println("删除文件夹：" + newDir.delete());
        }
    }

    //删除文件的方法，和文件夹方法类似
    protected static void deleteFiles(File newDir, String fileNameNew) {
        System.out.println("删除文件？");
        boolean deleteFiles = scanner.nextBoolean();
        if (deleteFiles) {
            System.out.println("删除文件" + newDir.delete());
        }
    }

    protected static String joinRestDir(String... restPaths) {
        return Arrays.stream(restPaths).map(String::trim).collect(Collectors.joining(File.separator));

    }

    //写入文本内容
    protected static void writeToFile(File targetFile) throws IOException {
        try (
                // 建一个outputstream，建立一个从文件到程序的byte数据传输流
                FileOutputStream fos = new FileOutputStream(targetFile);
                //建立一个可以消费outputstream的writer，并指定字符集，这样就可以一个个的写入字符了
                OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
                //使用PrintWriter，可以方便的写入一行字符
                PrintWriter pw = new PrintWriter(osw);
        ) {
            System.out.println("请输入想记录的内容，输入的内容会实时写入文件，如果输入空行则结束");
            while (true) {
                Scanner scanner = new Scanner(System.in);
                String lineToWrite = scanner.nextLine().trim();
                System.out.println("输入内容为:" + lineToWrite);
                if (lineToWrite.trim().isBlank()) {
                    System.out.println("好的，输入结束!输入内容已保存！");
                    break;
                } else {
                    pw.println(lineToWrite);
                    pw.flush();
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //创建输入方法，在文件中写入内容；
    protected static void READWAY(File sourceFile) {
        System.out.println("文本中的内容如下：");
        try (
                FileInputStream fis = new FileInputStream(sourceFile);
                InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
                BufferedReader reader = new BufferedReader(isr);
        ) {
            reader.lines().map(String::trim).map(String::toUpperCase).forEach(System.out::println);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
