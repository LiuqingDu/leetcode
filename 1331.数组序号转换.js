/*
 * @lc app=leetcode.cn id=1331 lang=javascript
 *
 * [1331] 数组序号转换
 */

// @lc code=start
/**
 * @param {number[]} arr
 * @return {number[]}
 */
var arrayRankTransform = function(arr) {
    const sortedArr = [...arr]
    sortedArr.sort((a, b) => a - b);
    const ranks = new Map();
    const ans = new Array(arr.length).fill(0);
    for (const a of sortedArr) {
        if (!ranks.has(a)) {
            ranks.set(a, ranks.size + 1);
        }
    }
    for (let i = 0; i < arr.length; i++) {
        ans[i] = ranks.get(arr[i]);
    }
    return ans;
};
// @lc code=end

