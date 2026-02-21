/*
 * @lc app=leetcode.cn id=2956 lang=java
 *
 * [2956] 找到两个数组中的公共元素
 */

// @lc code=start
class Solution {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        int[] res = new int[2];
        for (int x1 : nums1) {
            for (int x2 : nums2) {
                if (x1 == x2) {
                    res[0]++;
                    break;
                }
            }
        }
        for (int x2 : nums2) {
            for (int x1 : nums1) {
                if (x2 == x1) {
                    res[1]++;
                    break;
                }
            }
        }
        return res;
    }
}
// @lc code=end

