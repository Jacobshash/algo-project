package com.loltoulan.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductExceptSelf {


    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        Arrays.stream(productExceptSelf(nums)).boxed().toList().forEach(System.out::println);
    }

    public static int[] productExceptSelfA(int[] nums) {
        List<Integer> collect = new ArrayList<>(Arrays.stream(nums).boxed().toList());
        int[] self = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            Integer integer = collect.get(i);
            collect.set(i, 1);
            int reduce = collect.stream().mapToInt(x -> x).reduce(1, Math::multiplyExact);
            self[i] = reduce;
            collect.set(i, integer);
        }
        return self;
    }

    // 什么是前缀和
    // 答：前缀和就是从左到右，依次将前面的数相乘
    // 什么是后缀和
    // 答：后缀和就是从右到左，依次将后面的数相乘
    // nums[] = [1,2,3,4] 执行前缀和的步骤

    public static int[] productExceptSelfB(int[] nums) {
        int len = nums.length;
        if (len == 0) return new int[0];
        int[] ans = new int[len];
        ans[0] = 1;
        int tmp = 1;
        // ans[] = [1,0,0,0] nums[] = [1,2,3,4]
        for (int i = 1; i < len; i++) {
            // 第一次 ans[1] = ans[0] *nums[0] = 1 * 1 = 1
            // 第二次 ans[2] = ans[1] *nums[1] = 1 * 2 = 2
            // 第三次 ans[3] = ans[2] *nums[2] = 2 * 3 = 6
            ans[i] = ans[i - 1] * nums[i - 1];
        }
        // 此时 nums[] = [1,2,3,4] ans[] = [1,1,2,6]
        //  此时 int i = 2
        for (int i = len - 2; i >= 0; i--) {
            // 第一次 tmp = 1 * nums[3] = 1 * 4 = 4 ans[2] = ans[2] * tmp = 2 * 4 = 8
            // 第二次 tmp = 4 * nums[2] = 4 * 3 = 12 ans[1] = ans[1] * tmp = 1 * 12 = 12
            // 第三次 tmp = 12 * nums[1] = 12 * 2 = 24 ans[0] = ans[0] * tmp = 1 * 24 = 24
            tmp *= nums[i + 1];
            ans[i] *= tmp;
        }
        // 此时 nums[] = [1,2,3,4] ans[] = [24,12,8,6]
        return ans;
    }

    //维护两个变量，beforeSum表示前缀和，afterSum表示后缀和
    public static int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] ans=new int[n];
        Arrays.fill(ans,1);
        int beforeSum=1;
        int afterSum=1;
        for(int i=0,j=n-1;i<n;i++,j--){
            ans[i] = ans[i] * beforeSum;
            ans[j] = ans[j] * afterSum;
            beforeSum = beforeSum * nums[i];
            afterSum = afterSum * nums[j];
        }
        return ans;
    }
    /*
       // 1, 2, 3, 4




     */

}
