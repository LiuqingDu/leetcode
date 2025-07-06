/*
 * @lc app=leetcode.cn id=833 lang=javascript
 *
 * [833] 字符串中的查找与替换
 */

// @lc code=start
/**
 * @param {string} s
 * @param {number[]} indices
 * @param {string[]} sources
 * @param {string[]} targets
 * @return {string}
 */
var findReplaceString = function(s, indices, sources, targets) {
    
    const n = s.length;
    let replaceStr = Array(n);
    let replaceLen = Array(n).fill(1); // 无需替换时 i+=1
    for (let i = 0; i < indices.length; i++) {
        const idx = indices[i];
        if (s.startsWith(sources[i], idx)) { // 这样写不需要 s.slice
            replaceStr[idx] = targets[i]; // 替换后的字符串
            replaceLen[idx] = sources[i].length; // 被替换的长度
        }
    }

    let ans = [];
    for (let i = 0; i < n; i += replaceLen[i]) // 无需替换时 i+=1
        ans.push(replaceStr[i] ? replaceStr[i] : s.charAt(i));
    return ans.join("");
};
// @lc code=end

