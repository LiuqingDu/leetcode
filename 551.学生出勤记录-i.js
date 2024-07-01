/*
 * @lc app=leetcode.cn id=551 lang=javascript
 *
 * [551] 学生出勤记录 I
 */

// @lc code=start
/**
 * @param {string} s
 * @return {boolean}
 */
var checkRecord = function(s) {
    let lCount = 0;
    let aCount = 0;
    for (let i = 0; i < s.length; i++) {
        if (s[i] === 'A') {
            lCount = 0;
            aCount++;
            if (aCount === 2) {
                return false;
            }
        } else if (s[i] === 'L') {
            lCount++;
            if (lCount === 3) {
                return false;
            }
        } else {
            lCount = 0;
        }
    }
    return true;

};
// @lc code=end

