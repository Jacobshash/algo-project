package com.loltoulan.array;

public class JumpGameI {

    public static void main(String[] args) {
//        int[] nums = {2,3,1,1,4};
//        int[] nums = {7,6,4,3,1};
//        int[] nums = {3,2,1,0,4};
        int[] nums = {2,0,0};//{2,0,0};
        boolean canJump = canJump(nums);
        System.out.println("canJump = " + canJump);
    }

    /*
        输入：nums = [2,3,1,1,4] [2,5,0,0]
        输出：true
        解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
     */
    public boolean canJumpA(int[] nums) {
        if(nums.length == 1) {
            return true;
        }
        for(int i=0;i<nums.length;i++) {
            if(nums[i] == 0 && !check(nums, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean check(int[] nums, int end) {
        for(int j=end-1;j>=0;j--) {
            if(nums[j] > (end - j) || (j+nums[j]) >= nums.length-1) {
                return true;
            }
        }
        return false;
    }


   static boolean canJump(int[] nums) {
        int step = 0;
        for (int index = 0; index < nums.length; index++) {
            if (index > step) return false;
            step = Math.max(step, index + nums[index]);
        }
        return true;
    }


}
