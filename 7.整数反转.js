/*
 * @lc app=leetcode.cn id=7 lang=javascript
 *
 * [7] 整数反转
 */

// @lc code=start
/**
 * @param {number} x
 * @return {number}
 */
var reverse = function(x) {
    let rev = 0;
    while (x != 0) {
        rev = rev*10 + x%10;
        if (rev > Math.pow(2, 31) - 1 || rev < Math.pow(-2, 31)) {
            return 0;
        }
        // ~~ will make x into Integer
        x = ~~(x/10);
    }
    return rev;

};
// @lc code=end

