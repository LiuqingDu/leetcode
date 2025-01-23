/*
 * @lc app=leetcode.cn id=1021 lang=java
 *
 * [1021] 删除最外层的括号
 */

// @lc code=start
class Solution {
    public String removeOuterParentheses(String s) {
        // 其实就是把最外层的括号去掉
        // 遇到左括号+1,遇到右括号-1
        // 遇到左括号的时候,如果当前不是第一个左括号,那么就加入结果
        // 遇到右括号的时候,如果当前还有左括号,那么就加入结果

        int n = s.length();
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                count++;
                // 如果不是第一个左括号则加入结果
                if (count != 1) {
                    sb.append('(');
                }
            } else {
                count--;
                // 如果还有左括号,那么现在就不是最外层,就加入结果
                if (count != 0) {
                    sb.append(')');
                }
            }
        }
        return sb.toString();
    }
}
// @lc code=end

