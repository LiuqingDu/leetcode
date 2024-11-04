/*
 * @lc app=leetcode.cn id=443 lang=javascript
 *
 * [443] 压缩字符串
 */

// @lc code=start
/**
 * @param {character[]} chars
 * @return {number}
 */
var compress = function(chars) {
    let write = 0;
    let n = chars.length;

    for (let i = 0; i < n;) {
        let j = i;
        while (j < n && chars[i] === chars[j]) {
            j++;
        }
        chars[write] = chars[i];
        write++;
        if (j - i > 1) {
            let count = (j - i).toString();
            for (let k = 0; k < count.length; k++) {
                chars[write] = count[k];
                write++;
            }
        }
        i = j;
    }

    return write;
};
// @lc code=end

