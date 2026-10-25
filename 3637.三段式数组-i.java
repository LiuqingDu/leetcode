/*
 * @lc app=leetcode.cn id=3637 lang=java
 *
 * [3637] 三段式数组 I
 */

// @lc code=start
class Solution {
    public boolean isTrionic(int[] nums) {
        
        int n = nums.length;
        int i = 1;
        while (i < n && nums[i - 1] < nums[i]) {
            i++;
        }
        int p = i - 1;
        while (i < n && nums[i - 1] > nums[i]) {
            i++;
        }
        int q = i - 1;
        while (i < n && nums[i - 1] < nums[i]) {
            i++;
        }
        int flag = i - 1;
        return (p != 0) && (q != p) && (flag == n - 1 && flag != q);

    }
}
// @lc code=end

