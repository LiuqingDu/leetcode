/*
 * @lc app=leetcode.cn id=241 lang=java
 *
 * [241] 为运算表达式设计优先级
 */

// @lc code=start

class Solution {
    // 分治思想
    // 将问题拆分为小问题，再将小问题的答案合并起来
    // 这里小问题是：将一个表达式拆成两个表达式，然后将这两个表达式的结果用它们之间的运算符算出结果

    // 记录已经算过的表达式的结果，避免重复计算。
    Map<String, List<Integer>> memo = new HashMap<String, List<Integer>>();

    // 给定一个表达式，计算该表达式的结果
    public List<Integer> diffWaysToCompute(String expression) {
        // 从备忘录中找，减少重复计算
        if (memo.containsKey(expression)) {
            return memo.get(expression);
        }

        // 存储当前表达式的所有可能的结果
        List<Integer> res = new LinkedList<Integer>();
        // 遍历当前表达式，依次在每一个运算符处将原表达式分割为两个小表达式，计算小表达式的结果，
        // 然后再根据这个运算符来计算原表达式的值
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            // 如果找到一个运算符，则拆分并计算结果
            if (c == '+' || c == '-' || c == '*') {
                // 分治计算小表达式的结果
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i + 1, expression.length()));
                // 遍历左右表达式的所有可能的值，然后再用当前分割的运算符来计算
                for (int a: left) {
                    for (int b: right) {
                        if (c == '+') {
                            res.add(a + b);
                        }
                        if (c == '-') {
                            res.add(a - b);
                        }
                        if (c == '*') {
                            res.add(a * b);
                        }
                    }
                }
            }
        }
        // 如果res为空，说明表达式里没有运算符，因为有运算符的话就至少走一次上面的if了
        // 没有运算符就只有数字，那么这个表达式的结果就是这个数字
        if (res.size() == 0) {
            res.add(Integer.parseInt(expression));
        }
        memo.put(expression, res);
        return res;
    }
}
// @lc code=end

