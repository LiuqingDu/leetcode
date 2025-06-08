/*
 * @lc app=leetcode.cn id=1880 lang=java
 *
 * [1880] 检查某单词是否等于两单词之和
 */

// @lc code=start
class Solution {
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        int num1 = wordToNumber(firstWord);
        int num2 = wordToNumber(secondWord);
        int target = wordToNumber(targetWord);
        return num1 + num2 == target;
    }

    private int wordToNumber(String word) {
        int num = 0;
        for (int i = 0; i < word.length(); i++) {
            int digit = word.charAt(i) - 'a';
            num = num * 10 + digit;
        }
        return num;
    }
}
// @lc code=end

