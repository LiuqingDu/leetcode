/*
 * @lc app=leetcode.cn id=2432 lang=javascript
 *
 * [2432] 处理用时最长的那个任务的员工
 */

// @lc code=start
/**
 * @param {number} n
 * @param {number[][]} logs
 * @return {number}
 */
var hardestWorker = function(n, logs) {
    let maxTime = -1;
    let employeeId = -1;
    let prevTime = 0;

    for (let i = 0; i < logs.length; i++) {
        const [id, endTime] = logs[i];
        const taskTime = endTime - prevTime;

        if (taskTime > maxTime || (taskTime === maxTime && id < employeeId)) {
            maxTime = taskTime;
            employeeId = id;
        }

        prevTime = endTime;
    }

    return employeeId;
};
// @lc code=end

