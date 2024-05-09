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
        // 用三个Set记录每一列，左斜线，右斜线上是否已经有皇后了
        // 如何表示斜线？先看左上到右下的斜线，这些斜线中，同一条斜线上的每一个点，
        // 它们自身的横坐标与纵坐标之差，对于同一条线上的点是相同的
        // 比如[0,0],[1,1],[2,2]是对角线，它们每一个点的横坐标与纵坐标额差是0
        // 同样的[0,1],[1,2],[2,3]是对角线右上方的一条线，它们的差是-1
        // 那么可以用差值表示一条线，其中差值为0表示对角线，差值为负数的是右上方的线
        // 同理，右上到左下的斜线，坐标之和是相同的
        // 坐标和为n-1的是对角线
        // 具体的逻辑是，依次为每一横行放置一个皇后，放置之前，要遍历这一行的每一个格子
        // 如果当前格子所在的列，两条斜线，已经有皇后了，则跳过
        // 否则可以放置皇后，然后尝试下一行，完成后回到当前行，撤销操作，尝试当前行下一个格子

        List<List<String>> res = new ArrayList<List<String>>();
        // 记录每一行的第几个位置是皇后，总共n行
        int[] queen = new int[n];
        // -1表示还没有确认位置
        Arrays.fill(queen, -1);
        // Set用来记录当前列，两条斜线上是否已经有皇后了
        Set<Integer> col = new HashSet<Integer>();
        Set<Integer> diag1 = new HashSet<Integer>();
        Set<Integer> diag2 = new HashSet<Integer>();
        backtrace(res, queen, n, 0, col, diag1, diag2);
        return res;
    }

    private void backtrace(List<List<String>> res, int[] queen, int n, int row, Set<Integer> col, Set<Integer> diag1, Set<Integer> diag2) {
        // row是当前要处理第几行，如果已经处理完了则添加当前棋盘
        if (row == n) {
            List<String> board = queenToBoard(queen, n);
            res.add(board);
            return;
        }

        // 在当前行依次尝试每一个格子
        for (int i = 0; i < n; i++) {
            // 如果这个格子所在的列已经有皇后则跳过
            if (col.contains(i)) {
                continue;
            }
            // 坐标差是左上到右下的斜线
            int d1 = row - i;
            // 当前斜线是否有皇后
            if (diag1.contains(d1)) {
                continue;
            }
            // 坐标和是右上到左下的斜线
            int d2 = row + i;
            if (diag2.contains(d2)) {
                continue;
            }
            // 这里说明列，两个斜线上都没有皇后，当前位置可以放
            queen[row] = i;
            col.add(i);
            diag1.add(d1);
            diag2.add(d2);
            // 继续下一行
            backtrace(res, queen, n, row + 1, col, diag1, diag2);
            // 撤回选项
            diag2.remove(d2);
            diag1.remove(d1);
            col.remove(i);
            queen[row] = -1;
        }
    }

    // 把int数组变换为棋盘
    private List<String> queenToBoard(int[] queen, int n) {
        List<String> board = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            // 当前行默认没有皇后
            Arrays.fill(row, '.');
            // 把皇后所在位置填上
            row[queen[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }
}
// @lc code=end

