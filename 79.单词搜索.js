/*
 * @lc app=leetcode.cn id=79 lang=javascript
 *
 * [79] 单词搜索
 */

// @lc code=start
/**
 * @param {character[][]} board
 * @param {string} word
 * @return {boolean}
 */
var exist = function(board, word) {

    let find = function(board, x, y, word, ind, visited) {
        let m = board.length;
        let n = board[0].length;

        if (ind >= word.length) {
            return true;
        }

        if (x < 0 || x >= m || y < 0 || y >= n) {
            return false;
        }

        if (visited[x][y]) {
            return false;
        }

        if (board[x][y] === word.charAt(ind)) {
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

    let m = board.length;
    let n = board[0].length;

    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (find(board, i, j, word, 0, Array.from(Array(m), () => Array(n).fill(false)))) {
                return true;
            }
        }
    }

    return false;

};
// @lc code=end

