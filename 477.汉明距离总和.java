/*
 * @lc app=leetcode.cn id=477 lang=java
 *
 * [477] 汉明距离总和
 */

// @lc code=start
class Solution {
    public int totalHammingDistance(int[] nums) {
        // 汉明距离的计算可以从每一位的角度来看：
        // 对于数组中每个数的二进制表示，从第 0 位到最高位逐位计算。
        // 对于某一位，统计有多少个数字该位是 0，多少个数字该位是 1。
        // 这一位的汉明距离贡献是 0 的个数 × 1 的个数。
        // 对所有位累加贡献得到总汉明距离。

        int total = 0;
        int n = nums.length;

        // 遍历每一位（0 到 31）
        for (int i = 0; i < 32; i++) {
            int countOnes = 0;

            // 统计当前位上 1 的个数
            for (int num : nums) {
                // 提取第 i 位
                countOnes += (num >> i) & 1;
            }

            // 0 的个数为 n - countOnes
            int countZeros = n - countOnes;

            // 当前位的汉明距离贡献
            total += countOnes * countZeros;
        }

        return total;
    }
}
// @lc code=end

