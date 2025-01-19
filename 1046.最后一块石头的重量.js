/*
 * @lc app=leetcode.cn id=1046 lang=javascript
 *
 * [1046] 最后一块石头的重量
 */

// @lc code=start
/**
 * @param {number[]} stones
 * @return {number}
 */
var lastStoneWeight = function(stones) {
    // js 没有优先队列/大根堆
    // 用递归 + sort

    stones.sort((a, b) => a - b)
    if (stones.length > 1) {
        const d = stones.pop() - stones.pop()
        if (d) stones.push(d)
        return lastStoneWeight(stones)
    }
    return stones.length ? stones[0] : 0
};
// @lc code=end

