/*
 * @lc app=leetcode.cn id=1311 lang=javascript
 *
 * [1311] 获取你好友已观看的视频
 */

// @lc code=start
/**
 * @param {string[][]} watchedVideos
 * @param {number[][]} friends
 * @param {number} id
 * @param {number} level
 * @return {string[]}
 */
var watchedVideosByFriends = function(watchedVideos, friends, id, level) {
    const n = friends.length;

    // 1. BFS 找第 level 层
    const visited = new Array(n).fill(false);
    const queue = [];

    queue.push(id);
    visited[id] = true;

    let currLevel = 0;

    while (queue.length && currLevel < level) {
        let size = queue.length;

        for (let i = 0; i < size; i++) {
            const person = queue.shift();

            for (let f of friends[person]) {
                if (!visited[f]) {
                    visited[f] = true;
                    queue.push(f);
                }
            }
        }

        currLevel++;
    }

    // 2. 统计视频频率
    const map = new Map();

    for (let person of queue) {
        for (let video of watchedVideos[person]) {
            map.set(video, (map.get(video) || 0) + 1);
        }
    }

    // 3. 排序
    const result = Array.from(map.keys());

    result.sort((a, b) => {
        if (map.get(a) !== map.get(b)) {
            return map.get(a) - map.get(b); // 频率升序
        }
        return a.localeCompare(b); // 字母升序
    });

    return result;
};
// @lc code=end

