/*
 * @lc app=leetcode.cn id=1338 lang=javascript
 *
 * [1338] 数组大小减半
 */

// @lc code=start
/**
 * @param {number[]} arr
 * @return {number}
 */
var minSetSize = function(arr) {

    // 1. 统计每个数字出现次数
    const map = new Map();

    for (let num of arr) {
        map.set(num, (map.get(num) || 0) + 1);
    }

    // 2. 取出所有出现次数
    const counts = Array.from(map.values());

    // 3. 从大到小排序
    counts.sort((a, b) => b - a);

    // 4. 贪心删除
    let removed = 0;
    let ans = 0;
    const half = arr.length / 2;

    for (let count of counts) {
        removed += count;
        ans++;

        // 删除到一半即可
        if (removed >= half) {
            return ans;
        }
    }
};
// @lc code=end

