/*
 * @lc app=leetcode.cn id=841 lang=javascript
 *
 * [841] 钥匙和房间
 */

// @lc code=start
/**
 * @param {number[][]} rooms
 * @return {boolean}
 */
var canVisitAllRooms = function(rooms) {
    const visited = new Array(rooms.length).fill(false);
    let count = 0;

    const dfs = (rooms, room) => {
        visited[room] = true;
        count++;
        for (const key of rooms[room]) {
            if (!visited[key]) {
                dfs(rooms, key);
            }
        }
    }

    dfs(rooms, 0);
    return count === rooms.length;
};
// @lc code=end

