/*
 * @lc app=leetcode.cn id=416 lang=java
 *
 * [416] 分割等和子集
 */

// @lc code=start
class Solution {
    // 类似背包问题，
    // 可以理解为将一部分数字放进一个容量为sum/2的背包，问是否可以刚好装下
    // 动态规划，对于每一个数字，可以选择装入背包或者不装入
    // 定义dp[i][j]表示用前i个数字中的一部分数字往容量为j的背包里面装，是否能够刚好装下
    // 最终答案应该是dp[n][sum/2]，表示前n个数字的一部分数字往sum/2里装，
    // 如果刚好装下，那么没有装进去的数字的总和正好也等于sum/2
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) {
            return false;
        }

        // target表示其中一个子集的总和，如果有一部分数字刚好满足一个子集，
        // 那么剩下的数字就刚好满足另一个子集
        int target = sum / 2;

        // dp表示前i个数字的一部分装到容量为j的背包里，i和j均从0开始，所以容量要+1
        boolean[][] dp = new boolean[n + 1][target + 1];
        for (int i = 0; i <= n; i++) {
            // 往容量为0的背包里装，一个都不装就可以，所以为true
            // 注意理解这里的意思，仅仅表示前i个数字中取一部分可以刚好满足j，
            // 但并不表示取剩下的那一部分数字之和等于j
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                // 注意i表示前i个数字，对应索引要-1
                if (nums[i - 1] > j) {
                    // 如果当前这个数字比背包大，那么就不能装入背包
                    // 那么可选的数字就只有除了当前数字外，之前的那些数字，
                    // 那么当前dp就取决于【这个数字之前的那些数字能否装下当前的背包】
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // 如果当前数字不比背包大，那么当前有两种选择：
                    // 把当前数字装入背包，或者不装入
                    // 这两种情况有任意一种可以装下，那么就是true
                    // 下面或运算符左右分别对应装入和不装入
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] || dp[i - 1][j];
                }
            }
        }

        // 如果前n个数字可以有一部分数字刚好装满target，也就是sum/2，
        // 那么剩下的数字也就刚好装满另一个sum/2
        return dp[n][target];

    }
}
// @lc code=end

