/*
 * @lc app=leetcode.cn id=1556 lang=javascript
 *
 * [1556] 千位分隔数
 */

// @lc code=start
/**
 * @param {number} n
 * @return {string}
 */
var thousandSeparator = function(n) {
    let count = 0;
    let ans = "";
    do {
        let cur = n % 10;
        n = Math.floor(n / 10);
        ans += cur.toString();
        ++count;
        if (count % 3 == 0 && n) {
            ans += '.';
        }
    } while (n);
    return ans.split('').reverse().join('');
};
// @lc code=end

