/*
 * @lc app=leetcode.cn id=1528 lang=java
 *
 * [1528] 重新排列字符串
 */

// @lc code=start
class Solution {
    public String restoreString(String s, int[] indices) {
        int n = indices.length;
        char[] res = new char[n];
        char[] cs = s.toCharArray();
        for (int i = 0; i < n; i++) {
            res[indices[i]] = cs[i];
        }
        return new String(res);
    }
}
// @lc code=end

