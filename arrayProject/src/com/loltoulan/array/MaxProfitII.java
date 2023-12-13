package com.loltoulan.array;

public class MaxProfitII {

    public static void main(String[] args) {
        int[] nums = {7, 1, 5, 3, 6, 4};
//        int[] nums = {7,6,4,3,1};
        int maxProfit = new MaxProfitII().maxProfitA(nums);
        System.out.println("maxProfit = " + maxProfit);
    }












    //  int[] nums = {7, 1, 5, 3, 6, 4};
    public int maxProfitA(int[] arr) {
        if (arr == null || arr.length <= 1) return 0;
        int ans = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i-1]) {  // 卖出有利可图
                ans += (arr[i] - arr[i-1]);
            }
        }
        return ans;
    }

    private int res;

    public int maxProfitB(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        this.res = 0;
        dfs(prices, 0, len, 0, res);
        return this.res;
    }

    /**
     * @param prices 股价数组
     * @param index  当前是第几天，从 0 开始
     * @param status 0 表示不持有股票，1表示持有股票，
     * @param profit 当前收益
     */
    private void dfs(int[] prices, int index, int len, int status, int profit) {

        if (index == len) {
            this.res = Math.max(this.res, profit);
            return;
        }

        dfs(prices, index + 1, len, status, profit);

        if (status == 0) {
            // 可以尝试转向 1
            dfs(prices, index + 1, len, 1, profit - prices[index]);

        } else {
            // 此时 status == 1，可以尝试转向 0
            dfs(prices, index + 1, len, 0, profit + prices[index]);
        }
    }

}
