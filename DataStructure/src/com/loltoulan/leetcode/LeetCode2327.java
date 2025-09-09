package com.loltoulan.leetcode;

public class LeetCode2327 {

    /**
     * 计算第n天知道秘密的人数
     *
     * 使用动态规划方法解决秘密传播问题。每个人在知道秘密后的第delay天开始可以分享秘密，
     * 在知道秘密后的第forget天会忘记秘密。
     *
     * 算法思路：
     * 1. 使用dp数组记录每天新增知道秘密的人数
     * 2. 对于每一天，计算能够分享秘密的人所带来的新知道秘密的人数
     * 3. 最后统计在第n天仍然记得秘密的人数总和
     *
     * @param n 第n天，需要计算这一天还记得秘密的人数
     * @param delay 延迟天数，人员在知道秘密后的delay天之后才能开始分享秘密
     *              例如delay=2表示在知道秘密的第2天及以后才能分享
     * @param forget 遗忘天数，人员在知道秘密后的forget天之后会忘记秘密
     *               例如forget=4表示在知道秘密的第4天之后就会忘记
     * @return 第n天还记得秘密的人数，结果对10^9+7取模
     */
    public static int peopleAwareOfSecret(int n, int delay, int forget) {
        // 取模常量，防止整数溢出
        long mod = 10_0000_0007;

        // dp[i]表示第i天新增知道秘密的人数
        long[] dp = new long[n + 1];

        // 初始状态：第一天有一个人知道秘密
        dp[1] = 1;

        // 动态规划计算每天新增知道秘密的人数
        for (int i = 2; i <= n; i++) {
            // 计算第i天新增的人数：
            // 从(i-forget+1)天到(i-delay)天这段时间内新增的人数之和
            // 因为只有这段时间内新增的人才能在第i天分享秘密
            // 下界是1（第一天），上界是i-delay（最多延迟delay天后才能分享）
            for (int j = Math.max(1, i - forget + 1); j <= i - delay; j++) {
                if (j >= 1) {
                    dp[i] = (dp[i] + dp[j]) % mod;
                }
            }
        }

        // 计算第n天还记得秘密的人数总和
        // 这些人是那些在第(n-forget+1)天到第n天之间知道秘密的人
        // 因为在更早之前知道秘密的人都已经忘记了
        long result = 0;
        for (int i = Math.max(1, n - forget + 1); i <= n; i++) {
            result = (result + dp[i]) % mod;
        }

        return (int) result;
    }

    public static void main(String[] args) {
        System.out.println(peopleAwareOfSecret(6, 2, 4));
    }
}
