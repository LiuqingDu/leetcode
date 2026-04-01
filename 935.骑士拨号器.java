/*
 * @lc app=leetcode.cn id=935 lang=java
 *
 * [935] 骑士拨号器
 */

// @lc code=start
class Solution {
    // 模数
    private static final int MOD = 1_000_000_007;
    
    public int knightDialer(int n) {
        
        // 每个数字可以跳到哪些数字
        int[][] moves = {
            {4, 6},    // 0 可以跳到 4,6
            {6, 8},    // 1 可以跳到 6,8
            {7, 9},    // 2 可以跳到 7,9
            {4, 8},    // 3 可以跳到 4,8
            {0, 3, 9}, // 4 可以跳到 0,3,9
            {},        // 5 不能跳（被禁用）
            {0, 1, 7}, // 6 可以跳到 0,1,7
            {2, 6},    // 7 可以跳到 2,6
            {1, 3},    // 8 可以跳到 1,3
            {2, 4}     // 9 可以跳到 2,4
        };

        // dp[i] 表示长度为 i+1 的号码以每个数字结尾的数量
        long[] dp = new long[10];
        // 初始长度为1，每个数字都是1种可能
        for (int i = 0; i < 10; i++) dp[i] = 1;

        // 从长度2到n进行动态规划
        for (int step = 2; step <= n; step++) {
            long[] next = new long[10];
            for (int num = 0; num <= 9; num++) {
                for (int jump : moves[num]) {
                    next[num] = (next[num] + dp[jump]) % MOD;
                }
            }
            dp = next;
        }

        // 最终答案是所有数字的总和
        long total = 0;
        for (long count : dp) {
            total = (total + count) % MOD;
        }

        return (int) total;
    }
}
// @lc code=end

