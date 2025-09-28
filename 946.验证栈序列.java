/*
 * @lc app=leetcode.cn id=946 lang=java
 *
 * [946] 验证栈序列
 */

// @lc code=start
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        // 模拟入栈出栈
        // 依次将pushed的元素入栈, 每入栈一个就检查栈顶元素是否等于popped的当前元素
        // 如果相等就出栈, 并且popped指针后移, 然后继续尝试出栈, 直到不相等为止
        // 最后检查popped指针是否到达末尾
        Stack<Integer> stack = new Stack<>();
        int j = 0; // popped的指针
        for (int x : pushed) {
            stack.push(x); // 入栈
            // 出栈
            while (!stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }
        return j == popped.length;
    }
}
// @lc code=end

