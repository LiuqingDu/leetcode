/*
 * @lc app=leetcode.cn id=398 lang=javascript
 *
 * [398] 随机数索引
 */

// @lc code=start
/**
 * @param {number[]} nums
 */
var Solution = function(nums) {

    this.nums = nums;
};

/** 
 * @param {number} target
 * @return {number}
 */
Solution.prototype.pick = function(target) {

    let res;
    let n = 0;
    for (let i = 0; i < this.nums.length; i++) {
        if (this.nums[i] === target) {
            n++;
            if (Math.floor(Math.random() * n) === 0) {
                res = i;
            }
        }
    }

    return res;
};

/**
 * Your Solution object will be instantiated and called as such:
 * var obj = new Solution(nums)
 * var param_1 = obj.pick(target)
 */
// @lc code=end

