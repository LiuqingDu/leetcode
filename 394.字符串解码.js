/*
 * @lc app=leetcode.cn id=394 lang=javascript
 *
 * [394] 字符串解码
 */

// @lc code=start
/**
 * @param {string} s
 * @return {string}
 */
var decodeString = function(s) {
    let times = [];
    let strs = [];

    let res = "";
    let time = 0;

    let n = s.length;

    for (let i = 0; i < n; i++) {
        if (s[i] === "[") {
            times.push(time);
            strs.push(res);
            time = 0;
            res = "";
        } else if (s[i] === "]") {
            let s = "";
            let t = times.pop();
            for (let j = 0; j < t; j++) {
                s += res;
            }
            res = strs.pop() + s;
        } else if (s.charCodeAt(i) >= "0".charCodeAt(0) && s.charCodeAt(i) <= "9".charCodeAt(0)) {
            time = time * 10 + Number.parseInt(s[i]);
        } else {
            res += s[i];
        }
    }

    return res;
};
// @lc code=end

