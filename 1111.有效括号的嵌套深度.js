/*
 * @lc app=leetcode.cn id=1111 lang=javascript
 *
 * [1111] 有效括号的嵌套深度
 */

// @lc code=start
/**
 * @param {string} seq
 * @return {number[]}
 */
var maxDepthAfterSplit = function(seq) {
    
    const res = [];
    let depth = 0;

    for (let i = 0; i < seq.length; i++) {
        if (seq[i] === '(') {
            depth++;
            res.push(depth % 2);  // 奇偶分组
        } else {
            res.push(depth % 2);  // 先分配
            depth--;
        }
    }

    return res;
};
// @lc code=end

