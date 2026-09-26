/*
 * @lc app=leetcode.cn id=3304 lang=javascript
 *
 * [3304] 找出第 K 个字符 I
 */

// @lc code=start
/**
 * @param {number} k
 * @return {character}
 */
var kthCharacter = function(k) {
    
    let ans = 0;
    while (k !== 1) {
        let t = 31 - Math.clz32(k);
        if ((1 << t) === k) {
            t--;
        }
        k -= 1 << t;
        ans++;
    }
    return String.fromCharCode('a'.charCodeAt(0) + ans);

};
// @lc code=end

