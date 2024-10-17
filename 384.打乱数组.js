/*
 * @lc app=leetcode.cn id=384 lang=javascript
 *
 * [384] 打乱数组
 */

// @lc code=start
/**
 * @param {number[]} nums
 */
var Solution = function(nums) {
    this.nums = nums;
    this.n = nums.length;
};

/**
 * @return {number[]}
 */
Solution.prototype.reset = function() {
    return this.nums;
};

/**
 * @return {number[]}
 */
Solution.prototype.shuffle = function() {
    let swap = function(arr, i, j) {
        let tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    let res = Array.from(this.nums)
    for (let i = 0; i < this.n; i++) {
        swap(res, i, i + Math.floor(Math.random() * (this.n - i)));
    }
    return res;
};

/**
 * Your Solution object will be instantiated and called as such:
 * var obj = new Solution(nums)
 * var param_1 = obj.reset()
 * var param_2 = obj.shuffle()
 */
// @lc code=end

