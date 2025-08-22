/*
 * @lc app=leetcode.cn id=873 lang=java
 *
 * [873] 最长的斐波那契子序列的长度
 */

// @lc code=start
class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        // dp
        // 当确定了两个数, 并把这两个数作为斐波那契数列的最后两个数时,
        // 那么就可以确定这个数列, 剩下要做的就是在前面寻找一个数可以跟这两个组成数列
        // dp[i][j] 表示 arr[i] 和 arr[j] 作为斐波那契数列的最后两个数时, 
        // 数列的长度
        // 那么就有:
        // 如果在前面找到了一个数 arr[k] (k < i),
        // 使得 arr[k] + arr[i] = arr[j], 
        // 那么 dp[i][j] = max(dp[k][i] + 1, 3)
        // 否则 dp[i][j] = 0, 因为长度最少是3,否则就是0
        // 用map记录元素和它的位置,提升查找效率

        Map<Integer, Integer> indices = new HashMap<Integer, Integer>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            indices.put(arr[i], i);
        }

        int[][] dp = new int[n][n];
        int maxLength = 0;
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < j; i++) {
                int k = indices.getOrDefault(arr[j] - arr[i], -1);
                if (k >= 0 && k < i) {
                    dp[i][j] = Math.max(dp[k][i] + 1, 3);
                }
                maxLength = Math.max(maxLength, dp[i][j]);
            }
        }
        return maxLength;
    }
}
// @lc code=end

