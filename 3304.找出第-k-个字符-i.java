/*
 * @lc app=leetcode.cn id=3304 lang=java
 *
 * [3304] 找出第 K 个字符 I
 */

// @lc code=start
class Solution {
    public char kthCharacter(int k) {
        
        int ans = 0;
        int t;
        while (k != 1) {
            t = 31 - Integer.numberOfLeadingZeros(k);
            if ((1 << t) == k) {
                t--;
            }
            k = k - (1 << t);
            ans++;
        }
        return (char) ('a' + ans);

    }
}
// @lc code=end

