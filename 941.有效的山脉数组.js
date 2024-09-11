/*
 * @lc app=leetcode.cn id=941 lang=javascript
 *
 * [941] 有效的山脉数组
 */

// @lc code=start
/**
 * @param {number[]} arr
 * @return {boolean}
 */
var validMountainArray = function(arr) {
    let n = arr.length;
    if (n < 3) {
        return false;
    }

    let l = 0;
    let r = n - 1;
    while (l < n - 1 && arr[l + 1] > arr[l]) {
        l++;
    }
    while (r > 0 && arr[r - 1] > arr[r]) {
        r--;
    }

    return l === r && l !== n - 1 && r !== 0;
};
// @lc code=end

