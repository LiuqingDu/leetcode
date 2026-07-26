/*
 * @lc app=leetcode.cn id=1455 lang=javascript
 *
 * [1455] 检查单词是否为句中其他单词的前缀
 */

// @lc code=start
/**
 * @param {string} sentence
 * @param {string} searchWord
 * @return {number}
 */
var isPrefixOfWord = function(sentence, searchWord) {
    
    let n = sentence.length, index = 1, start = 0, end = 0;
    while (start < n) {
        while (end < n && sentence[end] !== ' ') {
            end++;
        }
        if (isPrefix(sentence, start, end, searchWord)) {
            return index;
        }

        index++;
        end++;
        start = end;
    }
    return -1;
}

const isPrefix = (sentence, start, end, searchWord) => {
    for (let i = 0; i < searchWord.length; i++) {
        if (start + i >= end || sentence[start + i] !== searchWord[i]) {
            return false;
        }
    }
    return true;
};

// @lc code=end

