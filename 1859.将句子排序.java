/*
 * @lc app=leetcode.cn id=1859 lang=java
 *
 * [1859] 将句子排序
 */

// @lc code=start
class Solution {
    public String sortSentence(String s) {
        String[] words = s.split(" ");
        String[] sorted = new String[words.length];

        for (String word : words) {
            // 获取位置索引（'1' -> 0, '2' -> 1, ..., '9' -> 8）
            int index = word.charAt(word.length() - 1) - '1';
            // 去掉最后一个数字，保留单词部分
            sorted[index] = word.substring(0, word.length() - 1);
        }

        // 用空格拼接排序后的单词
        return String.join(" ", sorted);
    }
}
// @lc code=end

