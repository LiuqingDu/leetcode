/*
 * @lc app=leetcode.cn id=1287 lang=javascript
 *
 * [1287] 有序数组中出现次数超过25%的元素
 */

// @lc code=start
/**
 * @param {number[]} arr
 * @return {number}
 */
var findSpecialInteger = function(arr) {
    let n = arr.length;
    let cur = arr[0], cnt = 0;
    for (let i = 0; i < n; ++i) {
        if (arr[i] === cur) {
            ++cnt;
            if (cnt * 4 > n) {
                return cur;
            }
        } else {
            cur = arr[i];
            cnt = 1;
        }
    }
    return -1;
};
// @lc code=end

