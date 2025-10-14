/*
 * @lc app=leetcode.cn id=948 lang=javascript
 *
 * [948] 令牌放置
 */

// @lc code=start
/**
 * @param {number[]} tokens
 * @param {number} power
 * @return {number}
 */
var bagOfTokensScore = function (tokens, power) {
    tokens.sort((a, b) => a - b);
    let left = 0, right = tokens.length - 1;
    let score = 0, maxScore = 0;
    while (left <= right) {
        if (power >= tokens[left]) {
            power -= tokens[left++];
            score++;
            maxScore = Math.max(maxScore, score);
        } else if (score > 0) {
            power += tokens[right--];
            score--;
        } else {
            break;
        }
    }
    return maxScore;
};
// @lc code=end

