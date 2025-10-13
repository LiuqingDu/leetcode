/*
 * @lc app=leetcode.cn id=2315 lang=java
 *
 * [2315] 统计星号
 */

// @lc code=start
class Solution {
    public int countAsterisks(String s) {
        int count = 0;          // 统计不在竖线对之间的 '*' 数量
        boolean insideBar = false;  // 记录当前是否在一对竖线 '|' 之间

        for (char c : s.toCharArray()) {
            if (c == '|') {
                // 每遇到一个竖线，就切换状态
                insideBar = !insideBar;
            } else if (c == '*' && !insideBar) {
                // 如果是 '*' 且当前不在竖线对内，则计数
                count++;
            }
        }

        return count;
    }
}
// @lc code=end

