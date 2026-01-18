/*
 * @lc app=leetcode.cn id=2806 lang=javascript
 *
 * [2806] 取整购买后的账户余额
 */

// @lc code=start
/**
 * @param {number} purchaseAmount
 * @return {number}
 */
var accountBalanceAfterPurchase = function(purchaseAmount) {
    const r = purchaseAmount % 10;
    if (r < 5) {
        purchaseAmount -= r;
    } else {
        purchaseAmount += 10 - r;
    }
    return 100 - purchaseAmount;
};
// @lc code=end

