/*
 * @lc app=leetcode.cn id=733 lang=javascript
 *
 * [733] 图像渲染
 */

// @lc code=start
/**
 * @param {number[][]} image
 * @param {number} sr
 * @param {number} sc
 * @param {number} color
 * @return {number[][]}
 */
var floodFill = function(image, sr, sc, color) {

    let fill = function(image, x, y, ori, color) {
        let m = image.length;
        let n = image[0].length;

        if (x >= 0 && x < m && y >=0 && y < n && image[x][y] === ori) {
            image[x][y] = color;
            fill(image, x - 1, y, ori, color);
            fill(image, x, y - 1, ori, color);
            fill(image, x + 1, y, ori, color);
            fill(image, x, y + 1, ori, color);
        }
    }

    let ori = image[sr][sc];

    if (ori === color) {
        return image;
    }

    let m = image.length;
    let n = image[0].length;

    fill(image, sr, sc, ori, color);

    return image;

};
// @lc code=end

