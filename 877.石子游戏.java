/*
 * @lc app=leetcode.cn id=877 lang=java
 *
 * [877] 石子游戏
 */

// @lc code=start
class Solution {
    // 因为堆数为偶数，所以先手可以控制自己永远只拿序号为奇数的堆或者偶数的堆
    // 那么开局的时候先手可以根据计算所有奇数堆跟偶数堆哪个总数大，就让自己永远拿那些堆来确保自己赢
    // 比如1，2，3，4堆，先手如果想拿奇数堆，就先拿1，那么后手只能拿偶数2或者4，先手可以再拿3
    // 如果先手想拿偶数堆，就先拿4，给后手留下1和3，无论如何先手都还可以拿2
    // 所以先手永远赢
    public boolean stoneGame(int[] piles) {
        return true;
    }
}
// @lc code=end

