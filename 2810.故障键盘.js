/*
 * @lc app=leetcode.cn id=2810 lang=javascript
 *
 * [2810] 故障键盘
 */

// @lc code=start
/**
 * @param {string} s
 * @return {string}
 */
var finalString = function(s) {
    let q = [];
    let head = false;
    for (let ch of s) {
        if (ch !== 'i') {
            if (head) {
                q.unshift(ch);
            } else {
                q.push(ch);
            }
        } else {
            head = !head;
        }
    }
    let ans = head ? q.reverse().join('') : q.join('');
    return ans;
};
// @lc code=end

