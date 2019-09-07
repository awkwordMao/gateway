package shiyue.jery.gateway.nio;

import org.junit.Test;
import sun.nio.cs.UnicodeEncoder;

import java.io.*;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.Selector;

import static jdk.nashorn.internal.objects.Global.println;

/**
 * @author Jery
 * @date 2019/8/8
 */
public class NIOTest {

    @Test
    public void method1() {
        RandomAccessFile accessFile = null;

        try {
//            URLEncoder.encode()
            accessFile = new RandomAccessFile("e:" + File.separator + "deamon.txt", "rw");
            FileChannel fileChannel = accessFile.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            int bytesRead = fileChannel.read(buffer);
            System.out.println(bytesRead);
            while (bytesRead != -1) {
                buffer.flip();
                while (buffer.hasRemaining()) {
                    System.out.println((char) buffer.get());
                }
                buffer.compact();
                bytesRead = fileChannel.read(buffer);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (accessFile != null)
                try {
                    accessFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    @Test
    public void method2() {
        //NIO的复制文件
        try {
            FileInputStream is = new FileInputStream("d:" + File.separator + "word" + File.separator + "JMeter使用.docx");
            FileOutputStream os = new FileOutputStream("d:" + File.separator + "word" + File.separator + "copy.docx");
            FileChannel inChannel = is.getChannel();
            FileChannel outChannel = os.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            while (true) {
                buffer.clear();
                int read = inChannel.read(buffer);
                if (read < 0) {
                    break;
                }
                buffer.flip();
                outChannel.write(buffer);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println(0xD800);
        try {
            Selector.open();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
