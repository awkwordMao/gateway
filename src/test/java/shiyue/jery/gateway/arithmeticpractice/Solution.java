package shiyue.jery.gateway.arithmeticpractice;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.springframework.util.CollectionUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.SynchronousQueue;
import java.util.stream.Collectors;

/**
 * @author Jery
 * @date 2019/7/15
 */
public class Solution {

    public static void main(String[] args) {
//        int[] nums = {3,2,4};
//        twoSum(nums,  6);
//        plusOne(new int[]{9});

//        int i = 1;
//        Foo foo = new Foo();
//        foo.setId("111");
//        test(foo);
//        System.out.println(foo.toString());
//        System.out.println(Math.min(1, 2));
//        int[] nums = {1, 3, 1, -1, 3};
//        singleNumber1(nums);
//        singleNumber(nums);
//        String str1 = "hello";
//        String str2 = "ll";
//        strStr(str1, str2);
        /*int[] ints = {1, 0,0,0, 3, 0, 5};
        testYi(ints);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
        System.out.println();*/
        /*String str1 = "anghouyb";
        String str2 = "nahguoby";
        System.out.println(testEr(str1, str2));*/
        String string = "swedddddflsfh";
//        testSi(string);
        lengthOfLongestSubstring(string);
//        testSan(string);

    }

    public static int singleNumber1(int[] nums) {
        int ans = nums[0];
        if (nums.length > 1) {
            for (int i = 1; i < nums.length; i++) {
                ans = ans ^ nums[i];
            }
        }
        return ans;
    }

    public static int singleNumber(int[] nums) {
        int temp = 0;
        List list = new ArrayList();
        for (int i = 0; i < nums.length; i++) {
            boolean flag = false;
            for (int j = i + 1; j < nums.length; j++) {

                if (nums[i] == nums[j]) {
                    flag = true;
                    list.add(i);
                    list.add(j);
                    break;
                }
            }

            if (!flag && !list.contains(i)) {
                temp = i;
                return nums[temp];
            }

        }
        return 1;
    }

    public static void test(Foo foo) {
        foo.setId("lkjlkjlk");
    }

    public static int[] plusOne(int[] digits) {
        digits[digits.length - 1] += 1;
        for (int i = 1; i <= digits.length; i++) {
            if (digits[digits.length - i] > 9) {
                digits[digits.length - i] -= 10;
                if (digits.length - i - 1 < 0) {
                    digits = new int[digits.length + 1];
                    digits = digits.clone();

                }
                digits[digits.length - i - 1] += 1;
            }
        }
        for (int i = 0; i < digits.length; i++) {
            System.out.println(digits[i]);
        }
        return digits;
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Arrays.asList(nums);
        nums.clone();
        /*for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j <= nums.length - 1; j++) {
                if(nums[i] + nums[j] == target){
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        for (int i : result) {
            System.out.println(i);
        }
        return result;*/
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");

    }

    @Test
    public void testOne() {
        int a = 1;
        int b = 2;
        int c = 3;
        System.out.println(a = a ^ b);
        System.out.println(b = a ^ b);
        System.out.println(a = a ^ b);
        testTwo(a, b);
        System.out.println("a=" + a + ",b=" + b);
    }

    public static void testTwo(int a, int b) {
        a = a ^ b;
        b = b ^ a;
        a = a ^ b;
    }

    @Test
    public void fun() {
        int a[] = {22, 38, 38, 22, 22, 4, 4, 11, 11};
        int temp = 0;
        for (int i = 0; i < a.length; i++) {
            temp ^= a[i];
        }
        System.out.println(temp);
    }

    public static int strStr(String haystack, String needle) {
        if (StringUtils.isBlank(needle)) {
            return 0;
//            haystack.indexOf()
        }
        if (!haystack.contains(needle)) {
            return -1;
        }
        for (int i = 0; i < haystack.length(); i++) {
            String temp = haystack.substring(i, i + needle.length());
            if (temp.equals(needle)) {
                return i;
            }
        }
        return -1;

    }

