/*
 * @lc app=leetcode.cn id=3280 lang=javascript
 *
 * [3280] 将日期转换为二进制表示
 */

// @lc code=start
/**
 * @param {string} date
 * @return {string}
 */
function binary(x) {
    let s = '';
    while (x !== 0) {
        s += (x & 1);
        x >>= 1;
    }
    return s.split('').reverse().join('');
}

var convertDateToBinary = function(date) {
    const year = parseInt(date.substring(0, 4), 10);
    const month = parseInt(date.substring(5, 7), 10);
    const day = parseInt(date.substring(8, 10), 10);
    return binary(year) + "-" + binary(month) + "-" + binary(day);
};

// @lc code=end

