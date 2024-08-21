/*
 * @lc app=leetcode.cn id=859 lang=javascript
 *
 * [859] 亲密字符串
 */

// @lc code=start
/**
 * @param {string} s
 * @param {string} goal
 * @return {boolean}
 */
var buddyStrings = function(s, goal) {
    let m = s.length;
    let n = goal.length;
    if (m !== n) {
        return false;
    }

    let count1 = new Array(26).fill(0);
    let count2 = new Array(26).fill(0);
    let sum = 0;

    for (let i = 0; i < m; i++) {
        let a = s.charCodeAt(i) - "a".charCodeAt(0);
        let b = goal.charCodeAt(i) - "a".charCodeAt(0);
        count1[a]++;
        count2[b]++;
        if (a !== b) {
            sum++;
        }
    }

    let flag = false;
    for (let i = 0; i < 26; i++) {
        if (count1[i] !== count2[i]) {
            return false;
        }
        if (count1[i] >= 2) {
            flag = true;
        }
    }

    return sum === 2 || (sum === 0 && flag);
};
// @lc code=end

