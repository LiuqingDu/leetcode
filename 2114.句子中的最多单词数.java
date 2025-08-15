/*
 * @lc app=leetcode.cn id=2114 lang=java
 *
 * [2114] 句子中的最多单词数
 */

// @lc code=start
class Solution {
    public int mostWordsFound(String[] sentences) {
        int res = 0;
        for (String sentence : sentences) {
            // 分割
            String[] words = sentence.split(" ");
            // 更新最大单词数
            res = Math.max(res, words.length);
        }
        return res;
    }
}
// @lc code=end

