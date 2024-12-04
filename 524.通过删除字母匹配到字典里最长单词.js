/*
 * @lc app=leetcode.cn id=524 lang=javascript
 *
 * [524] 通过删除字母匹配到字典里最长单词
 */

// @lc code=start
/**
 * @param {string} s
 * @param {string[]} dictionary
 * @return {string}
 */
var findLongestWord = function(s, dictionary) {
    dictionary.sort((a, b) => {
        if (a.length !== b.length) {
            return b.length - a.length;
        }
        return a.localeCompare(b);
    });

    const isSubsequence = (word, s) => {
        let i = 0, j = 0;
        while (i < word.length && j < s.length) {
            if (word[i] === s[j]) {
                i++;
            }
            j++;
        }
        return i === word.length;
    };

    for (const word of dictionary) {
        if (isSubsequence(word, s)) {
            return word;
        }
    }

    return "";
};
// @lc code=end

