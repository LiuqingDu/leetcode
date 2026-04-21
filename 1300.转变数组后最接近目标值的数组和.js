/*
 * @lc app=leetcode.cn id=1300 lang=javascript
 *
 * [1300] 转变数组后最接近目标值的数组和
 */

// @lc code=start
/**
 * @param {number[]} arr
 * @param {number} target
 * @return {number}
 */
var findBestValue = function(arr, target) {
    arr.sort((a, b) => a - b);

    let n = arr.length;
    let left = 0;
    let right = arr[n - 1];

    let ans = 0;
    let bestDiff = Infinity;

    function getSum(value) {
        let sum = 0;
        for (let x of arr) {
            sum += Math.min(x, value);
        }
        return sum;
    }

    while (left <= right) {
        let mid = Math.floor((left + right) / 2);
        let sum = getSum(mid);

        let diff = Math.abs(sum - target);

        if (diff < bestDiff || (diff === bestDiff && mid < ans)) {
            bestDiff = diff;
            ans = mid;
        }

        if (sum < target) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }

    return ans;
};
// @lc code=end

