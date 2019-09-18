package shiyue.jery.gateway.predicatetest;

import java.util.function.Predicate;

/**
 * @author Jery
 * @date 2019/7/10
 */
public class PredicateTest {

    public static void main(String[] args) {
        Predicate<String> predicateStr = str -> {
            return str.equals("String");
        };
        //使用test()方法执行断言,输出true,false
        System.out.println(predicateStr.test("String"));
        System.out.println(predicateStr.test("string"));
        //Predicate integer
        Predicate<Integer> predicateInt = i -> {
            return i > 0;
        };
        //输出true,false
        System.out.println(predicateInt.test(5));
        System.out.println(predicateInt.test(-1));

        char c = '和';
        String str = "和";
        char[] chars = str.toCharArray();
        System.out.println(chars.length);
        System.out.println(str.getBytes().length);
        System.out.println(c);

        System.out.println(1 % 5);
    }


}
