/*
 * @lc app=leetcode.cn id=3046 lang=java
 *
 * [3046] 分割数组
 */

// @lc code=start
class Solution {
    public boolean isPossibleToSplit(int[] nums) {
        int[]arr = new int[101];
        for (int num : nums) {
            arr[num]++;
            if (arr[num] > 2) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

