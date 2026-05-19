/*
 * @lc app=leetcode.cn id=1371 lang=javascript
 *
 * [1371] 每个元音包含偶数次的最长子字符串
 */

// @lc code=start
/**
 * @param {string} s
 * @return {number}
 */
var findTheLongestSubstring = function(s) {
    // 记录每个状态第一次出现的位置
    const map = new Map();
    
    let state = 0;   // 5位状态压缩
    let res = 0;
    
    map.set(0, -1);  // 初始状态

    for (let i = 0; i < s.length; i++) {
        const c = s[i];

        // 更新5个元音的奇偶状态（用异或切换）
        if (c === 'a') state ^= (1 << 0);
        else if (c === 'e') state ^= (1 << 1);
        else if (c === 'i') state ^= (1 << 2);
        else if (c === 'o') state ^= (1 << 3);
        else if (c === 'u') state ^= (1 << 4);

        // 如果这个状态之前出现过
        if (map.has(state)) {
            res = Math.max(res, i - map.get(state));
        } else {
            map.set(state, i);
        }
    }

    return res;
};
// @lc code=end

