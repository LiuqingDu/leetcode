/*
 * @lc app=leetcode.cn id=1461 lang=javascript
 *
 * [1461] 检查一个字符串是否包含所有长度为 K 的二进制子串
 */

// @lc code=start
/**
 * @param {string} s
 * @param {number} k
 * @return {boolean}
 */
var hasAllCodes = function(s, k) {
    
    // 1. 计算长度为 k 的二进制总共有多少种组合 (2的k次方)
    // 1 << k 是位运算，等价于 Math.pow(2, k)
    const totalCombinations = 1 << k;

    // 优化：如果 s 的长度连凑齐所有组合的最低要求都不够，直接返回 false
    if (s.length - k + 1 < totalCombinations) {
        return false;
    }

    // 2. 创建一个 Set 来存出现过的子串（Set 会自动去重）
    const seen = new Set();

    // 3. 遍历字符串，用滑动窗口切出所有长度为 k 的子串
    for (let i = 0; i <= s.length - k; i++) {
        // substring(i, i + k) 切出长度为 k 的子串
        const sub = s.substring(i, i + k);
        seen.add(sub);

        // 提前释放：如果已经凑齐了所有组合，直接返回 true
        if (seen.size === totalCombinations) {
            return true;
        }
    }

    // 4. 遍历结束，看最终数量是否达标
    return seen.size === totalCombinations;
};
// @lc code=end

