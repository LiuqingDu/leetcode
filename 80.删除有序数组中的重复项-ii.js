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
        // 如果相等
        if (nums[fast] === nums[slow]) {
            // 看慢指针已经存放了多少个相同元素，如果还没有放够两个，则可以继续放
            if (c < 2) {
                // slow指向的是已经存放好的末尾，因此下一个位置需要+1
                slow++;
                nums[slow] = nums[fast];
                fast++;
                c++;
            } else {
                // 如果已经放了2个，则只挪动快指针
                fast++;
            }
        } else {
            // 如果有一个新的元素，则直接放进去，且记录c=1
            slow++;
            nums[slow] = nums[fast];
            fast++;
            c = 1;
        }
    }

    return slow + 1;

};
// @lc code=end

