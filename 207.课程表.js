/*
 * @lc app=leetcode.cn id=207 lang=javascript
 *
 * [207] 课程表
 */

// @lc code=start
/**
 * @param {number} numCourses
 * @param {number[][]} prerequisites
 * @return {boolean}
 */
var canFinish = function(numCourses, prerequisites) {

    let graph = [];
    let indegree = [];
    for (let i = 0; i < numCourses; i++) {
        graph[i] = [];
        indegree[i] = 0;
    }

    for (let req of prerequisites) {
        let [to, from] = req;
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
        for (let next of graph[course]) {
            indegree[next]--;
            if (indegree[next] === 0) {
                queue.push(next);
            }
        }
    }

    return count === numCourses;

};
// @lc code=end

