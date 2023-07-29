/*
 * @lc app=leetcode.cn id=292 lang=java
 *
 * [292] Nim 游戏
 */

// @lc code=start
class Solution {
    public boolean canWinNim(int n) {
        // 可以发现如果轮到自己回合，总数为4的倍数必输，其余情况都可以赢
        return !(n % 4 == 0);
    }
}
// @lc code=end

