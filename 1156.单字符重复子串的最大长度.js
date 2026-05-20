/*
 * @lc app=leetcode.cn id=1156 lang=javascript
 *
 * [1156] 单字符重复子串的最大长度
 */

// @lc code=start
/**
 * @param {string} text
 * @return {number}
 */
var maxRepOpt1 = function(text) {

    // 统计每个字符出现次数
    const cnt = new Array(26).fill(0);

    for (let c of text) {
        cnt[c.charCodeAt(0) - 97]++;
    }

    const n = text.length;
    let ans = 0;

    // 枚举每一段连续字符
    for (let i = 0; i < n; ) {

        let j = i;

        // 找连续相同字符段
        while (j < n && text[j] === text[i]) {
            j++;
        }

        // 当前段长度
        let len = j - i;

        // 情况1：
        // 当前段还能再交换一个相同字符进来
        ans = Math.max(
            ans,
            Math.min(
                len + 1,
                cnt[text.charCodeAt(i) - 97]
            )
        );

        // 情况2：
        // aaa b aaa
        let k = j + 1;

        // 中间只有一个不同字符
        if (
            j < n &&
            k < n &&
            text[k] === text[i]
        ) {

            // 找右边连续段
            while (
                k < n &&
                text[k] === text[i]
            ) {
                k++;
            }

            // 左段 + 右段
            let total = (j - i) + (k - j - 1);

            ans = Math.max(
                ans,
                Math.min(
                    total + 1,
                    cnt[text.charCodeAt(i) - 97]
                )
            );
        }

        // 跳到下一段
        i = j;
    }

    return ans;
};
// @lc code=end

