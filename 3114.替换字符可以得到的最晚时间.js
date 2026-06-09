/*
 * @lc app=leetcode.cn id=3114 lang=javascript
 *
 * [3114] 替换字符可以得到的最晚时间
 */

// @lc code=start
/**
 * @param {string} s
 * @return {string}
 */
var findLatestTime = function(s) {
    
    // 将字符串拆分为字符数组，方便直接修改每一位
    const chars = s.split('');

    // 1. 处理小时的第一位 chars[0]
    if (chars[0] === '?') {
        // 【关键修正】偷看第二位：如果第二位是明确的数字且大于 '1'（比如 '3'）
        // 为了让整体不超过 '11'，第一位最大只能填 '0'（变成 '03'）
        if (chars[1] !== '?' && chars[1] > '1') {
            chars[0] = '0';
        } else {
            // 其他情况（第二位是 '?'、'0' 或 '1'），第一位都可以放心填 '1'
            chars[0] = '1';
        }
    }

    // 2. 处理小时的第二位 chars[1]
    if (chars[1] === '?') {
        // 如果第一位是 '1'，为了不超过 11，这一位最大只能是 '1' (组成 11)
        // 如果第一位是 '0'，这一位最大可以是 '9' (组成 09)
        chars[1] = (chars[0] === '1') ? '1' : '9';
    }

    // 3. 处理分钟的十位 chars[3]
    if (chars[3] === '?') {
        chars[3] = '5'; // 分钟十位最大是 5
    }

    // 4. 处理分钟的个位 chars[4]
    if (chars[4] === '?') {
        chars[4] = '9'; // 分钟个位最大是 9
    }

    // 将数组重新拼接成字符串返回
    return chars.join('');
};
// @lc code=end

