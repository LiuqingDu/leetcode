/*
 * @lc app=leetcode.cn id=792 lang=javascript
 *
 * [792] 匹配子序列的单词数
 */

// @lc code=start
/**
 * @param {string} s
 * @param {string[]} words
 * @return {number}
 */
var numMatchingSubseq = function(s, words) {
    
    // 创建 26 个桶，对应 'a' 到 'z'
    const buckets = Array.from({ length: 26 }, () => []);
    
    // 初始化：把所有单词根据首字母扔进对应的桶里
    // 存入的数据格式为：[word, index] -> word: 单词本身, index: 当前匹配到的字符位置
    for (const word of words) {
        const firstCharCode = word.charCodeAt(0) - 97; // 'a' 的 ASCII 码是 97
        buckets[firstCharCode].push([word, 0]);
    }
    
    let count = 0;
    
    // 开始扫描字符串 s
    for (let i = 0; i < s.length; i++) {
        const charCode = s.charCodeAt(i) - 97;
        const currentBucket = buckets[charCode];
        
        // 如果当前桶是空的，直接跳过
        if (currentBucket.length === 0) continue;
        
        // 清空当前桶，因为取出的单词要么匹配完，要么去别的桶，不会留在原地
        buckets[charCode] = [];
        
        for (const [word, index] of currentBucket) {
            const nextIndex = index + 1;
            
            // 如果指针走到了单词末尾，说明整个单词匹配成功
            if (nextIndex === word.length) {
                count++;
            } else {
                // 如果还没走完，看下一个字符是什么，扔进下一个字符的桶里
                const nextCharCode = word.charCodeAt(nextIndex) - 97;
                buckets[nextCharCode].push([word, nextIndex]);
            }
        }
    }
    
    return count;
};
// @lc code=end

