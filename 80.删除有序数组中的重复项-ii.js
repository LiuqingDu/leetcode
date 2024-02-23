/*
 * @lc app=leetcode.cn id=80 lang=javascript
 *
 * [80] 删除有序数组中的重复项 II
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var removeDuplicates = function(nums) {
    // 快慢指针，从0和1开始比较
    let slow = 0;
    let fast = 1;
    // 记录之前已经有几个相同元素了
    // 默认初始状态就是nums[0]已经算是有一个了
    let c = 1;
    let n = nums.length;

    while (fast < n) {
        if (nums[fast] === nums[slow]) {
            if (c < 2) {
                slow++;
                nums[slow] = nums[fast];
                fast++;
                c++;
            } else {
                fast++;
            }
        } else {
            c = 1;
            slow++;
            nums[slow] = nums[fast];
            fast++;
        }
    }

    return slow + 1;

};
// @lc code=end

