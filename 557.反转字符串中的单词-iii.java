/*
 * @lc app=leetcode.cn id=557 lang=java
 *
 * [557] 反转字符串中的单词 III
 */

// @lc code=start
class Solution {
    public String reverseWords(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        int i = 0;
        while (i < n) {
            int start = i;
            while (i < n && cs[i] != ' ') {
                i++;
            }
            // i指向一个空格，或者是末尾
            reverse(cs, start, i - 1);
            // 翻转完，跳过当前指向的空格
            i++;
        }
        return new String(cs);
    }

    private void reverse(char[] cs, int l, int r) {
        while (l < r) {
            char c = cs[l];
            cs[l] = cs[r];
            cs[r] = c;
            l++;
            r--;
        }
    }
}
// @lc code=end

