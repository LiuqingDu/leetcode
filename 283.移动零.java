/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        // 双指针，把非零数值填充到前面，剩下的填充0
        int slow = 0, fast = 0, n = nums.length;

        while(fast < n) {
            if (nums[fast] != 0) {
                nums[slow++] = nums[fast++];
            } else {
                fast++;
            }
        }
        while(slow < n) {
            nums[slow++] = 0;
        }
    }
}
// @lc code=end

