/*
 * @lc app=leetcode.cn id=3168 lang=java
 *
 * [3168] 候诊室中的最少椅子数
 */

// @lc code=start
class Solution {
    public int minimumChairs(String s) {
        int res = 0;
        int cnt = 0;
        
        for (char c : s.toCharArray()) {
            if (c == 'E') {
                cnt++;
                res = Math.max(res, cnt);
            } else {
                cnt--;
            }
        }
        return res;
    }
}
// @lc code=end

