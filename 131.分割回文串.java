/*
 * @lc app=leetcode.cn id=131 lang=java
 *
 * [131] 分割回文串
 */

// @lc code=start
class Solution {

    private boolean[][] dp;
    private List<List<String>> res = new LinkedList<List<String>>();

    public List<List<String>> partition(String s) {

        int n = s.length();

        dp = new boolean[n][n];

        for (int right = 0; right < n; right++) {
            for (int left = 0; left <= right; left++) {
                if (s.charAt(right) == s.charAt(left) && (right - left <= 2 || dp[left + 1][right - 1])) {
                    dp[left][right] = true;
                }
            }
        }

        backtrack(s, 0, new ArrayList<String>());

        return res;

    }

    private void backtrack(String s, int i, List<String> path) {

        if (i == s.length()) {
            res.add(new ArrayList<String>(path));
            return;
        }

        for (int j = i; j < s.length(); j++) {
            if (dp[i][j]) {
                path.add(s.substring(i, j + 1));
                backtrack(s, j + 1, path);
                path.remove(path.size() - 1);
            }
        }

    }
}
// @lc code=end

