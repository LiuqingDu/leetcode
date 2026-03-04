/*
 * @lc app=leetcode.cn id=1451 lang=javascript
 *
 * [1451] 重新排列句子中的单词
 */

// @lc code=start
/**
 * @param {string} text
 * @return {string}
 */
var arrangeWords = function(text) {
    // 1. 全部转小写
    text = text.toLowerCase();
    
    // 2. 分割成数组
    let words = text.split(" ");
    
    // 3. 按长度升序排序
    words.sort((a, b) => a.length - b.length);
    
    // 4. 拼接
    let result = words.join(" ");
    
    // 5. 首字母大写
    result = result.charAt(0).toUpperCase() + result.slice(1);
    
    return result;
};
// @lc code=end

