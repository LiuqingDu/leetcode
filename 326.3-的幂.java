/*
 * @lc app=leetcode.cn id=326 lang=java
 *
 * [326] 3 的幂
 */

// @lc code=start
class Solution {
    public boolean isPowerOfThree(int n) {
        
        if (n <= 0) {
            return false;
        }

        while (n % 3 == 0) {
            n = n / 3;
        }
        return n == 1;

        // 这道题因为3是质数，且有最大范围，
        // 在这个范围内3的最大幂是1162261467
        // 因为3是质数，那么如果n是3的幂，它也肯定是这个最大幂的一个约数
        // 如果题目不是质数，那么这个方法不能用
        // return n > 0 && 1162261467 % n == 0;
    }
}
// @lc code=end

