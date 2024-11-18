/*
 * @lc app=leetcode.cn id=467 lang=javascript
 *
 * [467] 环绕字符串中唯一的子字符串
 */

// @lc code=start
/**
 * @param {string} s
 * @return {number}
 */
var findSubstringInWraproundString = function(s) {
    let n = s.length;
    if (n === 0) return 0;

    let arr = Array(26).fill(0);
    let currLength = 0;

    for (let i = 0; i < n; i++) {
        if (i > 0 && 
            (s[i].charCodeAt() - s[i - 1].charCodeAt() === 1 || 
             (s[i] === 'a' && s[i - 1] === 'z'))) {
            currLength++;
        } else {
            currLength = 1;
        }
        let index = s[i].charCodeAt() - 'a'.charCodeAt();
        arr[index] = Math.max(arr[index], currLength);
    }

    return arr.reduce((pre, cur) => pre + cur);
};
// @lc code=end

