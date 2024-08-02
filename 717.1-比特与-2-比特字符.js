/*
 * @lc app=leetcode.cn id=717 lang=javascript
 *
 * [717] 1 比特与 2 比特字符
 */

// @lc code=start
/**
 * @param {number[]} bits
 * @return {boolean}
 */
var isOneBitCharacter = function(bits) {
    let n = bits.length;
    let ind = 0;
    while (ind < n - 1) {
        if (bits[ind] === 1) {
            ind += 2;
        } else {
            ind += 1;
        }
    }
    return ind === n - 1;
};
// @lc code=end

