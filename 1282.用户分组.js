/*
 * @lc app=leetcode.cn id=1282 lang=javascript
 *
 * [1282] 用户分组
 */

// @lc code=start
/**
 * @param {number[]} groupSizes
 * @return {number[][]}
 */
var groupThePeople = function(groupSizes) {
    
    const result = [];
    const map = new Map(); // key: group size, value: 当前收集的人

    for (let i = 0; i < groupSizes.length; i++) {
        const size = groupSizes[i];
        if (!map.has(size)) map.set(size, []);
        map.get(size).push(i);

        // 当人数达到组大小时，把组加入结果，并清空临时列表
        if (map.get(size).length === size) {
            result.push([...map.get(size)]);
            map.set(size, []); // 清空临时列表
        }
    }

    return result;
};
// @lc code=end

