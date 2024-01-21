/*
 * @lc app=leetcode.cn id=986 lang=javascript
 *
 * [986] 区间列表的交集
 */

// @lc code=start
/**
 * @param {number[][]} firstList
 * @param {number[][]} secondList
 * @return {number[][]}
 */
var intervalIntersection = function(firstList, secondList) {

    let res = [];

    let i = 0, j = 0;

    while (i < firstList.length && j < secondList.length) {
        let left = Math.max(firstList[i][0], secondList[j][0]);
        let right = Math.min(firstList[i][1], secondList[j][1]);

        if (left <= right) {
            res.push([left, right]);
        }
        if (firstList[i][1] < secondList[j][1]) {
            i++;
        } else {
            j++;
        }
    }

    return res;

};
// @lc code=end