    @Test
    public void testThree() throws ParseException {
        java.text.SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        Date date = new Date();
        String str = sdf.format(date);
        System.out.println(str);
        String str1 = "2013-12-12";
        Date date1 = sdf.parse(str);
        System.out.println(date1);
        int i;
        i = 1 % 3;
        System.out.println(i);
    }

    public static void testYi(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] == 0 && nums[j + 1] != 0) {
                    nums[j] = nums[j] ^ nums[j + 1];
                    nums[j + 1] = nums[j] ^ nums[j + 1];
                    nums[j] = nums[j] ^ nums[j + 1];
                }
            }
        }
    }

    public static boolean testEr(String str1, String str2) {

        StringBuilder str1ji = new StringBuilder();
        StringBuilder str1ou = new StringBuilder();
        StringBuilder str2ji = new StringBuilder();
        StringBuilder str2ou = new StringBuilder();
        if (str1.length() % 2 != 0 || str2.length() % 2 != 0) {
            return false;
        }
        for (int i = 0; i < str1.length(); i++) {
            if (i % 2 != 0) {
                str1ji.append(str1.charAt(i));
            } else {
                str1ou.append(str1.charAt(i));
            }
        }
        //获取str2中的奇数
        for (int i = 0; i < str2.length(); i++) {
            if (i % 2 != 0) {
                str2ji.append(str2.charAt(i));
            } else {
                str2ou.append(str2.charAt(i));
            }
        }
        String ji1 = str1ji.toString();
        String ou1 = str1ou.toString();
        String ji2 = str2ji.toString();
        String ou2 = str2ou.toString();
        return ji1.equals(ou2) && ou1.equals(ji2);
    }

    public static void testSan(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str.charAt(0));
        int temp = 0;
        StringBuilder result = new StringBuilder();
        for (int i = 1; i < str.length(); i++) {
            if (sb.charAt(sb.length() - 1) != str.charAt(i)) {
                sb.append(str.charAt(i));
                if (temp < sb.length()) {
                    temp = sb.length();
                    result.append(sb);
                }
            } else if (sb.charAt(sb.length() - 1) == str.charAt(i)) {
                if (temp < sb.length()) {
                    temp = sb.length();
                    result.append(sb);
                    sb.delete(0, sb.length() - 1);
                }
            }
        }
        System.out.println(result.toString());
        System.out.println("长度为：" + temp);
    }

    public static void testSi(String str) {
        List<Set> list = new ArrayList<>();
        Map<Integer, Character> map = new LinkedHashMap<>();
        int temp = 0;
        for (int i = 0; i < str.length(); i++) {
            if (i == 0) {
                map.put(i, str.charAt(i));
                continue;
            }
            if (!map.get(i - 1).equals(str.charAt(i))) {
                map.put(i, str.charAt(i));
                if (i == str.length() - 1 && temp < map.size()) {
                    list.clear();
                    list.add(map.keySet());
                    temp = map.size();
                }
            } else if (temp < map.size()) {
                list.add(map.keySet());
                temp = map.size();
                map = new LinkedHashMap<>();
                map.put(i, str.charAt(i));
            }
        }
        list.forEach(System.out::print);
        System.out.println(" 大小为：" + temp);
    }

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0, start = 0; end < n; end++) {
            char alpha = s.charAt(end);
            if (map.containsKey(alpha)) {
                start = Math.max(map.get(alpha), start);
            }
            ans = Math.max(ans, end - start + 1);
            map.put(s.charAt(end), end + 1);
        }
        return ans;
    }

    public boolean method0() {
        int[][] array = {{1, 2, 3}, {2, 3, 4}, {3, 4, 5}};
        int target = 3;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    @Test
    public void method2() {
        Random random = new Random();
        List<Integer> integers = new ArrayList<Integer>();
        for (int i = 0; i < 100; i++) {
            int ir = random.nextInt(100);
            integers.add(ir);
        }
        integers.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

    }



}
