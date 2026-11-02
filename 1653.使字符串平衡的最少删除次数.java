/*
 * @lc app=leetcode.cn id=1653 lang=java
 *
 * [1653] 使字符串平衡的最少删除次数
 */

// @lc code=start
class Solution {
    public int minimumDeletions(String s) {
        
        int leftb = 0, righta = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                righta++;
            }
        }
        int res = righta;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'a') {
                righta--;
            } else {
                leftb++;
            }
            res = Math.min(res, leftb + righta);
        }
        return res;

    }
}
// @lc code=end

