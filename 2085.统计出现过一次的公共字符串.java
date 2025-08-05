/*
 * @lc app=leetcode.cn id=2085 lang=java
 *
 * [2085] 统计出现过一次的公共字符串
 */

// @lc code=start
class Solution {
    public int countWords(String[] words1, String[] words2) {
        // 使用哈希表统计每个字符串的出现次数
        Map<String, Integer> count1 = new HashMap<>();
        Map<String, Integer> count2 = new HashMap<>();
        for (String word : words1) {
            count1.put(word, count1.getOrDefault(word, 0) + 1);
        }
        for (String word : words2) {
            count2.put(word, count2.getOrDefault(word, 0) + 1);
        }
        // 统计出现过一次的公共字符串
        int result = 0;
        for (String word : count1.keySet()) {
            if (count1.get(word) == 1 && count2.getOrDefault(word, 0) == 1) {
                result++;
            }
        }
        return result;
    }
}
// @lc code=end

