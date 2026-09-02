/*
 * @lc app=leetcode.cn id=1247 lang=javascript
 *
 * [1247] 交换字符使得字符串相同
 */

// @lc code=start
/**
 * @param {string} s1
 * @param {string} s2
 * @return {number}
 */
var minimumSwap = function(s1, s2) {
    
    let xy = 0, yx = 0;
    const n = s1.length;
    for (let i = 0; i < n; i++) {
        const a = s1[i], b = s2[i];
        if (a === 'x' && b === 'y') {
            xy++;
        }
        if (a === 'y' && b === 'x') {
            yx++;
        }
    }
    if ((xy + yx) % 2 === 1) {
        return -1;
    }
    return Math.floor(xy / 2) + Math.floor(yx / 2) + xy % 2 + yx % 2;

};
// @lc code=end

