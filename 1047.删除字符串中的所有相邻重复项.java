/*
 * @lc app=leetcode.cn id=1047 lang=java
 *
 * [1047] 删除字符串中的所有相邻重复项
 */

// @lc code=start
class Solution {
    public String removeDuplicates(String s) {
        // 可以看出如果删除了一对,那么下一对可删除的要么出现在刚删除的两侧
        // 要么出现在右边未来的位置
        // 可以用栈来处理,如果栈顶跟下一个字符相同则同时删去,否则入栈

        // 用 sb 来模拟栈
        StringBuffer stack = new StringBuffer();
        // 栈顶位置, 如果空栈则为-1, 为 0 表示栈有 1 个元素
        int top = -1;
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            // 如果栈有元素且栈顶跟新字符相同
            if (top >= 0 && stack.charAt(top) == ch) {
                stack.deleteCharAt(top);
                --top;
            } else {
                stack.append(ch);
                ++top;
            }
        }
        return stack.toString();
    }
}
// @lc code=end

