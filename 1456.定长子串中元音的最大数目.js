/*
 * @lc app=leetcode.cn id=1456 lang=javascript
 *
 * [1456] 定长子串中元音的最大数目
 */

// @lc code=start
/**
 * @param {string} s
 * @param {number} k
 * @return {number}
 */
var maxVowels = function(s, k) {

    let isVowel = (c) => {
        return 'aeiou'.includes(c);
    }

    let max = 0;
    let count = 0;

    for (let i = 0; i < k; i++) {
        if (isVowel(s[i])) {
            count++;
        }
    }

    max = count;

    for (let i = k; i < s.length; i++) {
        if (isVowel(s[i])) {
            count++;
        }
        if (isVowel(s[i - k])) {
            count--;
        }
        max = Math.max(max, count);
    }

    return max;
};
// @lc code=end

