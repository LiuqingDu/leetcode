/*
 * @lc app=leetcode.cn id=1297 lang=javascript
 *
 * [1297] 子串的最大出现次数
 */

// @lc code=start
/**
 * @param {string} s
 * @param {number} maxLetters
 * @param {number} minSize
 * @param {number} maxSize
 * @return {number}
 */
var maxFreq = function(s, maxLetters, minSize, maxSize) {
    const map = new Map();
    const count = new Array(26).fill(0);

    let left = 0;
    let unique = 0;
    let res = 0;

    for (let right = 0; right < s.length; right++) {
        // 加入右边字符
        let idx = s.charCodeAt(right) - 97;
        if (count[idx] === 0) unique++;
        count[idx]++;

        // 保持窗口大小 = minSize
        if (right - left + 1 > minSize) {
            let leftIdx = s.charCodeAt(left) - 97;
            count[leftIdx]--;
            if (count[leftIdx] === 0) unique--;
            left++;
        }

        // 满足条件
        if (right - left + 1 === minSize && unique <= maxLetters) {
            const sub = s.substring(left, right + 1);
            const freq = (map.get(sub) || 0) + 1;
            map.set(sub, freq);
            res = Math.max(res, freq);
        }
    }

    return res;
};
// @lc code=end

