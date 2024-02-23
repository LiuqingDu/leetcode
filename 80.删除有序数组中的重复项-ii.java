/*
 * @lc app=leetcode.cn id=80 lang=java
 *
 * [80] 删除有序数组中的重复项 II
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int slow = 0;
        int fast = 1;
        int c = 1;

        while (fast < n) {
            if (nums[slow] == nums[fast]) {
                if (c < 2) {
                    nums[++slow] = nums[fast++];
                    c++;
                } else {
                    fast++;
                }
            } else {
                nums[++slow] = nums[fast++];
                c = 1;
            }
        }

        return slow + 1;

    }
}
// @lc code=end

