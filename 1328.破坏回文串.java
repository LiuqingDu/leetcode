/*
 * @lc app=leetcode.cn id=1328 lang=java
 *
 * [1328] 破坏回文串
 */

// @lc code=start
class Solution {
    public String breakPalindrome(String palindrome) {

        int n = palindrome.length();

        // 长度为1，无法变成非回文
        if (n == 1) {
            return "";
        }

        char[] chars = palindrome.toCharArray();

        // 只遍历前半部分
        for (int i = 0; i < n / 2; i++) {

            // 找到第一个不是a的字符
            if (chars[i] != 'a') {

                // 改成a
                chars[i] = 'a';

                return new String(chars);
            }
        }

        // 前半部分全是a
        // 最后一个字符改成b
        chars[n - 1] = 'b';

        return new String(chars);
    }
}
// @lc code=end

