/*
 * @lc app=leetcode.cn id=1296 lang=javascript
 *
 * [1296] 划分数组为连续数字的集合
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @param {number} k
 * @return {boolean}
 */
var isPossibleDivide = function(nums, k) {

    // 1. 长度必须能整除
    if (nums.length % k !== 0) return false;

    // 2. 统计频率
    const count = new Map();
    for (const num of nums) {
        count.set(num, (count.get(num) || 0) + 1);
    }

    // 3. 排序
    nums.sort((a, b) => a - b);

    // 4. 贪心构造
    for (const num of nums) {
        if (count.get(num) === 0) continue;
        // 从 num 开始构造 k 个连续数
        for (let i = 0; i < k; i++) {
            const cur = num + i;
            if (!count.get(cur)) {
                return false;
            }
            count.set(cur, count.get(cur) - 1);
        }
    }

    return true;
};
// @lc code=end

