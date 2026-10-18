/*
 * @lc app=leetcode.cn id=3360 lang=java
 *
 * [3360] 移除石头游戏
 */

// @lc code=start
class Solution {
    public boolean canAliceWin(int n) {
        
        int pick = 10;
        while (n >= pick) {
            n -= pick;
            pick--;
        }
        return (10 - pick) % 2 > 0;
    }
}
// @lc code=end

