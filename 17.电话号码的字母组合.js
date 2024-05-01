/*
 * @lc app=leetcode.cn id=17 lang=javascript
 *
 * [17] 电话号码的字母组合
 */

// @lc code=start
/**
 * @param {string} digits
 * @return {string[]}
 */
var letterCombinations = function(digits) {

    const map = ["", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"];
    const res = [];
    const digit = digits.split("");
    const path = [];

    if (digits.length === 0) {
        return [];
    }

    let dfs = function(i) {
        if (i === digit.length) {
            res.push(path.join(""));
            return;
        }

        for (let c of map[digit[i]].split("")) {
            path[i] = c;
            dfs(i + 1);
        }
    }

    dfs(0);

    return res;

};
// @lc code=end

