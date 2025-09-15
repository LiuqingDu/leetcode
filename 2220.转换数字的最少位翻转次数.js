/*
 * @lc app=leetcode.cn id=2220 lang=javascript
 *
 * [2220] 转换数字的最少位翻转次数
 */

// @lc code=start
/**
 * @param {number} start
 * @param {number} goal
 * @return {number}
 */
var minBitFlips = function(start, goal) {
    let res = 0;
    // start和goal取或，只要大于0就说明剩下的部分不是0，还有数字需要处理
    while ((start | goal) > 0) {
        // 每次处理最后一位
        // 跟1进行与运算，取出最后一位数字
        let a = start & 1, b = goal & 1;
        // 两个最后一位数字比较，异或就是看这两位是不是不同
        res += a ^ b;
        // 两个数往右挪一位，继续处理
        start >>= 1;
        goal >>= 1;
    }
    return res;
};
// @lc code=end

