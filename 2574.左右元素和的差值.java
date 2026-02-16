/*
 * @lc app=leetcode.cn id=2574 lang=java
 *
 * [2574] 左右元素和的差值
 */

// @lc code=start
class Solution {
    public int[] leftRightDifference(int[] nums) {
        
        int n = nums.length;
        int[] answer = new int[n];
        
        // 1. 计算总和
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        
        // 2. 遍历计算左右差值
        int leftSum = 0;
        for (int i = 0; i < n; i++) {
            int rightSum = total - leftSum - nums[i];
            answer[i] = Math.abs(leftSum - rightSum);
            leftSum += nums[i];
        }
        
        return answer;
    }
}
// @lc code=end

