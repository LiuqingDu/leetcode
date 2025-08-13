/*
 * @lc app=leetcode.cn id=2108 lang=java
 *
 * [2108] 找出数组中的第一个回文字符串
 */

// @lc code=start
class Solution {
    public String firstPalindrome(String[] words) {
        // 遍历每个单词
        for (String word : words) {
            // 检查单词是否是回文
            if (isPalindrome(word)) {
                // 如果是回文，返回该单词
                return word;
            }
        }
        // 如果没有找到回文单词，返回空字符串
        return "";
    }

    // 辅助方法：检查一个字符串是否是回文
    private boolean isPalindrome(String word) {
        int left = 0;
        int right = word.length() - 1;
        // 使用双指针从两端向中间移动
        while (left < right) {
            // 如果左右字符不相等，返回false
            if (word.charAt(left) != word.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        // 如果所有字符都匹配，返回true
        return true;
    }
}
// @lc code=end

