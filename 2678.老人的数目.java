/*
 * @lc app=leetcode.cn id=2678 lang=java
 *
 * [2678] 老人的数目
 */

// @lc code=start
class Solution {
    public int countSeniors(String[] details) {
        int count = 0;
        for (String info : details) {
            if (Integer.parseInt(info.substring(11, 13)) > 60) {
                count++;
            }
        }
        return count;
    }
}
// @lc code=end

