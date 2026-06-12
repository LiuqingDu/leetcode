/*
 * @lc app=leetcode.cn id=1415 lang=javascript
 *
 * [1415] 长度为 n 的开心字符串中字典序第 k 小的字符串
 */

// @lc code=start
/**
 * @param {number} n
 * @param {number} k
 * @return {string}
 */
var getHappyString = function(n, k) {
    
    // 第 1 个字符确定后，后面每个分支的组合数 2^(n-1)
    let groupSize = 1 << (n - 1);
    
    // 如果 k 超过总数 3 * 2^(n-1)，直接返回空字符串
    if (k > 3 * groupSize) {
        return "";
    }
    
    let result = [];
    
    // 1. 确定第一个字符
    if (k <= groupSize) {
        result.push('a');
    } else if (k <= 2 * groupSize) {
        result.push('b');
        k -= groupSize;
    } else {
        result.push('c');
        k -= 2 * groupSize;
    }
    
    // 2. 逐位确定剩下的 n-1 个字符
    for (let i = 1; i < n; i++) {
        groupSize >>= 1; // 剩余位置的每个分支的组合数减半
        
        let prev = result[i - 1];
        // 根据前一个字符，获取当前位置可选的两个字符（按字典序排列）
        let choices = getChoices(prev);
        
        if (k <= groupSize) {
            result.push(choices[0]); // 选字典序较小的
        } else {
            result.push(choices[1]); // 选字典序较大的
            k -= groupSize;
        }
    }
    
    return result.join('');
};

/**
 * 辅助函数：根据当前字符，返回后面可选的两个字符
 * @param {string} prev 
 * @return {string[]}
 */
function getChoices(prev) {
    if (prev === 'a') return ['b', 'c'];
    if (prev === 'b') return ['a', 'c'];
    return ['a', 'b'];
};
// @lc code=end

