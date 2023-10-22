/*
 * @lc app=leetcode.cn id=76 lang=javascript
 *
 * [76] 最小覆盖子串
 */

// @lc code=start
/**
 * @param {string} s
 * @param {string} t
 * @return {string}
 */
var minWindow = function(s, t) {

    let target = new Map();
    let window = new Map();

    for (let i = 0; i < t.length; i++) {
        target.set(t.charAt(i), (target.get(t.charAt(i)) || 0) + 1);
    }

    let left = 0, right = 0;
    let valid = 0;
    let start = 0, len = Number.MAX_VALUE;

    while(right < s.length) {
        let c = s.charAt(right);
        right++;

        if (target.has(c)) {
            window.set(c, (window.get(c) || 0) + 1);
            if (window.get(c) === target.get(c)) {
                valid++;
            }
        }

        while(valid === target.size) {
            if (right - left < len) {
                start = left;
                len = right - left;
            }

            let d = s.charAt(left);
            left++;

            if (target.has(d)) {
                if (window.get(d) === target.get(d)) {
                    valid--;
                }
                window.set(d, window.get(d) - 1);
            }

        }
    }

    return len === Number.MAX_VALUE ? "" : s.substring(start, start + len);

};
// @lc code=end

