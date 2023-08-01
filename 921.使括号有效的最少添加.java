/*
 * @lc app=leetcode.cn id=921 lang=java
 *
 * [921] 使括号有效的最少添加
 */

// @lc code=start
class Solution {
    public int minAddToMakeValid(String s) {
        // 从左往右依次检测，初始状态下左括号和右括号的需求量均为0
        // 当有一个左括号，那么右括号的需求量+1，遇到一个右括号的时候就可以-1
        // 但当没有多余左括号的时候，出现一个右括号，左括号的需求量+1且这个需求量是不会降低的
        // 它们的不同之处是关键
        
        // res 是需求的左括号，也是不会降低的需求量
        int res = 0;
        // need 是需求的右括号，是会降低的需求量
        int need = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                need++;
            }
            if (s.charAt(i) == ')') {
                need--;
                // 如果need是复数，说明在need--之前，need=0
                // 也就是说之前左右括号数量平衡
                // 那么现在这个右括号就是需要一个不可减少的左括号需求
                if (need == -1) {
                    res++;
                    need = 0;
                }
            }
        }

        // res 是左括号需求量，need是右括号需求量
        return res + need;
    }
}
// @lc code=end

