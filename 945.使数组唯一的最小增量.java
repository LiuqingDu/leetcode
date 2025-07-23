/*
 * @lc app=leetcode.cn id=945 lang=java
 *
 * [945] 使数组唯一的最小增量
 */

// @lc code=start
class Solution {
    public int minIncrementForUnique(int[] nums) {
        // 因为最终目的是每个数字都不同
        // 那么最终效果的顺序是无所谓的
        // 只要每个数字都不相同就行
        // 那么先排序, 然后从第二个数字开始
        // 每个数字都应该大于前一个数字
        // 如果小于等于, 那么就需要增加
        // 增加的数量就是前一个数字+1 - 当前数字
        // 这样就可以保证每个数字都不相同
        // 最后返回所有增加的数量之和
        Arrays.sort(nums);
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            // 如果当前数字小于等于前一个数字
            // 那么需要增加
            if (nums[i] <= nums[i - 1]) {
                // 需要增加的数量
                int increment = nums[i - 1] + 1 - nums[i];
                res += increment;
                // 更新当前数字
                nums[i] += increment;
            }
        }
        return res;
    }
}
// @lc code=end

