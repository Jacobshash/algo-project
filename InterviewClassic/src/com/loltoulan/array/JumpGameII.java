package com.loltoulan.array;

public class JumpGameII {

    public static void main(String[] args) {
        //        int[] nums = {2,3,1,1,4};
        int[] nums = {7,6,4,3,1};
//        int[] nums = {3,2,1,0,4};
        int canJump = jump(nums);
        System.out.println("canJump = " + canJump);
    }


    static int jump(int[] nums) {
        int ans = 0;
        int start = 0;
        int end = 1;
        while (end < nums.length)
        {
            int maxPos = 0;
            for (int i = start; i < end; i++)
            {
                // 能跳到最远的距离
                maxPos = Math.max(maxPos, i + nums[i]);
            }
            start = end;      // 下一次起跳点范围开始的格子
            end = maxPos + 1; // 下一次起跳点范围结束的格子
            ans++;            // 跳跃次数
        }
        return ans;
    }

}
