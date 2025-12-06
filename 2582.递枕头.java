/*
 * @lc app=leetcode.cn id=2582 lang=java
 *
 * [2582] 递枕头
 */

// @lc code=start
class Solution {
    public int passThePillow(int n, int time) {
        time %= (n - 1) * 2;
        return time < n ? time + 1 : n * 2 - time - 1;
    }
}
// @lc code=end

