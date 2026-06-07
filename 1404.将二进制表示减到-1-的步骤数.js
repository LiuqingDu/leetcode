/*
 * @lc app=leetcode.cn id=1404 lang=javascript
 *
 * [1404] 将二进制表示减到 1 的步骤数
 */

// @lc code=start
/**
 * @param {string} s
 * @return {number}
 */
var numSteps = function(s) {
    let steps = 0;
    let carry = 0;

    for (let i = s.length - 1; i > 0; i--) {
        let currentBit = s.charCodeAt(i) - "0".charCodeAt(0);

        if ((currentBit + carry) % 2 == 1) {
            steps += 2;
            carry = 1;
        } else {
            steps += 1;
        }
    }
    return steps + carry;
};
// @lc code=end

