/*
 * @lc app=leetcode.cn id=1343 lang=javascript
 *
 * [1343] 大小为 K 且平均值大于等于阈值的子数组数目
 */

// @lc code=start
/**
 * @param {number[]} arr
 * @param {number} k
 * @param {number} threshold
 * @return {number}
 */
var numOfSubarrays = function(arr, k, threshold) {
    // 平均值 >= threshold
    // 等价于：
    // 子数组和 >= threshold * k

    let target = threshold * k;
    let sum = 0;
    let count = 0;

    // 先计算第一个窗口的和
    for (let i = 0; i < k; i++) {
        sum += arr[i];
    }

    // 判断第一个窗口
    if (sum >= target) {
        count++;
    }

    // 滑动窗口
    for (let i = k; i < arr.length; i++) {

        // 加入右边元素
        sum += arr[i];

        // 移除左边元素
        sum -= arr[i - k];

        // 判断当前窗口
        if (sum >= target) {
            count++;
        }
    }

    return count;
};
// @lc code=end

