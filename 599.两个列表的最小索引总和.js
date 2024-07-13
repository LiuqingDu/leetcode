/*
 * @lc app=leetcode.cn id=599 lang=javascript
 *
 * [599] 两个列表的最小索引总和
 */

// @lc code=start
/**
 * @param {string[]} list1
 * @param {string[]} list2
 * @return {string[]}
 */
var findRestaurant = function(list1, list2) {
    let map = new Map();
    for (let i = 0; i < list1.length; i++) {
        map.set(list1[i], i);
    }

    let res = [];
    let sum = Number.MAX_VALUE;
    for (let i = 0; i < list2.length; i++) {
        if (map.has(list2[i])) {
            let j = map.get(list2[i]);
            if (i + j < sum) {
                res = [];
                res.push(list2[i]);
                sum = i + j;
            } else if (i + j === sum) {
                res.push(list2[i]);
            }
        }
    }
    return res;
};
// @lc code=end

