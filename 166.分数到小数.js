/*
 * @lc app=leetcode.cn id=166 lang=javascript
 *
 * [166] 分数到小数
 */

// @lc code=start
/**
 * @param {number} numerator
 * @param {number} denominator
 * @return {string}
 */
var fractionToDecimal = function(numerator, denominator) {

    if (numerator % denominator === 0) {
        return "" + (numerator /denominator);
    }

    let res = "";
    if (numerator * denominator < 0) {
        res += "-";
    }

    numerator = Math.abs(numerator);
    denominator = Math.abs(denominator);

    res += Math.floor(numerator / denominator) + ".";
    numerator = (numerator % denominator);

    let map = new Map();
    while (numerator !== 0) {
        map.set(numerator, res.length);
        numerator *= 10;
        res += Math.floor(numerator / denominator);
        numerator %= denominator;
        if (map.has(numerator)) {
            let i = map.get(numerator);
            return res.substring(0, i) + "(" + res.substring(i) + ")";
        }
    }

    return res;
};
// @lc code=end

