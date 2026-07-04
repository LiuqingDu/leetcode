/*
 * @lc app=leetcode.cn id=638 lang=javascript
 *
 * [638] 大礼包
 */

// @lc code=start
/**
 * @param {number[]} price
 * @param {number[][]} special
 * @param {number[]} needs
 * @return {number}
 */
var shoppingOffers = function(price, special, needs) {
    
    const memo = new Map();

    const dfs = (curNeeds) => {
        // 将数组转为字符串作为 Map 的 Key
        const key = curNeeds.join(',');
        if (memo.has(key)) {
            return memo.get(key);
        }

        // 1. 基础方案：全按单价买
        let minPrice = 0;
        for (let i = 0; i < curNeeds.length; i++) {
            minPrice += curNeeds[i] * price[i];
        }

        // 2. 尝试每一种大礼包
        for (const sp of special) {
            const nextNeeds = [];
            let valid = true;

            // 检查大礼包是否超出了当前 needs
            for (let i = 0; i < curNeeds.length; i++) {
                if (sp[i] > curNeeds[i]) {
                    valid = false;
                    break;
                }
                nextNeeds.push(curNeeds[i] - sp[i]);
            }

            // 如果该大礼包合法（没有买超），进入下一层递归
            if (valid) {
                const specialPrice = sp[curNeeds.length];
                minPrice = Math.min(minPrice, specialPrice + dfs(nextNeeds));
            }
        }

        memo.set(key, minPrice);
        return minPrice;
    };

    return dfs(needs);
};
// @lc code=end

