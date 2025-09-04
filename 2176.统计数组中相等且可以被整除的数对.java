/*
 * @lc app=leetcode.cn id=2176 lang=java
 *
 * [2176] 统计数组中相等且可以被整除的数对
 */

// @lc code=start
class Solution {
    public int countPairs(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j] && (i * j) % k == 0) {
                    count++;
                }
            }
        }
        return count;
    }
}
// @lc code=end

