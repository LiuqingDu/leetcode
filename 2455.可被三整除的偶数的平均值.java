/*
 * @lc app=leetcode.cn id=2455 lang=java
 *
 * [2455] 可被三整除的偶数的平均值
 */

// @lc code=start
class Solution {
    public int averageValue(int[] nums) {
        int total = 0, k = 0;
        for (int a : nums) {
            if (a % 6 == 0) {
                total += a;
                k++;
            }
        }
        return k > 0 ? total / k : 0;
    }
}
// @lc code=end

