/*
 * @lc app=leetcode.cn id=438 lang=javascript
 *
 * [438] 找到字符串中所有字母异位词
 */

// @lc code=start
/**
 * @param {string} s
 * @param {string} p
 * @return {number[]}
 */
var findAnagrams = function(s, p) {
    let sL = s.length, pL = p.length;
    if (sL < pL) {
        return [];
    }

    let pMap = new Map();
    let windowMap = new Map();
    let valid = 0;
    let res = [];
    let left = 0, right = 0;

    for (let i = 0; i < p.length; i++) {
        let c = p.charAt(i);
        pMap.set(c, (pMap.get(c) || 0) + 1);
    }

    while(right < sL) {
        let c = s.charAt(right);

        if (pMap.has(c)) {
            windowMap.set(c, (windowMap.get(c) || 0) + 1);
            if (windowMap.get(c) === pMap.get(c)) {
                valid++;
            }
        }

        if (right + 1 - left === pL) {
            if (valid === pMap.size) {
                res.push(left);
            }

            let c = s.charAt(left);
            if (pMap.has(c)) {
                if (windowMap.get(c) === pMap.get(c)) {
                    valid--;
                }
                windowMap.set(c, windowMap.get(c) - 1);
            }

            left++;
        }

        right++;
    }

    return res;

};
// @lc code=end

