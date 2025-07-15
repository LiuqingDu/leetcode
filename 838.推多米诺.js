/*
 * @lc app=leetcode.cn id=838 lang=javascript
 *
 * [838] 推多米诺
 */

// @lc code=start
/**
 * @param {string} dominoes
 * @return {string}
 */
var pushDominoes = function(dominoes) {
    const n = dominoes.length;
    let left = Array(n).fill(-1);
    let right = Array(n).fill(-1);
    
    for (let i = 0, j = -1; i < n; i++) {
        if (dominoes[i] === 'R') {
            j = i;
        } else if (dominoes[i] === 'L') {
            j = -1;
        }
        right[i] = j === -1 ? Number.MAX_VALUE : i - j;
    }

    for (let i = n - 1, j = -1; i >= 0; i--) {
        if (dominoes[i] === 'L') {
            j = i;
        } else if (dominoes[i] === 'R') {
            j = -1;
        }
        left[i] = j === -1 ? Number.MAX_VALUE : j - i;
    }

    let result = '';
    for (let i = 0; i < n; i++) {
        if (left[i] < right[i]) {
            result += 'L';
        } else if (left[i] > right[i]) {
            result += 'R';
        } else {
            result += dominoes[i];
        }
    }

    return result;
};
// @lc code=end

