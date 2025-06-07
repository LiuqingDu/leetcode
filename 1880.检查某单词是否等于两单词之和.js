/*
 * @lc app=leetcode.cn id=1880 lang=javascript
 *
 * [1880] 检查某单词是否等于两单词之和
 */

// @lc code=start
/**
 * @param {string} firstWord
 * @param {string} secondWord
 * @param {string} targetWord
 * @return {boolean}
 */
var isSumEqual = function(firstWord, secondWord, targetWord) {
    let wordToNumber = function(word) {
        let num = 0;
        for (let i = 0; i < word.length; i++) {
            let digit = word.charCodeAt(i) - 'a'.charCodeAt(0); // 字符转数字
            num = num * 10 + digit;
        }
        return num;
    }

    const num1 = wordToNumber(firstWord);
    const num2 = wordToNumber(secondWord);
    const target = wordToNumber(targetWord);
    
    return num1 + num2 === target;
};
// @lc code=end

