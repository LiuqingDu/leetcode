/*
 * @lc app=leetcode.cn id=58 lang=java
 *
 * [58] 最后一个单词的长度
 */

// @lc code=start
class Solution {
    public int lengthOfLastWord(String s) {

        char[] cs = s.toCharArray();
        int n = cs.length;
        
        int i = 0;
        int cur = 0;
        int res = 0;
        while (i < n) {
            if (cs[i] != ' ') {
                cur++;
            } else {
                if (cur != 0) {
                    res = cur;
                    cur = 0;
                }
            }
            i++;
        }

        if (cur != 0) {
            res = cur;
        }

        return res;

    }
}
// @lc code=end

