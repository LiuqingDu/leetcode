/*
 * @lc app=leetcode.cn id=3074 lang=javascript
 *
 * [3074] 重新分装苹果
 */

// @lc code=start
/**
 * @param {number[]} apple
 * @param {number[]} capacity
 * @return {number}
 */
var minimumBoxes = function(apple, capacity) {
    // 1. 计算苹果总数
    let sum = apple.reduce((a, b) => a + b, 0);

    // 2. 按容量从大到小排序
    capacity.sort((a, b) => b - a);

    // 3. 贪心选择
    let total = 0;
    let count = 0;

    for (let cap of capacity) {
        total += cap;
        count++;

        if (total >= sum) {
            return count;
        }
    }

    return count; // 题目保证有解
};
// @lc code=end

