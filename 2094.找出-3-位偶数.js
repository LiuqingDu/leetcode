/*
 * @lc app=leetcode.cn id=2094 lang=javascript
 *
 * [2094] 找出 3 位偶数
 */

// @lc code=start
/**
 * @param {number[]} digits
 * @return {number[]}
 */
var findEvenNumbers = function(digits) {
    const cnt = Array(10).fill(0);
    for (const d of digits) {
        cnt[d]++;
    }

    const ans = [];
    // i=0 百位，i=1 十位，i=2 个位，x 表示当前正在构造的数字
    function dfs(i, x) {
        if (i === 3) {
            ans.push(x);
            return;
        }
        for (let d = 0; d < 10; d++) {
            if (cnt[d] > 0 && (i === 0 && d > 0 || i === 1 || i === 2 && d % 2 === 0)) {
                cnt[d]--; // 消耗一个数字 d
                dfs(i + 1, x * 10 + d);
                cnt[d]++; // 复原
            }
        }
    }
    dfs(0, 0);
    return ans;
};
// @lc code=end

