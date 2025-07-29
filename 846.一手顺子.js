/*
 * @lc app=leetcode.cn id=846 lang=javascript
 *
 * [846] 一手顺子
 */

// @lc code=start
/**
 * @param {number[]} hand
 * @param {number} groupSize
 * @return {boolean}
 */
var isNStraightHand = function(hand, groupSize) {
    if (hand.length % groupSize !== 0) {
        return false;
    }
    hand.sort((a, b) => a - b);
    const count = new Map();
    for (const card of hand) {
        count.set(card, (count.get(card) || 0) + 1);
    }
    for (const card of hand) {
        if (count.get(card) === 0) {
            continue;
        }
        for (let i = 0; i < groupSize; i++) {
            const nextCard = card + i;
            if (!count.has(nextCard) || count.get(nextCard) === 0) {
                return false;
            }
            count.set(nextCard, count.get(nextCard) - 1);
        }
    }
    return true;
};
// @lc code=end

