/*
 * @lc app=leetcode.cn id=1400 lang=javascript
 *
 * [1400] 构造 K 个回文字符串
 */

// @lc code=start
/**
 * @param {string} s
 * @param {number} k
 * @return {boolean}
 */
var canConstruct = function(s, k) {
    
    // 边界条件 1：字符总数不够分出 k 个非空字符串
    if (s.length < k) {
        return false;
    }

    const oddSet = new Set();

    // 遍历字符串，利用 Set 切换奇偶状态
    for (const char of s) {
        if (oddSet.has(char)) {
            oddSet.delete(char); // 变成偶数次了，移除
        } else {
            oddSet.add(char);    // 变成奇数次了，加入
        }
    }

    // 边界条件 2：出现奇数次的字符个数不能大于 k
    return oddSet.size <= k;
};
// @lc code=end

