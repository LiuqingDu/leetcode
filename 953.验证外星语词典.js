/*
 * @lc app=leetcode.cn id=953 lang=javascript
 *
 * [953] 验证外星语词典
 */

// @lc code=start
/**
 * @param {string[]} words
 * @param {string} order
 * @return {boolean}
 */
var isAlienSorted = function(words, order) {
    let ord = [];
    for (let i = 0; i < 26; i++) {
        ord[order.charCodeAt(i) - "a".charCodeAt(0)] = i;
    }

    let check = function(a, b) {
        let m = a.length, n = b.length;
        let i = 0, j = 0;
        while (i < m && j < n) {
            let c1 = a.charCodeAt(i) - "a".charCodeAt(0);
            let c2 = b.charCodeAt(j) - "a".charCodeAt(0);
            if (c1 !== c2) {
                return ord[c1] - ord[c2];
            }
            i++;
            j++;
        }
        if (i < m) {
            return 1;
        }
        if (j < n) {
            return -1;
        }
        return 0;
    }

    let n = words.length;
    for (let i = 1; i < n; i++) {
        if (check(words[i - 1], words[i]) > 0) {
            return false;
        }
    }
    return true;
};
// @lc code=end

