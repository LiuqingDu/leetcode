/*
 * @lc app=leetcode.cn id=976 lang=java
 *
 * [976] 三角形的最大周长
 */

// @lc code=start
class Solution {
    public int largestPerimeter(int[] nums) {
        // 三边组成三角形需要满足任意两边之和大于第三边
        // 将 nums 排序，取三个数字，组成三角形就是需要小的两个边之和大于第三边
        // 那么在选中第三边的情况下，另外两边取仅次于第三边的，是最可能形成三角形的
        // 也是周长最长的
        // 那么聪大到小依次当做第三边，然后看仅次于它的两边能否组成三角形

        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 2; i--) {
            if (nums[i - 2] + nums[i - 1] > nums[i]) {
                return nums[i - 2] + nums[i - 1] + nums[i];
            }
        }
        return 0;
    }
}
// @lc code=end

