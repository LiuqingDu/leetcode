/*
 * @lc app=leetcode.cn id=2006 lang=java
 *
 * [2006] 差的绝对值为 K 的数对数目
 */

// @lc code=start
class Solution {
    public int countKDifference(int[] nums, int k) {
        // 其实是 two sum 的变种
        // 用 HashMap 记录每个数出现的次数
        Map<Integer, Integer> countMap = new HashMap<>();
        int result = 0;

        for (int num : nums) {
            // 检查 num + k 是否存在
            if (countMap.containsKey(num + k)) {
                // 如果存在，累加出现次数
                result += countMap.get(num + k);
            }
            // 检查 num - k 是否存在
            if (countMap.containsKey(num - k)) {
                // 如果存在，累加出现次数
                result += countMap.get(num - k);
            }
            // 更新当前数的出现次数
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        return result;
    }
}
// @lc code=end

