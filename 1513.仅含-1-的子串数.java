/*
 * @lc app=leetcode.cn id=1513 lang=java
 *
 * [1513] 仅含 1 的子串数
 */

// @lc code=start
class Solution {
    public int numSub(String s) {
        
        final int MODULO = 1000000007;
        long total = 0;
        int length = s.length();
        long consecutive = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == '0') {
                total += consecutive * (consecutive + 1) / 2;
                total %= MODULO;
                consecutive = 0;
            } else {
                consecutive++;
            }
        }
        total += consecutive * (consecutive + 1) / 2;
        total %= MODULO;
        return (int) total;
    }
}
// @lc code=end

