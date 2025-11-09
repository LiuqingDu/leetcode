/*
 * @lc app=leetcode.cn id=2441 lang=java
 *
 * [2441] 与对应负数同时存在的最大正整数
 */

// @lc code=start
class Solution {
    public int findMaxK(int[] nums) {
        int k = -1;
        for (int x : nums) {
            for (int y : nums) {
                if (-x == y) {
                    k = Math.max(k, x);
                }
            }
        }
        return k;
    }
}
// @lc code=end

