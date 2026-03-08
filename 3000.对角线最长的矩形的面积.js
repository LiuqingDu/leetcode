/*
 * @lc app=leetcode.cn id=3000 lang=javascript
 *
 * [3000] 对角线最长的矩形的面积
 */

// @lc code=start
/**
 * @param {number[][]} dimensions
 * @return {number}
 */
var areaOfMaxDiagonal = function(dimensions) {
    
    let len = 0;
    let area = 0;

    for (let i = 0; i < dimensions.length; i++) {
        const x = dimensions[i][0];
        const y = dimensions[i][1];

        const l = x * x + y * y;  // 对角线平方
        const a = x * y;          // 面积

        if (l > len || (l === len && a > area)) {
            len = l;
            area = a;
        }
    }

    return area;
};
// @lc code=end

