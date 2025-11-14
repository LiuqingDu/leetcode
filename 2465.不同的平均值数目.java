/*
 * @lc app=leetcode.cn id=2465 lang=java
 *
 * [2465] 不同的平均值数目
 */

// @lc code=start
class Solution {
    public int distinctAverages(int[] nums) {
        Arrays.sort(nums);
        Set<Integer> seen = new HashSet<Integer>();
        for (int i = 0, j = nums.length - 1; i < j; ++i, --j) {
            seen.add(nums[i] + nums[j]);
        }
        return seen.size();
    }
}
// @lc code=end

