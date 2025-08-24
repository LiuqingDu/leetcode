/*
 * @lc app=leetcode.cn id=875 lang=javascript
 *
 * [875] 爱吃香蕉的珂珂
 */

// @lc code=start
/**
 * @param {number[]} piles
 * @param {number} h
 * @return {number}
 */
var minEatingSpeed = function(piles, h) {
    const getHours = (piles, speed) => {
        let hours = 0;
        for (const pile of piles) {
            const curHours = Math.ceil(pile / speed);
            hours += curHours;
        }
        return hours;
    }
    let left = 1, right = Math.max(...piles);
    while (left < right) {
        const mid = Math.floor((left + right) / 2);
        if (getHours(piles, mid) <= h) {
            right = mid;
        } else {
            left = mid + 1;
        }
    }
    return left;
};
// @lc code=end

