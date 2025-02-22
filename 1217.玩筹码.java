/*
 * @lc app=leetcode.cn id=1217 lang=java
 *
 * [1217] 玩筹码
 */

// @lc code=start
class Solution {
    public int minCostToMoveChips(int[] position) {
        // 可以看出移动偶数个位置的成本为 0
        // 也就是所有的奇数位置之间互相移动的总成本为 0
        // 所有偶数位置之间互相移动成本也为 0
        // 那么可以 0 成本把所有奇数聚集在一起,偶数聚集在一起
        // 并且可以让这两组紧挨着,成本依然为 0
        // 最后一步就是要么奇数组放到偶数组,成本为奇数数量
        // 要么偶数组放到奇数组,成本为偶数数量
        // 所以只需要比较奇数组和偶数组谁少就可以了

        int even = 0, odd = 0;
        for (int pos : position) {
            if ((pos & 1) != 0) {
                odd++;
            } else {
                even++;
            }
        }
        return Math.min(odd, even);
    }
}
// @lc code=end

