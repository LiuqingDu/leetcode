/*
 * @lc app=leetcode.cn id=773 lang=javascript
 *
 * [773] 滑动谜题
 */

// @lc code=start
/**
 * @param {number[][]} board
 * @return {number}
 */
var slidingPuzzle = function(board) {

    let moves = [[1, 3], [0, 2, 4], [1, 5], [0, 4], [1, 3, 5], [2, 4]]

    let res = 0;
    let target = "123450";

    let start = "";
    for (let i = 0; i < 2; i++) {
        for (let j = 0; j < 3; j++) {
            start += board[i][j];
        }
    }

    let queue = [];
    let visited = new Set();

    queue.push(start);
    visited.add(start);

    let swap = function(s, i, j) {
        let arr = s.split("");
        let tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
        return arr.join("");
    }

    while (queue.length) {
        let n = queue.length;
        for (let i = 0; i < n; i++) {
            let cur = queue.shift();
            if (cur === target) {
                return res;
            } else {
                let j = cur.indexOf("0");
                let move = moves[j];
                for (let k = 0; k < move.length; k++) {
                    let next = swap(cur, j, move[k]);
                    if (visited.has(next)) {
                        continue;
                    }
                    queue.push(next);
                    visited.add(next);
                }
            }
        }
        res++;
    }

    return -1;
};
// @lc code=end

