/*
 * @lc app=leetcode.cn id=3038 lang=java
 *
 * [3038] 相同分数的最大操作数目 I
 */

// @lc code=start
class Solution {
    public int maxOperations(int[] nums) {
        
        int n = nums.length;
        
        // 第一次操作的分数
        int target = nums[0] + nums[1];
        
        int count = 1; // 至少能做一次
        
        // 从第2个元素开始，每两个一组
        for (int i = 2; i + 1 < n; i += 2) {
            if (nums[i] + nums[i + 1] == target) {
                count++;
            } else {
                break;
            }
        }
        
        return count;
    }
}
// @lc code=end

