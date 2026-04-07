/*
 * @lc app=leetcode.cn id=1049 lang=javascript
 *
 * [1049] 最后一块石头的重量 II
 */

// @lc code=start
/**
 * @param {number[]} stones
 * @return {number}
 */
var lastStoneWeightII = function(stones) {
    const sum = stones.reduce((pre, cur) => pre + cur, 0);
    const n = stones.length;
    const m = Math.floor(sum / 2);

    // 使用一维 dp 数组，节省空间
    // dp[j] 表示是否能凑出重量为 j 的石头组合
    const dp = new Array(m + 1).fill(false);
    dp[0] = true;

    for (const stone of stones) {
        // 必须从后往前遍历，防止重复计算同一个石头
        for (let j = m; j >= stone; j--) {
            if (dp[j - stone]) {
                dp[j] = true;
            }
        }
    }

    // 从 m 开始倒序查找最大的可行重量 j
    for (let j = m; j >= 0; j--) {
        if (dp[j]) {
            // 两堆重量分别为 j 和 sum - j
            // 差值为 (sum - j) - j = sum - 2 * j
            return sum - 2 * j;
        }
    }
};
// @lc code=end

