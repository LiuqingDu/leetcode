/*
 * @lc app=leetcode.cn id=916 lang=java
 *
 * [916] 单词子集
 */

// @lc code=start
class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        // 把words2里的每个单词的字母出现次数统计出来，取最大值
        // 然后把每个字母的最大值合并当作一个单词,跟words1比较
        // 比如words2 = ["lo","eo"]
        // 那么合并为"leo"
        int[] maxFreq = new int[26];
        for (String word : words2) {
            int[] freq = new int[26];
            for (char c : word.toCharArray()) {
                freq[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                maxFreq[i] = Math.max(maxFreq[i], freq[i]);
            }
        }
        // 然后用maxFreq去跟words1里的每个单词比较
        List<String> res = new ArrayList<>();
        for (String word : words1) {
            int[] freq = new int[26];
            for (char c : word.toCharArray()) {
                freq[c - 'a']++;
            }
            boolean ok = true;
            for (int i = 0; i < 26; i++) {
                if (freq[i] < maxFreq[i]) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                res.add(word);
            }
        }
        return res;
    }
}
// @lc code=end

