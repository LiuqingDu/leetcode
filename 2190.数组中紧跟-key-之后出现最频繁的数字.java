/*
 * @lc app=leetcode.cn id=2190 lang=java
 *
 * [2190] 数组中紧跟 key 之后出现最频繁的数字
 */

// @lc code=start
class Solution {
    public int mostFrequent(int[] nums, int key) {
        // 记录紧跟在 key 后面的数字出现的频率
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == key) {
                freqMap.put(nums[i + 1], freqMap.getOrDefault(nums[i + 1], 0) + 1);
            }
        }
        int maxFreq = 0;
        int mostFrequentNum = -1;
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() > maxFreq) {
                maxFreq = entry.getValue();
                mostFrequentNum = entry.getKey();
            }
        }
        return mostFrequentNum;
    }
}
// @lc code=end

