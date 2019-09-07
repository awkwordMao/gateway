package shiyue.jery.gateway.classloader;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jery
 * @date 2019/8/30
 */
public class MyClassLoader extends ClassLoader {
    public Class<?> defineMyClass(byte[] b, int off, int len) {
        return null;
    }

    public static void main(String[] args) {
        Object object = new Object();
        String str = "sdf";
        int[] nums = {1, 2, 3};
        nums.clone();

    }
}
