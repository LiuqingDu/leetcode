/*
 * @lc app=leetcode.cn id=165 lang=javascript
 *
 * [165] 比较版本号
 */

// @lc code=start
/**
 * @param {string} version1
 * @param {string} version2
 * @return {number}
 */
var compareVersion = function(version1, version2) {

    let ver1 = version1.split(".");
    let ver2 = version2.split(".");

    let n1 = ver1.length;
    let n2 = ver2.length;

    let i1 = 0;
    let i2 = 0;

    while (i1 < n1 || i2 < n2) {
        let a = 0;
        let b = 0;
        if (i1 < n1) {
            a = parseInt(ver1[i1]);
            i1++;
        }
        if (i2 < n2) {
            b = parseInt(ver2[i2]);
            i2++;
        }
        if (a < b) {
            return -1;
        }
        if (a > b) {
            return 1;
        }
    }

    return 0;

};
// @lc code=end

