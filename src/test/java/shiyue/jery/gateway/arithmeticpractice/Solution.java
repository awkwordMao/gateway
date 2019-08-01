package shiyue.jery.gateway.arithmeticpractice;

import org.junit.Test;

import java.util.*;

/**
 * @author Jery
 * @date 2019/7/15
 */
public class Solution {

    public static void main(String[] args) {
//        int[] nums = {3,2,4};
//        twoSum(nums,  6);
        plusOne(new int[]{9});

        int i = 1;
        Foo foo = new Foo();
//        foo.setId("111");
//        test(foo);
//        System.out.println(foo.toString());
//        System.out.println(Math.min(1, 2));
        int[] nums = {1, 3, 1, -1, 3};
        singleNumber1(nums);
//        singleNumber(nums);
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

    public int strStr(String haystack, String needle) {
        if (!haystack.contains(needle)) {
            return -1;
        }

    }

}
