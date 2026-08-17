/*
 * @lc app=leetcode.cn id=2515 lang=java
 *
 * [2515] 到目标字符串的最短距离
 */

// @lc code=start
class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int res = words.length;
        int n = words.length;

        for (int i = 0; i < n; i++) {
            if (words[i].equals(target)) {
                int dist = Math.abs(i - startIndex);
                res = Math.min(res, Math.min(dist, n - dist));
            }
        }

        return res < n ? res : -1;
    }
}
// @lc code=end

