/*
 * @lc app=leetcode.cn id=2351 lang=javascript
 *
 * [2351] 第一个出现两次的字母
 */

// @lc code=start
/**
 * @param {string} s
 * @return {character}
 */
var repeatedCharacter = function(s) {
    let seen = 0;
    for (let i = 0; i < s.length; i++) {
        const ch = s[i];
        const x = ch.charCodeAt() - 'a'.charCodeAt();
        if ((seen & (1 << x)) !== 0) {
            return ch;
        }
        seen |= (1 << x);
    }
    // impossible
    return ' ';
};
// @lc code=end

