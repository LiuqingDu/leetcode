/*
 * @lc app=leetcode.cn id=1190 lang=java
 *
 * [1190] 反转每对括号间的子串
 */

// @lc code=start
class Solution {
    public String reverseParentheses(String s) {
        // 用sb保存当前待处理的,也就是非括号内容
        // 栈存放每一段已经处理过的
        // 遇到左括号就把之前的内容放在栈里
        // 遇到右括号就把待处理的翻转,然后把栈顶的放到前面,也就是把反转后的放到之前已处理的后面
        // 遇到非括号的就放到sb里等待处理
        Deque<String> stack = new LinkedList<String>();
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                // 遇到左括号就存入栈里,都是已经处理过的
                stack.push(sb.toString());
                sb.setLength(0);
            } else if (ch == ')') {
                // 遇到右括号就把待处理的翻转,然后拼到栈顶的后面,一起放到sb里面
                sb.reverse();
                // 下面这个把栈顶插到sb前面,也就相当于把栈顶和sb拼接,再存入sb
                sb.insert(0, stack.pop());
            } else {
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}
// @lc code=end

