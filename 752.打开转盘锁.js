/*
 * @lc app=leetcode.cn id=752 lang=javascript
 *
 * [752] 打开转盘锁
 */

// @lc code=start
/**
 * @param {string[]} deadends
 * @param {string} target
 * @return {number}
 */
var openLock = function(deadends, target) {

    let dead = new Set();
    for (let d of deadends) {
        dead.add(d);
    }

    let visited = new Set();
    let queue = [];
    let res = 0;

    let up = function(s, i) {
        let arr = s.split("");
        if (arr[i] === "9") {
            arr[i] = "0";
        } else {
            arr[i] = (parseInt(arr[i]) + 1) + "";
        }
        return arr.join("");
    }
    let down = function(s, i) {
        let arr = s.split("");
        if (arr[i] === "0") {
            arr[i] = "9";
        } else {
            arr[i] = (parseInt(arr[i]) - 1) + "";
        }
        return arr.join("");
    }

    queue.push("0000");
    visited.add("0000");

    while (queue.length) {
        let n = queue.length;
        for (let i = 0; i < n; i++) {
            let s = queue.shift();
            if (dead.has(s)) {
                continue;
            }
            if (target === s) {
                return res;
            }
            for (let j = 0; j < 4; j++) {
                let next = up(s, j);
                if (!visited.has(next)) {
                    queue.push(next);
                    visited.add(next);
                }
                next = down(s, j);
                if (!visited.has(next)) {
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

