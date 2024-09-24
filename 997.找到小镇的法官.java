/*
 * @lc app=leetcode.cn id=997 lang=java
 *
 * [997] 找到小镇的法官
 */

// @lc code=start
class Solution {
    public int findJudge(int n, int[][] trust) {
        // 出度入度问题，信任别人记为出度+1，被别人信任记为入度+1
        // 法官就是出度为 0，入度为 n-1
        int[] out = new int[n + 1];
        int[] in = new int[n + 1];

        for (int i = 0; i < trust.length; i++) {
            out[trust[i][0]]++;
            in[trust[i][1]]++;
        }

        for (int i = 1; i <= n; i++) {
            if (out[i] == 0 && in[i] == n - 1) {
                return i;
            }
        }

        return -1;
    }
}
// @lc code=end

