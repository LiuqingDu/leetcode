/*
 * @lc app=leetcode.cn id=1323 lang=java
 *
 * [1323] 6 和 9 组成的最大数字
 */

// @lc code=start
class Solution {
    public int maximum69Number (int num) {
    String str = Integer.toString(num);
    // 查找第一个'6'的位置，替换为'9'
    str = str.replaceFirst("6", "9");
    return Integer.parseInt(str);
    }
}
// @lc code=end

