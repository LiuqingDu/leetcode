/*
 * @lc app=leetcode.cn id=1909 lang=java
 *
 * [1909] 删除一个元素使数组严格递增
 */

// @lc code=start
class Solution {
    public boolean canBeIncreasing(int[] nums) {
        int count = 0; // 用来记录不递增的次数

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                count++;
                if (count > 1) return false; // 超过一次就不行

                // 检查是否可以通过删掉 nums[i-1] 或 nums[i]
                if (i > 1 && nums[i] <= nums[i - 2]) {
                    // 如果当前元素也小于前前一个元素，只能删当前这个
                    nums[i] = nums[i - 1]; // 模拟删掉当前元素
                }
            }
        }

        return true;
    }
}
// @lc code=end

