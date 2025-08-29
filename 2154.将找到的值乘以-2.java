/*
 * @lc app=leetcode.cn id=2154 lang=java
 *
 * [2154] 将找到的值乘以 2
 */

// @lc code=start
class Solution {
    public int findFinalValue(int[] nums, int original) {
        while (true) {
            boolean found = false;
            for (int num : nums) {
                if (num == original) {
                    original *= 2;
                    found = true;
                    break;
                }
            }
            if (!found) {
                break;
            }
        }
        return original;
    }
}
// @lc code=end

