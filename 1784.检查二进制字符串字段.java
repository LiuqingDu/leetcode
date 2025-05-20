/*
 * @lc app=leetcode.cn id=1784 lang=java
 *
 * [1784] 检查二进制字符串字段
 */

// @lc code=start
class Solution {
    public boolean checkOnesSegment(String s) {
        // 出现 01 就不符合,其余情况都符合
        return !s.contains("01");
    }
}
// @lc code=end

