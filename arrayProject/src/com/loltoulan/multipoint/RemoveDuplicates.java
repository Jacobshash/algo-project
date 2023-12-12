package com.loltoulan.multipoint;

import java.util.Arrays;

public class RemoveDuplicates {

    public static void main(String[] args) {
        int[] nums = {1, 1,1, 2,2,3,3,3};
        int i = removeDuplicatesB(nums);
        System.out.println(i);
        System.out.println("=============");
        Arrays.stream(nums)
                .limit(i)
                .forEach(System.out::println);
    }

    public static int removeDuplicatesA(int[] nums) {
        int k = 2; // 每个元素最多出现的次数
        if (nums.length <= k) return nums.length; // 如果数组长度小于等于 k，直接返回数组长度

        // 初始化慢指针和快指针
        int slow = k;
        int fast = k;
        while (fast < nums.length) {
            // 如果 nums[fast] 不等于 nums[slow - k]
            // 则将 nums[fast] 复制到 nums[slow]，并将 slow 向前移动一位
            if (nums[fast] != nums[slow - k]) { //nums[slow - k] 是当前考虑的元素在新数组中的第一个可能的位置
                nums[slow] = nums[fast];
                slow++;
            }
            // 将 fast 向前移动一位，以检查下一个元素
            fast++;
        }
        // 返回新数组的长度
        return slow;
    }


    public static int removeDuplicatesB(int[] nums) {
        if (nums.length < 3) return nums.length;
        // 初始化慢指针和快指针，默认我们可以保留两个重复的元素
        int i = 2, j = 2;
        // 当快指针小于数组长度时，执行循环体
        while (j < nums.length) {
            // 如果 nums[j] 不等于 nums[i - 2]，此时我们将快指针的值复制到慢指针的位置，并将慢指针向前移动一位
            // eg : [1,1,1,2,2,3]  i = 2, j = 3 此时 nums[j] = 2, nums[i - 2] = 1 此时两位数不相等，我们将 nums[j] 复制到 nums[i] 的位置
            // 于是数组就变成了 [1,1,2,2,2,3] 此时 i = 3, j = 4 等到下一次执行完循环体之后，数组将变成 [1,1,2,2,3,3]，
            // 此时 i = 4, j = 5 此时我们将慢指针的值return出去即可
            if (nums[j] != nums[i - 2]) {
                nums[i++] = nums[j];
            }
            // 将快指针向前移动一位，以检查下一个元素
            j++;
        }
        // 返回慢指针的值
        return i;
    }

    public int removeDuplicatesC(int[] nums) {
        return process(nums, 2);
    }
    int process(int[] nums, int k) {
        int u = 0;
        for (int x : nums) {
            // 如果 u < k 或者 x != nums[u - k]，此时我们将 x 复制到 nums[u] 的位置，并将 u 向前移动一位
            if (u < k || nums[u - k] != x){
                nums[u++] = x;
            }
        }
        return u;
    }

}
