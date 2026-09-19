/*
 * @lc app=leetcode.cn id=3174 lang=java
 *
 * [3174] 清除数字
 */

// @lc code=start
class Solution {
    public String clearDigits(String s) {
        
        StringBuilder res = new StringBuilder();
        for (char c : s.toCharArray()){
            if (Character.isDigit(c)) {
                res.deleteCharAt(res.length() - 1);
            } else {
                res.append(c);
            }
        }
        return res.toString();

    }
}
// @lc code=end

