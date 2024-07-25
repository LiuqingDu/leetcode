/*
 * @lc app=leetcode.cn id=682 lang=javascript
 *
 * [682] 棒球比赛
 */

// @lc code=start
/**
 * @param {string[]} operations
 * @return {number}
 */
var calPoints = function(operations) {
    let arr = new Array(1000).fill(0);
    let index = 0;
    for (let op of operations) {
        switch (op) {
            case "C":
                index--;
                arr[index] = 0;
                break;
            case "D":
                arr[index] = arr[index - 1] * 2;
                index++;
                break;
            case "+":
                arr[index] = arr[index - 2] + arr[index - 1];
                index++;
                break;
            default:
                arr[index] = parseInt(op);
                index++;
                break;
        }
    }
    return arr.reduce((a, b) => a + b);

};
// @lc code=end

