/*
 * @lc app=leetcode.cn id=832 lang=javascript
 *
 * [832] 翻转图像
 */

// @lc code=start
/**
 * @param {number[][]} image
 * @return {number[][]}
 */
var flipAndInvertImage = function(image) {
    let m = image.length;
    let n = image[0].length;

    for (let i = 0; i < m; i++) {
        for (let j = 0; j <= Math.floor((n - 1) / 2); j++) {
            let tmp = image[i][j];
            image[i][j] = (image[i][n - 1 - j] + 1) % 2;
            image[i][n - 1 - j] = (tmp + 1) % 2;
        }
    }
    return image;
};
// @lc code=end

