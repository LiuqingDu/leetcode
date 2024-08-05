/*
 * @lc app=leetcode.cn id=747 lang=java
 *
 * [747] 至少是其他数字两倍的最大数
 */

// @lc code=start
class Solution {
    public int dominantIndex(int[] nums) {
        // 记录最大的数字 a 和第二大的数字 b，如果 a >= b*2 那么a符合要求
        int ind1 = 0, ind2 = -1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[ind1]) {
                ind2 = ind1;
                ind1 = i;
            } else if (ind2 == -1 || nums[i] > nums[ind2]) {
                ind2 = i;
            }
        }
        return nums[ind1] >= nums[ind2] * 2 ? ind1 : -1;
    }
}
// @lc code=end

