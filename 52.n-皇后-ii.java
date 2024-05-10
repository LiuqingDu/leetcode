/*
 * @lc app=leetcode.cn id=52 lang=java
 *
 * [52] N 皇后 II
 */

// @lc code=start
class Solution {
    public int totalNQueens(int n) {
        Set<Integer> col = new HashSet<Integer>();
        Set<Integer> diag1 = new HashSet<Integer>();
        Set<Integer> diag2 = new HashSet<Integer>();
        return backtrace(n, 0, col, diag1, diag2);
    }

    private int backtrace(int n, int row, Set<Integer> col, Set<Integer> diag1, Set<Integer> diag2) {
        if (row == n) {
            return 1;
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (col.contains(i)) {
                continue;
            }
            int d1 = row - i;
            if (diag1.contains(d1)) {
                continue;
            }
            int d2 = row + i;
            if (diag2.contains(d2)) {
                continue;
            }

            col.add(i);
            diag1.add(d1);
            diag2.add(d2);
            count += backtrace(n, row + 1, col, diag1, diag2);
            diag2.remove(d2);
            diag1.remove(d1);
            col.remove(i);
        }
        return count;
    }
}
// @lc code=end

