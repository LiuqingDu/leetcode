/*
 * @lc app=leetcode.cn id=835 lang=javascript
 *
 * [835] 图像重叠
 */

// @lc code=start
/**
 * @param {number[][]} img1
 * @param {number[][]} img2
 * @return {number}
 */
var largestOverlap = function(img1, img2) {
    
    const n = img1.length;
    let maxOverlap = 0;

    // 1. 枚举 img2 相对于 img1 的所有平移可能
    // rowShift (纵向位移) 和 colShift (横向位移) 的范围都是 [-(n-1), n-1]
    for (let rowShift = -(n - 1); rowShift < n; rowShift++) {
        for (let colShift = -(n - 1); colShift < n; colShift++) {
            
            // 2. 计算当前平移量下的重叠数
            let currentOverlap = countOverlap(img1, img2, rowShift, colShift, n);
            
            // 3. 更新最大值
            maxOverlap = Math.max(maxOverlap, currentOverlap);
        }
    }

    return maxOverlap;
};

// 辅助函数：计算在特定偏移量下，两个图像重叠的 1 的数量
function countOverlap(img1, img2, rowShift, colShift, n) {
    let count = 0;

    // 遍历 img1 的每一个坐标 (r, c)
    for (let r = 0; r < n; r++) {
        for (let c = 0; c < n; c++) {
            // 根据相对位移，算出对应的 img2 的坐标
            let img2R = r + rowShift;
            let img2C = c + colShift;

            // 检查 img2 的坐标是否在合法的矩阵边界内
            if (img2R >= 0 && img2R < n && img2C >= 0 && img2C < n) {
                // 如果 img1 和 img2 在该重叠位置都是 1
                if (img1[r][c] === 1 && img2[img2R][img2C] === 1) {
                    count++;
                }
            }
        }
    }
    
    return count;
};
// @lc code=end

