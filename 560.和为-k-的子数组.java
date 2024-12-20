/*
 * @lc app=leetcode.cn id=560 lang=java
 *
 * [560] 和为 K 的子数组
 */

// @lc code=start
class Solution {
    public int subarraySum(int[] nums, int k) {
        // 看上去可以用滑动窗口,但实际不行
        // 如果所有数字都是正数,那么可以用滑动窗口
        // 因为窗口内数字越多总和越大,如果右边元素进来后总和过大
        // 则可以从左边缩小窗口
        // 但如果元素有负数,那么缩小窗口既可以向左(左边有负数的话)
        // 也可以向右,方向不固定,所以不行
        // 这种情况下可以用前缀和

        int n = nums.length;
        int[] prefixSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        
        int result = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int sum : prefixSum) {
            // 如果已经存在目标前缀和,那么这些前缀和当中每一个都可以跟当前的前缀和组成一组答案
            // 所以总数量 += 目标前缀和数量
            if (countMap.containsKey(sum - k)) {
                result += countMap.get(sum - k);
            }
            countMap.put(sum, countMap.getOrDefault(sum, 0) + 1);
        }
        return result;
    }
}
// @lc code=end

