/*
 * @lc app=leetcode.cn id=424 lang=javascript
 *
 * [424] 替换后的最长重复字符
 */

// @lc code=start
/**
 * @param {string} s
 * @param {number} k
 * @return {number}
 */
var characterReplacement = function(s, k) {
    const map = new Array(26).fill(0);
    const chars = s.split('');
    let left = 0;
    let right = 0;
    let historyCharMax = 0;

    for (right = 0; right < chars.length; right++) {
        const ch = chars[right].charCodeAt(0) - 'A'.charCodeAt(0);
        map[ch]++;
        historyCharMax = Math.max(historyCharMax, map[ch]);

        if (right - left + 1 - k > historyCharMax) {
            map[chars[left].charCodeAt(0) - 'A'.charCodeAt(0)]--;
            left++;
        }
    }

    return right - left;
};
// @lc code=end

