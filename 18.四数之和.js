/*
 * @lc app=leetcode.cn id=18 lang=javascript
 *
 * [18] 四数之和
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[][]}
 */
var fourSum = function(nums, target) {

    let res = [];

    if (nums.length < 4) {
        return res;
    }

    nums.sort((a, b) => a - b);

    for (let a = 0; a < nums.length - 3; a++) {
        if (a > 0 && nums[a] == nums[a - 1]) {
            continue;
        }
        for (let b = a + 1; b < nums.length - 2; b++) {
            if (b > a + 1 && nums[b] == nums[b - 1]) {
                continue;
            }
            let c = b + 1;
            let d = nums.length - 1;
            while (c < d) {
                let sum = nums[a] + nums[b] + nums[c] + nums[d];
                if (sum == target) {
                    res.push([nums[a], nums[b], nums[c], nums[d]]);
                    do {
                        c++;
                    } while (c < d && nums[c] == nums[c - 1]);
                    do {
                        d--;
                    } while (c < d && nums[d] == nums[d + 1]);
                } else if (sum < target) {
                    c++;
                } else {
                    d--;
                }
            }
        }
    }

    return res;

};
// @lc code=end

