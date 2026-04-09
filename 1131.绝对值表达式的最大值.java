/*
 * @lc app=leetcode.cn id=1131 lang=java
 *
 * [1131] 绝对值表达式的最大值
 */

// @lc code=start
class Solution {
    public int maxAbsValExpr(int[] arr1, int[] arr2) {
        
        int n = arr1.length;
        int res = 0;

        int[][] dirs = {
            {1, 1},
            {1, -1},
            {-1, 1},
            {-1, -1}
        };

        for (int[] d : dirs) {
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                int val = d[0] * arr1[i] + d[1] * arr2[i] + i;
                max = Math.max(max, val);
                min = Math.min(min, val);
            }

            res = Math.max(res, max - min);
        }

        return res;
    }
}
// @lc code=end

