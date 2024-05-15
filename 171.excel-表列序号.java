/*
 * @lc app=leetcode.cn id=171 lang=java
 *
 * [171] Excel 表列序号
 */

// @lc code=start
class Solution {
    public int titleToNumber(String columnTitle) {
        // 进制转换问题
        // 从左往右，处理每一位之前，先把之前的结果*进制，然后加上当前位
        // 注意，类似169，这里也需要+1，因为没有0，是从1开始的
        char[] cs = columnTitle.toCharArray();
        int n = cs.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            // 注意下面的+1
            res = res * 26 + (cs[i] - 'A' + 1);
        }
        return res;
    }
}
// @lc code=end

