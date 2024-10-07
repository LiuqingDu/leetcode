/*
 * @lc app=leetcode.cn id=229 lang=javascript
 *
 * [229] 多数元素 II
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number[]}
 */
var majorityElement = function(nums) {
    let card1 = nums[0], count1 = 0;
    let card2 = nums[0], count2 = 0;

    for (let num of nums) {
        if (card1 === num) {
            count1++;
            continue;
        }

        if (card2 === num) {
            count2++;
            continue;
        }

        if (count1 === 0) {
            card1 = num;
            count1 = 1;
            continue;
        }

        if (count2 === 0) {
            card2 = num;
            count2 = 1;
            continue;
        }

        count1--;
        count2--;
    }

    count1 = 0;
    count2 = 0;
    for (let num of nums) {
        if (card1 === num) {
            count1++;
        } else if (card2 === num) {
            count2++;
        }
    }

    let res = [];
    if (count1 > nums.length / 3) {
        res.push(card1);
    }
    if (count2 > nums.length / 3) {
        res.push(card2);
    }

    return res;
};
// @lc code=end

