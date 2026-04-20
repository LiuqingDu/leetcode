/*
 * @lc app=leetcode.cn id=3042 lang=javascript
 *
 * [3042] 统计前后缀下标对 I
 */

// @lc code=start
/**
 * @param {string[]} words
 * @return {number}
 */
var countPrefixSuffixPairs = function(words) {
    
    function isPrefixAndSuffix(str1, str2) {
        // JavaScript 的 String.prototype 方法：
        // startsWith(searchString) 检查是否以指定字符串开头
        // endsWith(searchString) 检查是否以指定字符串结尾
        return str2.startsWith(str1) && str2.endsWith(str1);
    }

    let count = 0;
    const n = words.length;

    // 严格遵守 i < j 的约束
    for (let i = 0; i < n; i++) {
        for (let j = i + 1; j < n; j++) {
            // 直接调用布尔逻辑判断
            if (isPrefixAndSuffix(words[i], words[j])) {
                count++;
            }
        }
    }

    return count;
};
// @lc code=end

