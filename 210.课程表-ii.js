/*
 * @lc app=leetcode.cn id=210 lang=javascript
 *
 * [210] 课程表 II
 */

// @lc code=start
/**
 * @param {number} numCourses
 * @param {number[][]} prerequisites
 * @return {number[]}
 */
var findOrder = function(numCourses, prerequisites) {
    let res = [];

    let graph = Array.from(Array(numCourses), () => []);
    let indegree = new Array(numCourses).fill(0);

    for (let pre of prerequisites) {
        let [to, from] = pre;
        graph[from].push(to);
        indegree[to]++;
    }

    let queue = [];
    for (let i = 0; i < indegree.length; i++) {
        if (indegree[i] === 0) {
            queue.push(i);
        }
    }

    let count = 0;
    while(queue.length !== 0) {
        let course = queue.shift();
        count++;
        res.push(course);
        for (let next of graph[course]) {
            indegree[next]--;
            if (indegree[next] === 0) {
                queue.push(next);
            }
        }
    }

    return count === numCourses ? res : [];
};
// @lc code=end

