/*
 * @lc app=leetcode.cn id=1346 lang=javascript
 *
 * [1346] 检查整数及其两倍数是否存在
 */

// @lc code=start
/**
 * @param {number[]} arr
 * @return {boolean}
 */
var checkIfExist = function(arr) {
    let cnt = new Array(2001).fill(0);

    for (let n of arr) {
        cnt[n + 1000]++;
    }
    
    for (let n of arr) {
        if (n === 0) {
            if (cnt[1000] >= 2) {
                return true;
            }
        } else {
            if (Math.abs(n) <= 500 && cnt[n * 2 + 1000] !== 0) {
                return true;
            }
        }
    }

    return false;
};
// @lc code=end

