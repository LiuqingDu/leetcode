/*
 * @lc app=leetcode.cn id=519 lang=javascript
 *
 * [519] 随机翻转矩阵
 */

// @lc code=start
/**
 * @param {number} m
 * @param {number} n
 */
var Solution = function(m, n) {
    this.m = m;
    this.n = n;
    this.cnt = m * n - 1;
    this.map = new Map();
};

/**
 * @return {number[]}
 */
Solution.prototype.flip = function() {
    const x = Math.floor(Math.random() * (this.cnt + 1));
    const ind = this.map.get(x) ?? x;
    this.map.set(x, this.map.get(this.cnt) ?? this.cnt);
    this.cnt--;
    return [Math.floor(ind / this.n), ind % this.n];
};

/**
 * @return {void}
 */
Solution.prototype.reset = function() {
    this.cnt = this.m * this.n - 1;
    this.map.clear();
};

/** 
 * Your Solution object will be instantiated and called as such:
 * var obj = new Solution(m, n)
 * var param_1 = obj.flip()
 * obj.reset()
 */
// @lc code=end

