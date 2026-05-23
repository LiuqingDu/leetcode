/*
 * @lc app=leetcode.cn id=1375 lang=javascript
 *
 * [1375] 二进制字符串前缀一致的次数
 */

// @lc code=start
/**
 * @param {number[]} flips
 * @return {number}
 */
var numTimesAllBlue = function(flips) {
    let ans = 0;
    let max = 0;

    for (let i = 0; i < flips.length; i++) {
        // 当前翻转到的最大位置
        max = Math.max(max, flips[i]);

        // i + 1 表示当前进行了多少步
        if (max === i + 1) {
            ans++;
        }
    }

    return ans;
};
// @lc code=end

