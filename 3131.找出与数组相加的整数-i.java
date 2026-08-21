/*
 * @lc app=leetcode.cn id=3131 lang=java
 *
 * [3131] 找出与数组相加的整数 I
 */

// @lc code=start
class Solution {
    public int addedInteger(int[] nums1, int[] nums2) {
        
        return Arrays.stream(nums2).min().getAsInt() - Arrays.stream(nums1).min().getAsInt();
    }
}
// @lc code=end

