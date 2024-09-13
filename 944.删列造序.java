/*
 * @lc app=leetcode.cn id=944 lang=java
 *
 * [944] 删列造序
 */

// @lc code=start
class Solution {
    public int minDeletionSize(String[] strs) {
        int row = strs.length;
        int col = strs[0].length();
        int res = 0;

        for (int j = 0; j < col; j++) {
            for (int i = 1; i < row; i++) {
                if (strs[i - 1].charAt(j) > strs[i].charAt(j)) {
                    res++;
                    break;
                }
            }
        }
        return res;
    }
}
// @lc code=end

