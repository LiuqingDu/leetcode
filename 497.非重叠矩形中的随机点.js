/*
 * @lc app=leetcode.cn id=497 lang=javascript
 *
 * [497] 非重叠矩形中的随机点
 */

// @lc code=start
/**
 * @param {number[][]} rects
 */
var Solution = function(rects) {
    this.rectangles = rects;
    this.prefixSums = [];
    this.totalArea = 0;

    for (let i = 0; i < rects.length; i++) {
        const [x1, y1, x2, y2] = rects[i];
        const area = (x2 - x1 + 1) * (y2 - y1 + 1);
        this.totalArea += area;
        this.prefixSums.push(this.totalArea);
    }
};

/**
 * @return {number[]}
 */
Solution.prototype.pick = function() {
    const target = Math.floor(Math.random() * this.totalArea) + 1;
    let left = 0, right = this.rectangles.length - 1;

    while (left < right) {
        const mid = Math.floor((left + right) / 2);
        if (this.prefixSums[mid] >= target) right = mid;
        else left = mid + 1;
    }

    const [x1, y1, x2, y2] = this.rectangles[left];
    const x = Math.floor(Math.random() * (x2 - x1 + 1)) + x1;
    const y = Math.floor(Math.random() * (y2 - y1 + 1)) + y1;

    return [x, y];
};

/** 
 * Your Solution object will be instantiated and called as such:
 * var obj = new Solution(rects)
 * var param_1 = obj.pick()
 */
// @lc code=end

