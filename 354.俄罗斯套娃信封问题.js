/*
 * @lc app=leetcode.cn id=354 lang=javascript
 *
 * [354] 俄罗斯套娃信封问题
 */

// @lc code=start
/**
 * @param {number[][]} envelopes
 * @return {number}
 */
var maxEnvelopes = function(envelopes) {

    envelopes.sort((a, b) => {
        if (a[0] === b[0]) {
            return b[1] - a[1];
        } else {
            return a[0] - b[0];
        }
    });

    let heights = [];

    for (let en of envelopes) {
        heights.push(en[1]);
    }

    let lengthOfLIS = function(arr) {
        let n = arr.length;
        let top = [];
        let piles = 0;

        for (let i = 0; i < n; i++) {
            let poker = arr[i];
            let left = 0, right = piles;
            while (left < right) {
                let mid = Math.floor((right - left) / 2) + left;
                if (top[mid] > poker) {
                    right = mid;
                } else if (top[mid] < poker) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            if (left == piles) {
                piles++;
            }
            top[left] = poker;
        }

        return piles;
    }

    return lengthOfLIS(heights);

};
// @lc code=end

