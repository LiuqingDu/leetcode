/*
 * @lc app=leetcode.cn id=553 lang=java
 *
 * [553] 最优除法
 */

// @lc code=start
class Solution {
    public String optimalDivision(int[] nums) {
        // 要让结果最大,那么就是让分子越小
        // 让从第二个开始的所有数字都进入到分子去,就会让分子越除越小
        // nums[0]/nums[1]/nums[2].../nums[n]
        // 转变为
        // nums[0]/(nums[1]/nums[2].../nums[n])
        // 等于
        // nums[0]/(nums[1] * (1/nums[2]) ... * (1/nums[n]))
        // 等于
        // nums[0]*nums[2]*...*nums[n]/nums[1]
        // 注意每一个数字都是正数,且大于 2 所以会越除越小
        // 如果是负数或者小于 1 则该解法无效

        if (nums.length == 1) {
            // 只有一个数字，直接返回
            return String.valueOf(nums[0]);
        }
        if (nums.length == 2) {
            // 两个数字，直接除
            return nums[0] + "/" + nums[1];
        }
        
        // 多于两个数字的情况
        StringBuilder result = new StringBuilder();
        result.append(nums[0]).append("/("); // 添加开头和左括号
        for (int i = 1; i < nums.length; i++) {
            result.append(nums[i]);
            if (i < nums.length - 1) {
                result.append("/"); // 添加除号
            }
        }
        result.append(")"); // 添加右括号
        
        return result.toString();
    }
}
// @lc code=end

