/*
 * @lc app=leetcode.cn id=2937 lang=javascript
 *
 * [2937] 使三个字符串相等
 */

// @lc code=start
/**
 * @param {string} s1
 * @param {string} s2
 * @param {string} s3
 * @return {number}
 */
var findMinimumOperations = function(s1, s2, s3) {
    // 找最短字符串长度
    let minLen = Math.min(s1.length, s2.length, s3.length);
    
    let prefixLen = 0;
    
    // 计算最长公共前缀
    for (let i = 0; i < minLen; i++) {
        if (s1[i] === s2[i] && s2[i] === s3[i]) {
            prefixLen++;
        } else {
            break;
        }
    }
    
    // 如果没有公共前缀
    if (prefixLen === 0) {
        return -1;
    }
    
    // 返回总删除次数
    return (s1.length - prefixLen) +
           (s2.length - prefixLen) +
           (s3.length - prefixLen);
};
// @lc code=end

