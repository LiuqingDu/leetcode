/*
 * @lc app=leetcode.cn id=413 lang=java
 *
 * [413] 等差数列划分
 */

// @lc code=start
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        // 明显 dp
        // 定义 dp[i] 表示以 nums[i] 为结尾的等差子序列的个数
        // 假设 dp[i - 1] = k，那么如果 nums[i] 也跟前面的元素可以
        // 继续组成等差子序列，那么 dp[i] = k+1
        // 可以这么思考，新的元素 nums[i] 记为 x，
        // x 可以跟前面的元素组成等差数列
        // 先记原先的最长的等差数列为 [a,b,c,...,d]，记为 A
        // 新加入元素 x 形成 [a,b,c,...,d,x] 且形成等差数列
        // 现在移除第一个元素 a，变成 [b,c,...,d,x] 记为 A'
        // 可以看出 A 和 A' 长度是一样的，且都是等差数列
        // 那么它们的等差子序列的个数也是一样的
        // 那么它们都以各自最后一个元素结尾的等差子序列的个数也是一样的
        // 那么 A' 的基础上再多一个 [a,b,c,...,d,x] 这一个子序列
        // 就是 dp[i] 了
        // 然后在计算 dp 的过程中累加总和就可以了

        int n = nums.length;
        if (n < 3) {
            return 0;
        }

        int[] dp = new int[n];
        int res = 0;

        for (int i = 2; i < n; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = 0;
            }
            res += dp[i];
        }

        return res;
    }
}
// @lc code=end

