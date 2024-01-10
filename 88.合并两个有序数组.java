/*
 * @lc app=leetcode.cn id=88 lang=java
 *
 * [88] 合并两个有序数组
 */

// @lc code=start
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 倒着来，把大数从后往前依次放下
        for (int i = m - 1, j = n - 1, k = m + n - 1; k >= 0; k--) {
            // 如果nums2已经空了，或者nums1[i]比nums2[j]大，则把nums1的数放进来
            if (j < 0 || i >= 0 && nums1[i] >= nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
        }
    }
}
// @lc code=end

