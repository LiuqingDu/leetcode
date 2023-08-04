/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 */

// @lc code=start
class Solution {
    // 实际上是说有2n个位置，放置n个左括号和n个右括号，
    // 所有的放置组合中有多少个是合法的括号组合
    // 其中合法的组合要求是：1，左右括号数量相等；
    // 2，对于一个合法组合，从第一个符号开始到任意符号为止，左括号数量必定大于或等于右括号数量
    
    List<String> res = new LinkedList<String>();
    StringBuilder current = new StringBuilder();
    // 记录用了多少个左右括号
    int left = 0;
    int right = 0;
    int n;

    public List<String> generateParenthesis(int n) {
        this.n = n;
        backtrack();
        return res;
    }

    private void backtrack() {
        // 如果括号使用量超出可用的限制或者左括号比右括号少，则不合法
        if (left > n || right > n || left < right) {
            return;
        }

        // 如果括号都用完了则加入结果
        if (left == n && right == n) {
            res.add(current.toString());
            return;
        }

        // 尝试添加一个左括号
        current.append("(");
        left++;
        backtrack();
        current.setLength(current.length() - 1);
        left--;

        // 尝试添加一个右括号
        current.append(")");
        right++;
        backtrack();
        current.setLength(current.length() - 1);
        right--;
    }
}
// @lc code=end

