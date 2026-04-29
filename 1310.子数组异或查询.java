/*
 * @lc app=leetcode.cn id=1310 lang=java
 *
 * [1310] 子数组异或查询
 */

// @lc code=start
class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        
        // 1. 构建前缀异或数组
        int[] prefix = new int[n];
        prefix[0] = arr[0];
        
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] ^ arr[i];
        }
        
        // 2. 处理查询
        int[] res = new int[queries.length];
        
        for (int i = 0; i < queries.length; i++) {
            int L = queries[i][0];
            int R = queries[i][1];
            
            if (L == 0) {
                res[i] = prefix[R];
            } else {
                res[i] = prefix[R] ^ prefix[L - 1];
            }
        }
        
        return res;
    }
}
// @lc code=end

