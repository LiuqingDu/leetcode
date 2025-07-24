/*
 * @lc app=leetcode.cn id=845 lang=javascript
 *
 * [845] 数组中的最长山脉
 */

// @lc code=start
/**
 * @param {number[]} arr
 * @return {number}
 */
var longestMountain = function(arr) {
    const n = arr.length;
    if (n < 3) {
        return 0;
    }
    let maxLength = 0;
    let i = 1;
    // 先找山峰
    // 然后向两边扩展, 看能扩展多长
    // 最后更新最大长度
    // 注意: 山峰的定义是 arr[i] > arr[i - 1] && arr[i] > arr[i + 1]
    // 注意: 山峰的两边必须是严格递增或递减的
    while (i < n - 1) {
        // 寻找山峰
        if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
            let left = i - 1;
            let right = i + 1;

            // 向左扩展
            while (left > 0 && arr[left] > arr[left - 1]) {
                left--;
            }
            // 向右扩展
            while (right < n - 1 && arr[right] > arr[right + 1]) {
                right++;
            }

            // 更新最大长度
            maxLength = Math.max(maxLength, right - left + 1);
            i = right; // 跳过已处理的部分
        } else {
            i++;
        }
    }
    return maxLength;
};
// @lc code=end

