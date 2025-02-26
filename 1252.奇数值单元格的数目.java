/*
 * @lc app=leetcode.cn id=1252 lang=java
 *
 * [1252] 奇数值单元格的数目
 */

// @lc code=start
class Solution {
    public int oddCells(int m, int n, int[][] indices) {
        // 考虑到题目只要个数而不是具体的每个数字,那么有可能不需要完整模拟一遍
        // 注意到每次会把一整行和一整列都+1, 那么可以用两个数组
        // 来记录每一行和每一列都被+了多少次
        // 然后再判断每个坐标总共被加了多少次
        
        int[] rows = new int[m];
        int[] cols = new int[n];
        for (int[] index : indices) {
            rows[index[0]]++;
            cols[index[1]]++;
        }

        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (((rows[i] + cols[j]) & 1) != 0) {
                    res++;
                }
            }
        }

        return res;
    }
}
// @lc code=end

