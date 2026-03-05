/*
 * @lc app=leetcode.cn id=2974 lang=java
 *
 * [2974] 最小数字游戏
 */

// @lc code=start
class Solution {
    public int[] numberGame(int[] nums) {
        Arrays.sort(nums);   // 先排序
        
        int[] arr = new int[nums.length];
        
        for (int i = 0; i < nums.length; i += 2) {
            arr[i] = nums[i + 1];
            arr[i + 1] = nums[i];
        }
        
        return arr;
    }
}
// @lc code=end

