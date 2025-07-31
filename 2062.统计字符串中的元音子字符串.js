/*
 * @lc app=leetcode.cn id=2062 lang=javascript
 *
 * [2062] 统计字符串中的元音子字符串
 */

// @lc code=start
/**
 * @param {string} word
 * @return {number}
 */
var countVowelSubstrings = function(word) {

    const isVowel = function(c) {
        return c === 'a' || c === 'e' || c === 'i' || c === 'o' || c === 'u';
    }

    const countValidSubstrings = function(s, left, right) {
        let count = 0;
        const freq = new Array(26).fill(0);
        let validCount = 0;
        let start = left;

        for (let end = left; end < right; end++) {
            const c = s[end];
            freq[c.charCodeAt(0) - 97]++;
            if (freq[c.charCodeAt(0) - 97] === 1) {
                validCount++;
            }
            while (validCount === 5 && freq[s[start].charCodeAt(0) - 97] > 1) {
                freq[s[start].charCodeAt(0) - 97]--;
                start++;
            }
            if (validCount === 5) {
                count += start - left + 1;
            }
        }
        return count;
    }

    let res = 0;
    const n = word.length;
    let left = 0;

    while (left < n) {
        if (!isVowel(word[left])) {
            left++;
            continue;
        }
        let right = left;
        while (right < n && isVowel(word[right])) {
            right++;
        }
        if (right - left >= 5) {
            res += countValidSubstrings(word, left, right);
        }
        left = right;
    }
    return res;
}
// @lc code=end

