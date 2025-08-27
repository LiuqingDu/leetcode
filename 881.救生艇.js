/*
 * @lc app=leetcode.cn id=881 lang=javascript
 *
 * [881] 救生艇
 */

// @lc code=start
/**
 * @param {number[]} people
 * @param {number} limit
 * @return {number}
 */
var numRescueBoats = function(people, limit) {
    people = people.sort((a, b) => a - b);
    let res = 0;
    let left = 0, right = people.length - 1;
    while (left <= right) {
        if (people[left] + people[right] <= limit) {
            res++;
            left++;
            right--;
        } else {
            res++;
            right--;
        }
    }
    return res;
};
// @lc code=end

