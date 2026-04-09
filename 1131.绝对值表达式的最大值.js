/*
 * @lc app=leetcode.cn id=1131 lang=javascript
 *
 * [1131] 绝对值表达式的最大值
 */

// @lc code=start
/**
 * @param {number[]} arr1
 * @param {number[]} arr2
 * @return {number}
 */
var maxAbsValExpr = function(arr1, arr2) {
    
    const n = arr1.length;
    let res = 0;

    // 四种情况（符号组合）
    const dirs = [
        [1, 1],
        [1, -1],
        [-1, 1],
        [-1, -1]
    ];

    for (const [a, b] of dirs) {
        let max = -Infinity;
        let min = Infinity;

        for (let i = 0; i < n; i++) {
            const val = a * arr1[i] + b * arr2[i] + i;
            max = Math.max(max, val);
            min = Math.min(min, val);
        }

        res = Math.max(res, max - min);
    }

    return res;
};
// @lc code=end

