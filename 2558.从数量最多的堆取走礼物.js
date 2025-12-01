/*
 * @lc app=leetcode.cn id=2558 lang=javascript
 *
 * [2558] 从数量最多的堆取走礼物
 */

// @lc code=start
/**
 * @param {number[]} gifts
 * @param {number} k
 * @return {number}
 */
var pickGifts = function(gifts, k) {
    // 用 sort 维持最大值在最后（降序）
    gifts.sort((a, b) => b - a);

    while (k-- > 0) {
        const x = gifts[0];              // 最大值
        gifts[0] = Math.floor(Math.sqrt(x));
        
        // 只需要把第 0 个往下调整即可
        let i = 0;
        while (true) {
            let left = 2 * i + 1;
            let right = 2 * i + 2;
            let largest = i;

            if (left < gifts.length && gifts[left] > gifts[largest]) largest = left;
            if (right < gifts.length && gifts[right] > gifts[largest]) largest = right;
            if (largest === i) break;

            [gifts[i], gifts[largest]] = [gifts[largest], gifts[i]];
            i = largest;
        }
    }

    return gifts.reduce((sum, x) => sum + x, 0);
};
// @lc code=end

