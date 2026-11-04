/*
 * @lc app=leetcode.cn id=3222 lang=java
 *
 * [3222] 求出硬币游戏的赢家
 */

// @lc code=start
class Solution {
    public String winningPlayer(int x, int y) {
        int ops = Math.min(x, y / 4);
        return ops % 2 == 1 ? "Alice" : "Bob";
    }
}
// @lc code=end

