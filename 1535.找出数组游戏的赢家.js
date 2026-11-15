/*
 * @lc app=leetcode.cn id=1535 lang=javascript
 *
 * [1535] 找出数组游戏的赢家
 */

// @lc code=start
/**
 * @param {number[]} arr
 * @param {number} k
 * @return {number}
 */
var getWinner = function(arr, k) {
    
    let prev = Math.max(arr[0], arr[1]);
    if (k === 1) {
        return prev;
    }
    let consecutive = 1;
    let maxNum = prev;
    for (let i = 2; i < arr.length; i++) {
        let curr = arr[i];
        if (prev > curr) {
            consecutive++;
            if (consecutive === k) {
                return prev;
            }
        } else {
            prev = curr;
            consecutive = 1;
        }
        maxNum = Math.max(maxNum, curr);
    }
    return maxNum;

};
// @lc code=end

