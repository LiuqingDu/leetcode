/*
 * @lc app=leetcode.cn id=1688 lang=java
 *
 * [1688] 比赛中的配对次数
 */

// @lc code=start
class Solution {
    public int numberOfMatches(int n) {
        // 在每一场比赛中，输的队伍无法晋级，且不会再参加后续的比赛。
        // 由于最后只决出一个获胜队伍，因此就有 n−1 个无法晋级的队伍，
        //也就是会有 n−1 场比赛

        return n - 1;
    }
}
// @lc code=end

