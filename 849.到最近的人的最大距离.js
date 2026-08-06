/*
 * @lc app=leetcode.cn id=849 lang=javascript
 *
 * [849] 到最近的人的最大距离
 */

// @lc code=start
/**
 * @param {number[]} seats
 * @return {number}
 */
var maxDistToClosest = function(seats) {
    
    let res = 0, l = 0;
    // 左边第一个人
    while (l < seats.length && seats[l] === 0) {
        l++;
    }
    res = Math.max(res, l);

    while (l < seats.length) {
        // 紧接着右边的人
        let r = l + 1;
        while (r < seats.length && seats[r] === 0) {
            r++;
        }
        // 跳出座位右边界，表示右边的座位都没人，最近的人就是左边那个
        if (r === seats.length) {
            res = Math.max(res, r - l - 1);
        } else {
            // 右边有人，最近的距离是和左边那个人之间的距离/2
            res = Math.max(res, parseInt((r - l) / 2));
        }
        l = r;
    }
    return res;

};
// @lc code=end

