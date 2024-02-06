/*
 * @lc app=leetcode.cn id=38 lang=java
 *
 * [38] 外观数列
 */

// @lc code=start
class Solution {
    public String countAndSay(int n) {

        StringBuilder pre = new StringBuilder("");
        StringBuilder cur = new StringBuilder("1");

        for (int i = 1; i < n; i++) {
            pre = cur;
            cur = new StringBuilder("");
            int start = 0;
            int end = 0;
            while (end < pre.length()) {
                while (end < pre.length() && pre.charAt(start) == pre.charAt(end)) {
                    end++;
                }
                cur.append(end - start).append(pre.charAt(start));
                start = end;
            }
        }

        return cur.toString();

    }
}
// @lc code=end

