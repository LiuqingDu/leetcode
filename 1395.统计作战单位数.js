/*
 * @lc app=leetcode.cn id=1395 lang=javascript
 *
 * [1395] 统计作战单位数
 */

// @lc code=start
/**
 * @param {number[]} rating
 * @return {number}
 */
var numTeams = function(rating) {
    
    const n = rating.length;
    if (n < 3) return 0;

    let totalTeams = 0;

    // j 作为中间人，取值范围在 1 到 n - 2 之间
    for (let j = 1; j < n - 1; j++) {
        let leftLess = 0;
        let leftGreater = 0;
        let rightLess = 0;
        let rightGreater = 0;

        // 统计左边
        for (let i = 0; i < j; i++) {
            if (rating[i] < rating[j]) leftLess++;
            else if (rating[i] > rating[j]) leftGreater++;
        }

        // 统计右边
        for (let k = j + 1; k < n; k++) {
            if (rating[k] < rating[j]) rightLess++;
            else if (rating[k] > rating[j]) rightGreater++;
        }

        // 累加组合数
        totalTeams += (leftLess * rightGreater) + (leftGreater * rightLess);
    }

    return totalTeams;
};
// @lc code=end

