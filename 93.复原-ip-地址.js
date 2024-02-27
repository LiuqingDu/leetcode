/*
 * @lc app=leetcode.cn id=93 lang=javascript
 *
 * [93] 复原 IP 地址
 */

// @lc code=start
/**
 * @param {string} s
 * @return {string[]}
 */
var restoreIpAddresses = function(s) {

    let n = s.length;
    let res = [];

    let backtrace = function(i, cur) {
        if (cur.length === 4) {
            if (i === n) {
                res.push(cur.join("."));
                return;
            }
            return;
        }
        for (let j = 1; j <= 3 && i + j <= n; j++) {
            let sub = s.substring(i, i + j);
            if (sub.charAt(0) === '0' && j > 1) {
                return;
            }
            if (parseInt(sub) > 255) {
                return;
            }
            cur.push(sub);
            backtrace(i + j, cur);
            cur.pop();
        }
    }

    backtrace(0, []);

    return res;

};
// @lc code=end

