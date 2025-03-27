/*
 * @lc app=leetcode.cn id=1394 lang=javascript
 *
 * [1394] 找出数组中的幸运数
 */

// @lc code=start
/**
 * @param {number[]} arr
 * @return {number}
 */
var findLucky = function(arr) {
    let map = new Array(501).fill(0);
    for (let n of arr) {
        map[n]++;
    }
    for (let i = 500; i > 0; i--) {
        if (map[i] === i) {
            return i;
        }
    }
    return -1;
};
// @lc code=end

