/*
 * @lc app=leetcode.cn id=6 lang=javascript
 *
 * [6] Z 字形变换
 */

// @lc code=start
/**
 * @param {string} s
 * @param {number} numRows
 * @return {string}
 */
var convert = function(s, numRows) {

    if (numRows === 1) {
        return s;
    }

    let arr = Array.from(Array(numRows), () => []);
    let n = s.length;
    let direction = -1;
    let pos = 0;

    for (let i = 0; i < n; i++) {
        let c = s.charAt(i);
        arr[pos].push(c);
        if (pos === 0 || pos === numRows - 1) {
            direction *= -1;
        }
        pos += direction;
    }

    return arr.reduce((pre, cur) => pre + cur.join(""), "");

};
// @lc code=end

