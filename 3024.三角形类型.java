/*
 * @lc app=leetcode.cn id=3024 lang=java
 *
 * [3024] 三角形类型
 */

// @lc code=start
class Solution {
    public String triangleType(int[] nums) {
        
        // 1. 排序
        Arrays.sort(nums);
        int a = nums[0], b = nums[1], c = nums[2];
        
        // 2. 判断是否能构成三角形
        if (a + b <= c) {
            return "none";
        }
        
        // 3. 判断类型
        if (a == b && b == c) {
            return "equilateral";
        } else if (a == b || b == c || a == c) {
            return "isosceles";
        } else {
            return "scalene";
        }
    }
}
// @lc code=end

