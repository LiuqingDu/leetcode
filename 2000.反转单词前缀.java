/*
 * @lc app=leetcode.cn id=2000 lang=java
 *
 * [2000] 反转单词前缀
 */

// @lc code=start
class Solution {
    public String reversePrefix(String word, char ch) {
        // 找到字符 ch 的位置
        int index = word.indexOf(ch);
        // 如果没有找到 ch，直接返回原字符串
        if (index == -1) {
            return word;
        }
        // 截取前缀并反转
        String prefix = word.substring(0, index + 1);
        String reversedPrefix = new StringBuilder(prefix).reverse().toString();
        // 拼接反转后的前缀和剩余部分
        return reversedPrefix + word.substring(index + 1);
    }
}
// @lc code=end

