package com.loltoulan.array;

@SuppressWarnings("unused")
public class MaxProfitI {

    public static void main(String[] args) {
        int[] nums = {7, 1, 5, 3, 6, 4};
//        int[] nums = {7,6,4,3,1};
        int maxProfit = maxProfit(nums);
        System.out.println("maxProfit = " + maxProfit);
    }


    // 超时
    public static int maxProfitA(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            int currPrice = prices[i];
            int temp;
            for (int j = i, pricesLength = prices.length; j < pricesLength; j++) {
                int price = prices[j];
                if (price > currPrice) {
                    temp = price - currPrice;
                    if (temp > max) {
                        max = temp;
                    }
                }
            }
        }
        return max;
    }

    public static int maxProfitB(int[] prices) {
        int minPrice = prices[0];
        int maxProfit = 0;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }
        return maxProfit;
    }

    public static int maxProfit(int[] prices) {
        int cost = Integer.MAX_VALUE;
        int profit = 0;
        for (int price : prices) {
            cost = Math.min(cost, price);
            profit = Math.max(profit, price - cost);
        }
        return profit;
    }


}
