/*
 * @lc app=leetcode.cn id=2399 lang=javascript
 *
 * [2399] 检查相同字母间的距离
 */

// @lc code=start
/**
 * @param {string} s
 * @param {number[]} distance
 * @return {boolean}
 */
var checkDistances = function(s, distance) {
    const firstOccurrence = new Array(26).fill(-1);

    for (let i = 0; i < s.length; i++) {
        const charIndex = s.charCodeAt(i) - 'a'.charCodeAt(0);
        if (firstOccurrence[charIndex] === -1) {
            firstOccurrence[charIndex] = i;
        } else {
            const expectedDistance = distance[charIndex];
            const actualDistance = i - firstOccurrence[charIndex] - 1;
            if (expectedDistance !== actualDistance) {
                return false;
            }
        }
    }

    return true;
};
// @lc code=end

