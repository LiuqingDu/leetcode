/*
 * @lc app=leetcode.cn id=910 lang=java
 *
 * [910] 最小差值 II
 */

// @lc code=start
class Solution {
    public int smallestRangeII(int[] nums, int k) {
        // 因为每个数字都必须进行操作, 那么为了让分数最小, 应该让大的数字减去k, 小的数字加上k
        // 这里关键就是如何找到这个分界点, 也就是分割大数和小数的点
        // 这时候新的问题来了, 最大的小数加上k之后可能变成新的大数, 最小的大数减去k之后可能变成新的小数
        // 所以我们需要找到当前数组的最大值和最小值, 然后计算出新的最大值和最小值
        // 最终的结果就是新的最大值和新的最小值的差值
        
        Arrays.sort(nums);
        int n = nums.length;
        int min = nums[0];
        int max = nums[n - 1];
        int res = max - min;

        // 遍历数组, 找到分割点
        // 把每一个元素都当作分割点来计算它的分值, 找到分值最小的
        for (int i = 0; i < n - 1; i++) {
            // 计算当前分割点的最大值和最小值
            // 当前分割点是指 nums[0] 到 nums[i] 是小数部分, 
            // nums[i + 1] 到 nums[n - 1] 是大数部分
            // 这里需要注意的是, 分割点的最大值是 nums[i] + k, 最小值是 nums[i + 1] - k
            // 因为我们要让小数部分的最大值尽可能大, 大数部分的最小值尽可能小
            int newMax = Math.max(max - k, nums[i] + k);
            int newMin = Math.min(min + k, nums[i + 1] - k);
            res = Math.min(res, newMax - newMin);
        }
        
        return res;
    }
}
// @lc code=end

