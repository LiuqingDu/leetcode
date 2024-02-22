/*
 * @lc app=leetcode.cn id=79 lang=java
 *
 * [79] 单词搜索
 */

// @lc code=start
class Solution {
    public boolean exist(char[][] board, String word) {

        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (find(board, i, j, word, 0, new boolean[m][n])) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean find(char[][] board, int x, int y, String word, int ind, boolean[][] visited) {
        int m = board.length;
        int n = board[0].length;

        if (ind >= word.length()) {
            return true;
        }

        if (x < 0 || x >= m || y < 0 || y >= n) {
            return false;
        }

        if (visited[x][y]) {
            return false;
        }

        if (board[x][y] == word.charAt(ind)) {
            visited[x][y] = true;
            if (find(board, x + 1, y, word, ind + 1, visited)
                || find(board, x - 1, y, word, ind + 1, visited)
                || find(board, x, y + 1, word, ind + 1, visited)
                || find(board, x, y - 1, word, ind + 1, visited)) {
                    return true;
            }
            visited[x][y] = false;
        }

        return false;
    }
}
// @lc code=end

