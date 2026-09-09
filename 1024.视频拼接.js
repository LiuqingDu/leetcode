/*
 * @lc app=leetcode.cn id=1024 lang=javascript
 *
 * [1024] 视频拼接
 */

// @lc code=start
/**
 * @param {number[][]} clips
 * @param {number} time
 * @return {number}
 */
var videoStitching = function(clips, time) {
    
    const dp = new Array(time + 1).fill(Infinity);
    dp[0] = 0;

    for (let i = 1; i <= time; i++) {
        for (const [start, end] of clips) {
            if (start < i && i <= end) {
                dp[i] = Math.min(dp[i], dp[start] + 1);
            }
        }
    }

    return dp[time] === Infinity ? -1 : dp[time];
};
// @lc code=end

