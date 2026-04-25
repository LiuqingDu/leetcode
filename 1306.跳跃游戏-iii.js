/*
 * @lc app=leetcode.cn id=1306 lang=javascript
 *
 * [1306] 跳跃游戏 III
 */

// @lc code=start
/**
 * @param {number[]} arr
 * @param {number} start
 * @return {boolean}
 */
var canReach = function(arr, start) {
    const n = arr.length;
    const visited = new Array(n).fill(false);
    const queue = [start];

    visited[start] = true;

    while (queue.length > 0) {
        const i = queue.shift();

        // 找到 0
        if (arr[i] === 0) return true;

        const left = i - arr[i];
        const right = i + arr[i];

        if (left >= 0 && !visited[left]) {
            queue.push(left);
            visited[left] = true;
        }

        if (right < n && !visited[right]) {
            queue.push(right);
            visited[right] = true;
        }
    }

    return false;
};
// @lc code=end

