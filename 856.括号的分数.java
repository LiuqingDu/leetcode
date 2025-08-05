/*
 * @lc app=leetcode.cn id=856 lang=java
 *
 * [856] 括号的分数
 */

// @lc code=start
class Solution {
    public int scoreOfParentheses(String s) {
        // 最终分数跟纯括号对()的层数d有关
        // 每一对括号()的分数为2^d
        // 其中d为当前括号对()的层数
        // 例如(())的分数为2^1 = 2，
        // (()(())的分数为2^1 + 2^2 = 2 + 4 = 6，
        // 初始化层数d为0，字符串长度n为s.length()
        // 初始化结果res为0

        int d = 0, n = s.length(), res = 0;
        // 遍历字符串s
        for (int i = 0; i < n; i++) {
            // 如果是左括号(，层数d加1
            // 如果是右括号)，层数d减1
            d += (s.charAt(i) == '(' ? 1 : -1);
            // 如果是右括号)，且前一个字符是左括号(，
            // 则说明当前括号对()的分数为2^d
            // 将分数累加到res中
            // 这里的1 << d相当于2^d
            if (s.charAt(i) == ')' && s.charAt(i - 1) == '(') {
                res += 1 << d;
            }
        }
        return res;
    }
}
// @lc code=end

