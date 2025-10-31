/*
 * @lc app=leetcode.cn id=2404 lang=java
 *
 * [2404] 出现最频繁的偶数元素
 */

// @lc code=start
class Solution {
    public int mostFrequentEven(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            if (num % 2 == 0) {
                countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            }
        }

        int maxCount = 0;
        int result = -1;
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();
            if (count > maxCount || (count == maxCount && num < result)) {
                maxCount = count;
                result = num;
            }
        }

        return result;
    }
}
// @lc code=end

