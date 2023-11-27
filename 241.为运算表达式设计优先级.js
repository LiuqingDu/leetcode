/*
 * @lc app=leetcode.cn id=241 lang=javascript
 *
 * [241] 为运算表达式设计优先级
 */

// @lc code=start
/**
 * @param {string} expression
 * @return {number[]}
 */
var diffWaysToCompute = function(expression) {

    let memo = new Map();

    let compute = function(exp) {
        if (memo.has(exp)) {
            return memo.get(exp);
        }

        let res = [];

        for (let i = 0; i < exp.length; i++) {
            let c = exp.charAt(i);

            if (c === '+' || c === '-' || c === '*') {
                let left = compute(exp.substring(0, i));
                let right = compute(exp.substring(i + 1));

                for (let l of left) {
                    for (let r of right) {
                        if (c === "+") {
                            res.push(parseInt(l) + parseInt(r));
                        }
                        if (c === "-") {
                            res.push(parseInt(l) - parseInt(r));
                        }
                        if (c === "*") {
                            res.push(parseInt(l) * parseInt(r));
                        }
                    }
                }

            }
        }

        if (!res.length) {
            res.push(parseInt(exp));
        }

        memo.set(exp, res);

        return res;
    }

    return compute(expression);
};
// @lc code=end

