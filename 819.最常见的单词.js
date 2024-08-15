/*
 * @lc app=leetcode.cn id=819 lang=javascript
 *
 * [819] 最常见的单词
 */

// @lc code=start
/**
 * @param {string} paragraph
 * @param {string[]} banned
 * @return {string}
 */
var mostCommonWord = function(paragraph, banned) {
    
    let isLetter = function(c) {
        let t = c.charCodeAt(0), a = "a".charCodeAt(0), z = "z".charCodeAt(0), A = "A".charCodeAt(0), Z = "Z".charCodeAt(0);
        return (t >= a && t <= z) || (t >= A && t <= Z);
    }

    let set = new Set(banned);
    let n = paragraph.length;
    let map = new Map();
    let res = null;

    let i = 0;
    while (i < n) {
        if (!isLetter(paragraph[i])) {
            i++;
            continue;
        }

        let j = i;
        while (j < n && isLetter(paragraph[j])) {
            j++;
        }

        let word = paragraph.substring(i, j).toLocaleLowerCase();
        i = j + 1;
        if (set.has(word)) {
            continue;
        }

        map.set(word, (map.get(word) || 0) + 1);
        if (res === null || map.get(res) < map.get(word)) {
            res = word;
        }
    }

    return res;
};
// @lc code=end

