/*
 * @lc app=leetcode.cn id=1333 lang=javascript
 *
 * [1333] 餐厅过滤器
 */

// @lc code=start
/**
 * @param {number[][]} restaurants
 * @param {number} veganFriendly
 * @param {number} maxPrice
 * @param {number} maxDistance
 * @return {number[]}
 */
var filterRestaurants = function(restaurants, veganFriendly, maxPrice, maxDistance) {
    // 1. 过滤
    let list = restaurants.filter(r => {

        // 素食过滤
        if (veganFriendly === 1 && r[2] !== 1) {
            return false;
        }

        // 价格过滤
        if (r[3] > maxPrice) {
            return false;
        }

        // 距离过滤
        if (r[4] > maxDistance) {
            return false;
        }

        return true;
    });

    // 2. 排序
    list.sort((a, b) => {

        // rating 降序
        if (a[1] !== b[1]) {
            return b[1] - a[1];
        }

        // id 降序
        return b[0] - a[0];
    });

    // 3. 取出 id
    return list.map(r => r[0]);
};
// @lc code=end

