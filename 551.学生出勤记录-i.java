/*
 * @lc app=leetcode.cn id=551 lang=java
 *
 * [551] 学生出勤记录 I
 */

// @lc code=start
class Solution {
    public boolean checkRecord(String s) {
        char[] cs = s.toCharArray();
        int aCount = 0;
        int lCount = 0;
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == 'A') {
                lCount = 0;
                aCount++;
                if (aCount == 2) {
                    return false;
                }
            } else if (cs[i] == 'L') {
                lCount++;
                if (lCount == 3) {
                    return false;
                }
            } else {
                lCount = 0;
            }
        }
        return true;
    }
}
// @lc code=end

