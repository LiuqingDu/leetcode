/*
 * @lc app=leetcode.cn id=3861 lang=javascript
 *
 * [3861] 容量最小的箱子
 */

// @lc code=start
/**
 * @param {number[]} capacity
 * @param {number} itemSize
 * @return {number}
 */
var minimumIndex = function(capacity, itemSize) {
    let min = Number.MAX_SAFE_INTEGER;
    let ind = -1;
    for (let i = 0; i < capacity.length; i++) {
        if (capacity[i] >= itemSize && capacity[i] < min) {
            min = capacity[i];
            ind = i;
        }
    }
    return ind;
};
// @lc code=end

