/*
 * @lc app=leetcode.cn id=528 lang=javascript
 *
 * [528] 按权重随机选择
 */

// @lc code=start
/**
 * @param {number[]} w
 */
var Solution = function(w) {
    this.pre = new Array(w.length).fill(0);
    this.pre[0] = w[0];
    this.total = w[0];
    for (let i = 1; i < w.length; ++i) {
        this.pre[i] = this.pre[i - 1] + w[i];
        this.total += w[i];
    }
};

/**
 * @return {number}
 */
Solution.prototype.pickIndex = function() {
    const x = Math.floor((Math.random() * this.total)) + 1;
    const binarySearch = (x) => {
        let low = 0, high = this.pre.length - 1;
        while (low < high) {
            const mid = Math.floor((high - low) / 2) + low;
            if (this.pre[mid] < x) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
    return binarySearch(x);
};

/** 
 * Your Solution object will be instantiated and called as such:
 * var obj = new Solution(w)
 * var param_1 = obj.pickIndex()
 */
// @lc code=end

