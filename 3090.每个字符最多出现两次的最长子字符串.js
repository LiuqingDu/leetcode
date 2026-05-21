/*
 * @lc app=leetcode.cn id=3090 lang=javascript
 *
 * [3090] 每个字符最多出现两次的最长子字符串
 */

// @lc code=start
/**
 * @param {string} s
 * @return {number}
 */
var maximumLengthSubstring = function(s) {
    const count = new Array(26).fill(0);

    let left = 0;
    let maxLen = 0;

    for (let right = 0; right < s.length; right++) {

        const rIndex = s.charCodeAt(right) - "a".charCodeAt(0);
        count[rIndex]++;

        // 如果当前字符超过2次，收缩窗口
        while (count[rIndex] > 2) {

            const lIndex = s.charCodeAt(left) - "a".charCodeAt(0);
            count[lIndex]--;
            left++;
        }

        maxLen = Math.max(maxLen, right - left + 1);
    }

    return maxLen;
};
// @lc code=end

