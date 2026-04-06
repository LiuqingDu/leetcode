/*
 * @lc app=leetcode.cn id=1048 lang=javascript
 *
 * [1048] 最长字符串链
 */

// @lc code=start
/**
 * @param {string[]} words
 * @return {number}
 */
var longestStrChain = function(words) {
    
    // 1. 按长度排序
    words.sort((a, b) => a.length - b.length);

    const dp = new Map();
    let res = 1;

    for (let word of words) {
        let max = 1;

        // 2. 枚举删除一个字符
        for (let i = 0; i < word.length; i++) {
            let prev = word.slice(0, i) + word.slice(i + 1);

            if (dp.has(prev)) {
                max = Math.max(max, dp.get(prev) + 1);
            }
        }

        dp.set(word, max);
        res = Math.max(res, max);
    }

    return res;
};
// @lc code=end

