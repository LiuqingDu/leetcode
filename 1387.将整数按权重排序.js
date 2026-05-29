/*
 * @lc app=leetcode.cn id=1387 lang=javascript
 *
 * [1387] 将整数按权重排序
 */

// @lc code=start
/**
 * @param {number} lo
 * @param {number} hi
 * @param {number} k
 * @return {number}
 */
var getKth = function(lo, hi, k) {
    const map = new Map();

    function getWeight(x) {

        if (x === 1) return 0;

        if (map.has(x)) {
            return map.get(x);
        }

        let ans;

        if (x % 2 === 0) {
            ans = 1 + getWeight(x / 2);
        } else {
            ans = 1 + getWeight(3 * x + 1);
        }

        map.set(x, ans);

        return ans;
    }

    let arr = [];

    for (let i = lo; i <= hi; i++) {
        arr.push(i);
    }

    arr.sort((a, b) => {

        let wa = getWeight(a);
        let wb = getWeight(b);

        if (wa !== wb) {
            return wa - wb;
        }

        return a - b;
    });

    return arr[k - 1];
};
// @lc code=end

