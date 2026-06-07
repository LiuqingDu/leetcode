/*
 * @lc app=leetcode.cn id=1405 lang=javascript
 *
 * [1405] 最长快乐字符串
 */

// @lc code=start
/**
 * @param {number} a
 * @param {number} b
 * @param {number} c
 * @return {string}
 */
var longestDiverseString = function(a, b, c) {
    
    let res = [];
    
    // 用一个数组存储字母和对应的数量
    let arr = [
        { ch: 'a', count: a },
        { ch: 'b', count: b },
        { ch: 'c', count: c }
    ];

    while (true) {
        // 1. 每次循环，直接按数量从大到小排序
        arr.sort((x, y) => y.count - x.count);
        
        // 数量最多、次多、最少的字母分别是：arr[0], arr[1], arr[2]
        let max = arr[0];
        let mid = arr[1];

        // 如果连最多的字母都变成 0 了，说明没字母可用了，直接结束
        if (max.count === 0) break;

        let len = res.length;
        // 2. 检查最后两位是不是已经是数量最多的字母了
        if (len >= 2 && res[len - 1] === max.ch && res[len - 2] === max.ch) {
            // 如果是，说明不能再放 max 了，被迫看“次多”的字母
            if (mid.count === 0) {
                // 如果连次多的字母也是 0，说明后面没办法凑了，直接结束
                break;
            }
            // 使用次多的字母
            res.push(mid.ch);
            mid.count--;
        } else {
            // 3. 正常情况，安全！直接放数量最多的字母
            res.push(max.ch);
            max.count--;
        }
    }

    return res.join('');
};
// @lc code=end

