package shiyue.jery.gateway.threadtest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

/**
 * @author Jery
 * @date 2019/8/6
 */
class DeamonThread implements Runnable {

    @Override
    public void run() {
        System.out.println("守护线程启动：" + Thread.currentThread().getName());

        File fileName = new File("E:" + File.separator + "deamon.txt");
        System.out.println("file.separator: " + File.separator);
        System.out.println("file.pathSeparator: " + File.pathSeparator);
        System.out.println("file.pathSeparatorChar: " + File.pathSeparatorChar);
        System.out.println("file.separatorChar: " + File.separatorChar);
        try {
            writeToFile(fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("守护线程停止：" + Thread.currentThread().getName());
    }

    public void writeToFile(File fileName) throws Exception {
        //true代表每次写入为添加，而不是覆盖
        OutputStream os = new FileOutputStream(fileName, true);
        int count = 0;
        while (count < 999) {
            os.write(("\r\nword" + count).getBytes());
            System.out.println("守护线程" + Thread.currentThread().getName() + "向文件中写入了word" + count++);
            Thread.sleep(1000);
        }
        os.close();
    }
}

public class DeamonThreadTest {

    public static void main(String[] args) {
        System.out.println("用户线程开启：" + Thread.currentThread().getName());

        DeamonThread deamonThread = new DeamonThread();
        Thread thread1 = new Thread(deamonThread);
        thread1.setDaemon(true);
        thread1.start();
        Scanner scanner = new Scanner(System.in);
        scanner.next();

        System.out.println("用户线程关闭：" + Thread.currentThread().getName());
    }
}
