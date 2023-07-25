/*
 * @lc app=leetcode.cn id=27 lang=java
 *
 * [27] 移除元素
 */

// @lc code=start
class Solution {
    public int removeElement(int[] nums, int val) {
        int slow = 0, fast = 0, n = nums.length;

        // 慢指针指向可填充位置
        // 快指针指向待填充的值
        // 如果值不相等则填充
        while(fast < n) {
            if (nums[fast] == val) {
                fast++;
            } else {
                nums[slow] = nums[fast];
                slow++;
                fast++;
            }
        }
        return slow;
    }
}
// @lc code=end

