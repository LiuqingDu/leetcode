/*
 * @lc app=leetcode.cn id=1385 lang=javascript
 *
 * [1385] 两个数组间的距离值
 */

// @lc code=start
/**
 * @param {number[]} arr1
 * @param {number[]} arr2
 * @param {number} d
 * @return {number}
 */
var findTheDistanceValue = function(arr1, arr2, d) {
    arr2.sort((a, b) => a - b); // Fix: sort arr2 for binary search
    let count = 0;
    for (let i = 0; i < arr1.length; i++) {
        let left = 0, right = arr2.length - 1;
        let isValid = true;
        while (left <= right) {
            const mid = left + Math.floor((right - left) / 2);
            if (arr2[mid] >= arr1[i] - d && arr2[mid] <= arr1[i] + d) {
                isValid = false;
                break;
            } else if (arr2[mid] < arr1[i] - d) {
                left = mid + 1;
            } else if (arr2[mid] > arr1[i] + d) {
                right = mid - 1;
            }
        }
        if (isValid) {
            count++;
        }
    }
    return count;
};
// @lc code=end

