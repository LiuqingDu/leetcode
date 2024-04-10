/*
 * @lc app=leetcode.cn id=307 lang=javascript
 *
 * [307] 区域和检索 - 数组可修改
 */

// @lc code=start
/**
 * @param {number[]} nums
 */
var NumArray = function(nums) {

    let n = nums.length;
    this.a = new Array(n).fill(0);
    this.b = new Array(n + 1).fill(0);
    for (let i = 0; i < n; i++) {
        this.update(i, nums[i]);
    }
};

/** 
 * @param {number} index 
 * @param {number} val
 * @return {void}
 */
NumArray.prototype.update = function(index, val) {

    let dif = val - this.a[index];
    this.a[index] = val;
    let p = index + 1;
    while (p < this.b.length) {
        this.b[p] += dif;
        p = p + this.lowBit(p);
    }
};

/** 
 * @param {number} left 
 * @param {number} right
 * @return {number}
 */
NumArray.prototype.sumRange = function(left, right) {

    return this.prefixSum(right) - this.prefixSum(left - 1);
};

NumArray.prototype.prefixSum = function(index) {
    let sum = 0;
    let p = index + 1;
    while (p > 0) {
        sum += this.b[p];
        p = p - this.lowBit(p);
    }
    return sum;
}

NumArray.prototype.lowBit = function(x) {
    return x & (-x);
}

/**
 * Your NumArray object will be instantiated and called as such:
 * var obj = new NumArray(nums)
 * obj.update(index,val)
 * var param_2 = obj.sumRange(left,right)
 */
// @lc code=end

