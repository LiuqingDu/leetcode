/*
 * @lc app=leetcode.cn id=2806 lang=java
 *
 * [2806] 取整购买后的账户余额
 */

// @lc code=start
class Solution {
    public int accountBalanceAfterPurchase(int purchaseAmount) {
        int r = purchaseAmount % 10;
        if (r < 5) {
            purchaseAmount -= r;
        } else {
            purchaseAmount += 10 - r;
        }
        return 100 - purchaseAmount;
    }
}
// @lc code=end

