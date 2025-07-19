/*
 * @lc app=leetcode.cn id=2027 lang=java
 *
 * [2027] 转换字符串的最少操作次数
 */

// @lc code=start
class Solution {
    public int minimumMoves(String s) {
        // 可以发现,只要遇到一个x,那么这里就需要一步,且它后面两个字符也会被转换
        // 所以我们可以每次遇到x就跳过3个字符,这样就能保证每次操作都能覆盖到尽可能多的字符
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'X') {
                count++;
                i += 2; // 跳过后面两个字符
            }
        }
        return count;
    }
}
// @lc code=end

