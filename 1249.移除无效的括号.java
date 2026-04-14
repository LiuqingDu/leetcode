/*
 * @lc app=leetcode.cn id=1249 lang=java
 *
 * [1249] 移除无效的括号
 */

// @lc code=start
class Solution {
    public String minRemoveToMakeValid(String s) {
        
        StringBuilder sb = new StringBuilder(s);
        
        // 第一遍：去掉多余的 ')'
        int balance = 0;
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (c == '(') {
                balance++;
            } else if (c == ')') {
                if (balance == 0) {
                    sb.setCharAt(i, '#'); // 标记删除
                } else {
                    balance--;
                }
            }
        }

        // 第二遍：去掉多余的 '('
        balance = 0;
        for (int i = sb.length() - 1; i >= 0; i--) {
            char c = sb.charAt(i);
            if (c == ')') {
                balance++;
            } else if (c == '(') {
                if (balance == 0) {
                    sb.setCharAt(i, '#'); // 标记删除
                } else {
                    balance--;
                }
            }
        }

        // 构建结果
        StringBuilder res = new StringBuilder();
        for (char c : sb.toString().toCharArray()) {
            if (c != '#') {
                res.append(c);
            }
        }

        return res.toString();
    }
}
// @lc code=end

