/*
 * @lc app=leetcode.cn id=475 lang=javascript
 *
 * [475] 供暖器
 */

// @lc code=start
/**
 * @param {number[]} houses
 * @param {number[]} heaters
 * @return {number}
 */
var findRadius = function(houses, heaters) {
    houses.sort((a, b) => a - b);
    heaters.sort((a, b) => a - b);

    let radius = 0;
    let heaterIndex = 0;

    for (let house of houses) {
        while (heaterIndex < heaters.length - 1
                && Math.abs(heaters[heaterIndex + 1] - house) <= Math.abs(heaters[heaterIndex] - house)) {
            heaterIndex++;
        }
        radius = Math.max(radius, Math.abs(heaters[heaterIndex] - house));
    }

    return radius;
};
// @lc code=end

