/*
 * @lc app=leetcode.cn id=385 lang=java
 *
 * [385] 迷你语法分析器
 */

// @lc code=start
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public NestedInteger deserialize(String s) {
        // 明显需要用栈
        // 依次处理每一个字符，对于负号就记录一下，
        // 如果是数字就记录数字
        // 如果是左括号，则创建一个新的NestedInteger放到栈顶
        // 如果是逗号或者右括号，说明前一个元素结束
        // 此时需要判断一下前一个是什么元素，
        // 如果是数字，那么就把数字放到栈顶的NestedInteger里
        // 然后无论是不是数字，因为元素已经结束，需要把num和负号标记还原
        // 最后，如果当前字符是右括号，说明当前列表也结束了，就把列表放到上一层列表里     

        // 如果没有列表，直接返回数字
        if (s.charAt(0) != '[') {
            return new NestedInteger(Integer.parseInt(s));
        }

        // 栈用来存储每一层NestedInteger
        Deque<NestedInteger> stack = new ArrayDeque<NestedInteger>();
        // 记录当前数字元素
        int num = 0;
        // 标记是否为负数
        boolean negative = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 负数标记一下
            if (c == '-') {
                negative = true;
            } else if (Character.isDigit(c)) {
                // 数字就记录一下
                num = num * 10 + (c - '0');
            } else if (c == '[') {
                // 开启一层新的NestedInteger
                stack.push(new NestedInteger());
            } else if (c == ',' || c == ']') {
                // 如果当前元素结束了
                // 看一下这个元素是不是数字
                if (Character.isDigit(s.charAt(i - 1))) {
                    if (negative) {
                        num *= -1;
                    }
                    // 把这个数字加到最后一层里
                    stack.peek().add(new NestedInteger(num));
                }
                // 无论如何重置数字标识
                num = 0;
                negative = false;
                // 如果这一层结束了，就把这一层放到上一层里面
                if (c == ']' & stack.size() > 1) {
                    NestedInteger ni = stack.pop();
                    stack.peek().add(ni);
                }
            }
        }
        return stack.pop();
    }
}
// @lc code=end

