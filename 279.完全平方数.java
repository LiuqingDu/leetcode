/*
 * @lc app=leetcode.cn id=279 lang=java
 *
 * [279] 完全平方数
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int numSquares(int n) {
        // 明显动态规划
        // 理解为有一堆面值为1, 4, 9, 16的硬币，凑出面值为 n 的硬币至少需要多少枚
        // 定义 dp[i] 为凑出面值为 i 的最少硬币数
        // 因为存在 1 的硬币，所以无论如何都可以凑得出
        // 代码简单点的话初始硬币数为 MAX_VALUE ，其实初始化为 i 也一样
        // 外层遍历每一个总面额，当前面额方案下，内层循环遍历可能的硬币数值，
        // 每当有一个硬币可用的时候，包含该硬币的最佳方案就是剩余面值的最佳方案+1
        // 比如面值10，发现一部分面值可以使用4，那么用一枚4的方案就是(10-4)=6元最优方案+1
        // 6元最优方案也可同理得出为3枚
        // 但是对于10元的题目，当检查到9元的时候，发现有更好的方案，就可以替换掉了

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        // 计算每种总额方案
        for (int i = 1; i <= n; i++) {
            // 当前方案下，依次计算至少包含一枚j*j硬币的最优方案
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];

    }
}
// @lc code=end

