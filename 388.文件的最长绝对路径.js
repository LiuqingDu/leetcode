/*
 * @lc app=leetcode.cn id=388 lang=javascript
 *
 * [388] 文件的最长绝对路径
 */

// @lc code=start
/**
 * @param {string} input
 * @return {number}
 */
var lengthLongestPath = function(input) {
    let hash = Array(10000).fill(-1);

    let n = input.length;
    let res = 0;

    for (let i = 0; i < n; i++) {
        let level = 0;

        while (i < n && input[i] === '\t') {
            level++;
            i++;
        }

        let start = i;
        let isDir = true;

        while (i < n && input[i] !== '\n') {
            if (input[i] === '.') {
                isDir = false;
            }
            i++;
        }

        let curLen = i - start;
        let preLen = (level -1 >= 0) ? hash[level - 1] : -1;
        let fullLen = preLen + 1 + curLen;

        if (isDir) {
            hash[level] = fullLen;
        } else {
            res = Math.max(res, fullLen);
        }
    }

    return res;
};
// @lc code=end

