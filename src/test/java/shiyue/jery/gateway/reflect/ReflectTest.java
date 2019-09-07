package shiyue.jery.gateway.reflect;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Field;

/**
 * @author Jery
 * @date 2019/9/3
 */
public class ReflectTest {
    @Autowired
    private Cache cache;

    public static void main(String[] args) {
        //获取Class对象的三种方式
        Class clazz = Person.class;
        Person person = new Person();
        Class clazz2 = person.getClass();
        try {
            Class clazz1 = Class.forName("shiyue.jery.gateway.reflect.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Field[] field = clazz.getDeclaredFields();
        for (Field var : field) {
            System.out.println(var.getName());
        }

    }

}
