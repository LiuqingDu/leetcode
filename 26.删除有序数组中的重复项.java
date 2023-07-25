/*
 * @lc app=leetcode.cn id=26 lang=java
 *
 * [26] 删除有序数组中的重复项
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        int slow = 0;
        int fast = 1;
        int n = nums.length;

        while(fast < n) {
            // 如果右指针等于左指针，右指针继续向右
            if (nums[slow] == nums[fast]) {
                fast++;
            } else {
                // 如果右指针不等于左指针，将右指针的内容放到左指针下一个位置
                slow++;
                nums[slow] = nums[fast];
                fast++;
            }
        }
        return slow + 1;
    }
}
// @lc code=end

