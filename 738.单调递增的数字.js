/*
 * @lc app=leetcode.cn id=738 lang=javascript
 *
 * [738] 单调递增的数字
 */

// @lc code=start
/**
 * @param {number} n
 * @return {number}
 */
var monotoneIncreasingDigits = function(n) {
    
    let arr = (n + "").split('');
    let max = -1, idx = -1;

    for (let i = 0; i < arr.length - 1; i++) {
        if (max < arr[i]) {
            max = arr[i];
            idx = i;
        }
        if (arr[i] > arr[i + 1]) {
            arr[idx] = (arr[idx] - 1).toString();
            for (let j = idx + 1; j < arr.length; j++) {
                arr[j] = '9';
            }
            break;
        }
    }

    return parseInt(arr.join(''), 10);
};
// @lc code=end

