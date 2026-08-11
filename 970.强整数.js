/*
 * @lc app=leetcode.cn id=970 lang=javascript
 *
 * [970] 强整数
 */

// @lc code=start
/**
 * @param {number} x
 * @param {number} y
 * @param {number} bound
 * @return {number[]}
 */
var powerfulIntegers = function(x, y, bound) {
    
    const set = new Set();
    let value1 = 1;
    for (let i = 0; i < 21; i++) {
        let value2 = 1;
        for (let j = 0; j < 21; j++) {
            let value = value1 + value2;
            if (value <= bound) {
                set.add(value);
            } else {
                break;
            }
            value2 *= y;
        }
        if (value1 > bound) {
            break;
        }
        value1 *= x;
    }
    return [...set];

};
// @lc code=end

