/*
 * @lc app=leetcode.cn id=299 lang=java
 *
 * [299] 猜数字游戏
 */

// @lc code=start
class Solution {
    public String getHint(String secret, String guess) {

        int n  = secret.length();
        int a = 0, b = 0;
        int[] se = new int[10];
        int[] gu = new int[10];

        for (int i = 0; i < n; i++) {
            int c1 = secret.charAt(i) - '0';
            int c2 = guess.charAt(i) - '0';

            if (c1 == c2) {
                a++;
            } else {
                se[c1]++;
                gu[c2]++;
            }
        }

        for (int i = 0; i < 10; i++) {
            b += Math.min(se[i], gu[i]);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(a).append('A').append(b).append('B');
        return sb.toString();

    }
}
// @lc code=end

