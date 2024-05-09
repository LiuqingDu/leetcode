/*
 * @lc app=leetcode.cn id=51 lang=java
 *
 * [51] N 皇后
 */

// @lc code=start

class Solution {
    public List<List<String>> solveNQueens(int n) {
        // 比较容易想到的方法是暴力尝试把每一个皇后挨个放在每一个格子里
        // 这样计算量太大，根据要求每一行每一列以及斜线上只能有一个皇后
        // 可以理解为，对于行，第一个皇后有n种选择方法，第二个皇后只有n-1种方法
        // 这样就可以用回溯，依次尝试每种可能性，关键在于如何表示出行和斜线的位置
        // 可以用一个数组nums[n]来记录每个皇后在每一行的位置
        // 数组每一个位置依次表示第i行，nums[i]表示第i行第几个格子是皇后
        // 用三个Set记录每一行，左斜线，右斜线上是否已经有皇后了
        // 如何表示斜线？从左上角开始，同一条斜线（题目图中橙色的斜线）上的点的【横坐标+纵坐标】
        // 之和是相同的，可以用这个和表示它所在的斜线

        List<List<String>> res = new ArrayList<List<String>>();
        int[] queen = new int[n];
        Arrays.fill(queen, -1);
        Set<Integer> col = new HashSet<Integer>();
        Set<Integer> diag1 = new HashSet<Integer>();
        Set<Integer> diag2 = new HashSet<Integer>();
        backtrace(res, queen, n, 0, col, diag1, diag2);
        return res;
    }

    private void backtrace(List<List<String>> res, int[] queen, int n, int row, Set<Integer> col, Set<Integer> diag1, Set<Integer> diag2) {
        if (row == n) {
            List<String> board = queenToBoard(queen, n);
            res.add(board);
            return;
        }

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
            queen[row] = i;
            col.add(i);
            diag1.add(d1);
            diag2.add(d2);
            backtrace(res, queen, n, row + 1, col, diag1, diag2);
            diag2.remove(d2);
            diag1.remove(d1);
            col.remove(i);
            queen[row] = -1;
        }
    }

    private List<String> queenToBoard(int[] queen, int n) {
        List<String> board = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queen[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }
}
// @lc code=end

