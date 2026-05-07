/*
 * @lc app=leetcode.cn id=1324 lang=javascript
 *
 * [1324] 竖直打印单词
 */

// @lc code=start
/**
 * @param {string} s
 * @return {string[]}
 */
var printVertically = function(s) {
    const words = s.split(" ");
    
    // 找最长单词长度
    let maxLen = 0;
    for (let w of words) {
        maxLen = Math.max(maxLen, w.length);
    }

    const res = [];

    // 按列遍历
    for (let i = 0; i < maxLen; i++) {
        let line = "";

        for (let w of words) {
            if (i < w.length) {
                line += w[i];
            } else {
                line += " ";
            }
        }

        // 去掉尾部空格
        res.push(line.replace(/\s+$/, ""));
    }

    return res;
};
// @lc code=end

