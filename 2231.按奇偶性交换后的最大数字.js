/*
 * @lc app=leetcode.cn id=2231 lang=javascript
 *
 * [2231] 按奇偶性交换后的最大数字
 */

// @lc code=start
/**
 * @param {number} num
 * @return {number}
 */
var largestInteger = function(num) {
    let s = num.toString().split("");  // 转为字符数组
    let n = s.length;

    // 选择排序
    for (let i = 0; i < n - 1; i++) {
        for (let j = i + 1; j < n; j++) {
            // 只有奇偶相同才交换
            if ((parseInt(s[i]) - parseInt(s[j])) % 2 === 0 && s[i] < s[j]) {
                [s[i], s[j]] = [s[j], s[i]];
            }
        }
    }

    return parseInt(s.join(""), 10);
};
// @lc code=end

