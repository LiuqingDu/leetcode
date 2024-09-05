/*
 * @lc app=leetcode.cn id=917 lang=java
 *
 * [917] 仅仅反转字母
 */

// @lc code=start
class Solution {
    public String reverseOnlyLetters(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        for (int i = 0, j = n - 1; i < j; ) {
            while (i < j && !Character.isLetter(cs[i])) {
                i++;
            }

            while (i < j && !Character.isLetter(cs[j])) {
                j--;
            }

            if (i < j) {
                char t = cs[i];
                cs[i] = cs[j];
                cs[j] = t;
            }

            i++;
            j--;
        }
        return String.valueOf(cs);
    }
}
// @lc code=end

