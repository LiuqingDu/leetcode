/*
 * @lc app=leetcode.cn id=1018 lang=java
 *
 * [1018] 可被 5 整除的二进制前缀
 */

// @lc code=start
class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> result = new ArrayList<>();
        int num = 0; // 用于存储当前二进制数的余数

        for (int bit : nums) {
            num = (num * 2 + bit) % 5; // 只保留 num % 5，避免溢出
            result.add(num == 0); // 余数为 0，则表示可以被 5 整除
        }

        return result;
    }
}
// @lc code=end

