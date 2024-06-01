/*
 * @lc app=leetcode.cn id=350 lang=java
 *
 * [350] 两个数组的交集 II
 */

// @lc code=start

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0, ind = 0, m = nums1.length, n = nums2.length;
        int[] res = new int[Math.min(m, n)];
        while (i < m && j < n) {
            if (nums1[i] == nums2[j]) {
                res[ind] = nums1[i];
                ind++;
                i++;
                j++;
            } else {
                if (nums1[i] < nums2[j]) {
                    i++;
                } else {
                    j++;
                }
            }
        }

        return Arrays.copyOfRange(res, 0, ind);
    }
}
// @lc code=end

