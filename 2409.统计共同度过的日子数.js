/*
 * @lc app=leetcode.cn id=2409 lang=javascript
 *
 * [2409] 统计共同度过的日子数
 */

// @lc code=start
/**
 * @param {string} arriveAlice
 * @param {string} leaveAlice
 * @param {string} arriveBob
 * @param {string} leaveBob
 * @return {number}
 */
var countDaysTogether = function(arriveAlice, leaveAlice, arriveBob, leaveBob) {
    function calculateDayOfYear(day, prefixSum) {
        let month = parseInt(day.substring(0, 2));
        let date = parseInt(day.substring(3));
        return prefixSum[month - 1] + date;
    }

    let datesOfMonths = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
    let prefixSum = [0];
    for (let i = 0; i < datesOfMonths.length; i++) {
        prefixSum.push(prefixSum[i] + datesOfMonths[i]);
    }

    let arriveAliceDay = calculateDayOfYear(arriveAlice, prefixSum);
    let leaveAliceDay = calculateDayOfYear(leaveAlice, prefixSum);
    let arriveBobDay = calculateDayOfYear(arriveBob, prefixSum);
    let leaveBobDay = calculateDayOfYear(leaveBob, prefixSum);

    return Math.max(0, Math.min(leaveAliceDay, leaveBobDay) - Math.max(arriveAliceDay, arriveBobDay) + 1);
};
// @lc code=end

