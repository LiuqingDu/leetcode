/*
 * @lc app=leetcode.cn id=1561 lang=java
 *
 * [1561] 你可以获得的最大硬币数目
 */

// @lc code=start
class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int n = piles.length;
        int l = n / 3;
        int res = 0;
        for (int i = l; i < n - 1; i+=2) {
            res += piles[i];
        }
        return res;
    }
}
// @lc code=end

