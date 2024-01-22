/*
 * @lc app=leetcode.cn id=125 lang=java
 *
 * [125] 验证回文串
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int i = 0, j = s.length() - 1;

        while (i < j) {
            while (i < j && !valid(s.charAt(i))) {
                i++;
            }
            while (i < j && !valid(s.charAt(j))) {
                j--;
            }
            if (i < j) {
                if (s.charAt(i) != s.charAt(j)) {
                    return false;
                }
            }
            i++;
            j--;
        }

        return true;
    }

    private boolean valid(Character c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
    }
}
// @lc code=end

