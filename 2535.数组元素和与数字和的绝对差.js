/*
 * @lc app=leetcode.cn id=2535 lang=javascript
 *
 * [2535] 数组元素和与数字和的绝对差
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var differenceOfSum = function(nums) {
    let elementSum = 0, digitSum = 0;
    for (let num of nums) {
        elementSum += num;
        while (num > 0) {
            digitSum += num % 10;
            num = Math.floor(num / 10);
        }
    }
    return elementSum - digitSum;
};
// @lc code=end

