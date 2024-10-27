/*
 * @lc app=leetcode.cn id=406 lang=javascript
 *
 * [406] 根据身高重建队列
 */

// @lc code=start
/**
 * @param {number[][]} people
 * @return {number[][]}
 */
var reconstructQueue = function(people) {
    people.sort((p1, p2) => {
        if (p1[0] !== p2[0]) {
            return p2[0] - p1[0];
        } else {
            return p1[1] - p2[1];
        }
    });
    
    let list = [];
    for (let i = 0; i < people.length; i++) {
        if (list.length > people[i][1]) {
            list.splice(people[i][1], 0, people[i]);
        } else {
            list.push(people[i]);
        }
    }
    
    return list;
};
// @lc code=end

