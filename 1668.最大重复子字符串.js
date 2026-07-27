/*
 * @lc app=leetcode.cn id=1668 lang=javascript
 *
 * [1668] 最大重复子字符串
 */

// @lc code=start
/**
 * @param {string} sequence
 * @param {string} word
 * @return {number}
 */
var maxRepeating = function(sequence, word) {
    
    const n = sequence.length, m = word.length;
    if (n < m) {
        return 0;
    }

    const f = new Array(n).fill(0);
    for (let i = m - 1; i < n; ++i) {
        let valid = true;
        for (let j = 0; j < m; ++j) {
            if (sequence[i - m + j + 1] !== word[j]) {
                valid = false;
                break;
            }
        }
        if (valid) {
            f[i] = (i === m - 1 ? 0 : f[i - m]) + 1;
        }
    }

    return _.max(f);

};
// @lc code=end

