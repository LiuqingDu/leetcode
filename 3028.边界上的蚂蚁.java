/*
 * @lc app=leetcode.cn id=3028 lang=java
 *
 * [3028] 边界上的蚂蚁
 */

// @lc code=start
class Solution {
    public int returnToBoundaryCount(int[] nums) {
        
        int position = 0; // 当前坐标
        int count = 0;    // 返回边界次数
        
        for (int num : nums) {
            position += num; // 移动
            
            if (position == 0) {
                count++; // 回到边界
            }
        }
        
        return count;
    }
}
// @lc code=end

