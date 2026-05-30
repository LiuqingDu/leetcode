/*
 * @lc app=leetcode.cn id=1390 lang=java
 *
 * [1390] 四因数
 */

// @lc code=start
class Solution {
    public int sumFourDivisors(int[] nums) {
        int totalSum = 0;
        
        for (int num : nums) {
            // 用一个方法来计算单个数字的 4 因数之和，如果不是 4 个因数则返回 0
            totalSum += getFourDivisorsSum(num);
        }
        
        return totalSum;
    }

    private int getFourDivisorsSum(int n) {
        int count = 0;  // 记录因数的个数
        int sum = 0;    // 记录因数的和
        
        // 只需遍历到根号 n
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                // 找到了一个因数 i
                count++;
                sum += i;
                
                // 找到对应的另一个因数 n / i
                if (i * i != n) { // 确保不是完全平方根（比如 4 的根是 2，避免 2 被加两次）
                    count++;
                    sum += n / i;
                }
                
                // 剪枝优化：如果因数个数已经超过 4 个了，直接淘汰
                if (count > 4) {
                    return 0;
                }
            }
        }
        
        // 只有当因数个数恰好等于 4 时，才返回因数之和
        return count == 4 ? sum : 0;
    }
}
// @lc code=end

