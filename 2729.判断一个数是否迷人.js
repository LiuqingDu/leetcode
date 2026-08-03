/*
 * @lc app=leetcode.cn id=2729 lang=javascript
 *
 * [2729] 判断一个数是否迷人
 */

// @lc code=start
/**
 * @param {number} n
 * @return {boolean}
 */
var isFascinating = function(n) {
    
    if (n < 123 || n > 329) return false;
    let mask = 0;
    const str = "" + n + (n * 2) + (n * 3);

    for (const c of str) {
        mask |= 1 << (c.charCodeAt(0) - '0'.charCodeAt(0));
        // 也可以写成：mask |= 1 << Number(c);
    }

    return mask === (1 << 10) - 2;
};
// @lc code=end

