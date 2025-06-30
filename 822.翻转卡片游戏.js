/*
 * @lc app=leetcode.cn id=822 lang=javascript
 *
 * [822] 翻转卡片游戏
 */

// @lc code=start
/**
 * @param {number[]} fronts
 * @param {number[]} backs
 * @return {number}
 */
var flipgame = function(fronts, backs) {
    let set = new Set();
    for (let i = 0; i < fronts.length; i++) {
        if (fronts[i] === backs[i]) {
            set.add(fronts[i]);
        }
    }
    let min = Infinity;
    for (let i = 0; i < fronts.length; i++) {
        if (!set.has(fronts[i])) {
            min = Math.min(min, fronts[i]);
        }
        if (!set.has(backs[i])) {
            min = Math.min(min, backs[i]);
        }
    }
    return min === Infinity ? 0 : min;
};
// @lc code=end

