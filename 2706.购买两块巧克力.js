/*
 * @lc app=leetcode.cn id=2706 lang=javascript
 *
 * [2706] 购买两块巧克力
 */

// @lc code=start
/**
 * @param {number[]} prices
 * @param {number} money
 * @return {number}
 */
var buyChoco = function(prices, money) {
    let fi = Number.MAX_SAFE_INTEGER;
    let se = Number.MAX_SAFE_INTEGER;
    for (let price of prices) {
        if (price < fi) {
            [se, fi] = [fi, price];
        } else if (price < se) {
            se = price;
        }
    }
    return money < fi + se ? money : money - fi - se;
};
// @lc code=end

