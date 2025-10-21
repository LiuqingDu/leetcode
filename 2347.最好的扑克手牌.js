/*
 * @lc app=leetcode.cn id=2347 lang=javascript
 *
 * [2347] 最好的扑克手牌
 */

// @lc code=start
/**
 * @param {number[]} ranks
 * @param {character[]} suits
 * @return {string}
 */
var bestHand = function(ranks, suits) {
    const suitsSet = new Set();
    for (const suit of suits) {
        suitsSet.add(suit);
    }
    if (suitsSet.size === 1) {
        return "Flush";
    }
    const h = new Map();
    for (const rank of ranks) {
        h.set(rank, (h.get(rank) || 0) + 1);
    }
    if (h.size === 5) {
        return "High Card";
    }
    for (const value of h.values()) {
        if (value > 2) {
            return "Three of a Kind";
        }
    }
    return "Pair";
};
// @lc code=end

