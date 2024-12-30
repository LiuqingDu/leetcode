/*
 * @lc app=leetcode.cn id=678 lang=java
 *
 * [678] 有效的括号字符串
 */

// @lc code=start
class Solution {
    public boolean checkValidString(String s) {
        // 比较简单的方法
        // 从两个方向检查一遍,从左侧往右确保每一个)都已经有一个(或者*可以配对
        // 从右侧往左确保每一个(都已经有一个)或者*可以配对

        int n = s.length();
        int balance = 0; // balance 用来表示当前的括号平衡度

        // 正向遍历
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i); // 获取字符串 s 的第 i 个字符
            if (ch == '(' || ch == '*') { // 如果当前字符是左括号，或者 '*'（即可被解锁）
                balance++; // 括号平衡度加一
            } else { // 当前字符是右括号
                balance--; // 括号平衡度减一，表示匹配了一个左括号
                if (balance < 0) {
                    return false; // 如果出现右括号却没有匹配的左括号，则返回 false
                }
            }
        }

        balance = 0; // 重新初始化括号平衡度

        // 反向遍历
        for (int i = n - 1; i >= 0; i--) {
            char ch = s.charAt(i); // 获取字符串 s 的第 i 个字符（从末尾开始）
            if (ch == ')' || ch == '*') { // 如果当前字符是右括号，或者 '*'（即可被解锁）
                balance++; // 括号平衡度加一
            } else { // 当前字符是左括号
                balance--; // 括号平衡度减一，表示匹配了一个右括号
                if (balance < 0) {
                    return false; // 如果出现左括号却没有匹配的右括号，则返回 false
                }
            }
        }

        return true; // 如果正向和反向遍历均未出现问题，则返回 true，表示可以构成有效的括号序列
    }
}
// @lc code=end

