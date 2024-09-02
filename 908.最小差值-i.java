/*
 * @lc app=leetcode.cn id=908 lang=java
 *
 * [908] 最小差值 I
 */

// @lc code=start
class Solution {
    public int smallestRangeI(int[] nums, int k) {
        // 题目意思是，对于数组里每一个数字，都可以把它改为 (nums[i] - k) 到 (nums[i] + k) 之间的一个数
        // 记这个数组的差值为 d，那么，如果k足够大，就可以把数组所有的数都改为同一个数字，使得 d=0
        // 如果 k=0 那么所有数字都不能改，d保持不变
        // 如果k刚好等于 d/2 那么最小值可以增加 d/2，最大值可以减去 d/2
        // 使得每一个数字都可以刚好改为同一个数字，使得d刚好为0
        // k如果在0到 d/2之间，可以使得d在 d 到 0 之间变化
        // 新的d 就等于 d - 2*k
        int max = nums[0], min = nums[0];
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        return Math.max(0, max - min -  2 * k);
    }
}
// @lc code=end

