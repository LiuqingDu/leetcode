/*
 * @lc app=leetcode.cn id=227 lang=javascript
 *
 * [227] 基本计算器 II
 */

// @lc code=start
/**
 * @param {string} s
 * @return {number}
 */
var calculate = function(s) {
    let map = {
        '-': 1,
        '+': 1,
        '*': 2,
        '/': 2,
        '%': 2,
        '^': 3
    };

    s = s.replaceAll(" ", "");
    let nums = [0];
    let ops = [];

    for (let i = 0; i < s.length; i++) {
        let c = s[i];

        if (c === "(") {
            ops.push(c);
        } else if (c === ")") {
            while (ops.length) {
                if (ops[ops.length - 1] !== "(") {
                    calc(nums, ops);
                } else {
                    ops.pop();
                    break;
                }
            }
        } else {
            if (isNumber(c)) {
                let num = 0;
                let j = i;
                while (j < s.length && isNumber(s[j])) {
                    num = num * 10 + (s.charCodeAt(j) - "0".charCodeAt(0));
                    j++;
                }
                nums.push(num);
                i = j - 1;
            } else {
                if (i > 0 && (s[i - 1] === "(" || s[i - 1] === "+" || s[i - 1] === "-")) {
                    nums.push(0);
                }
                while (ops.length && ops[ops.length - 1] !== "(") {
                    let pre = ops[ops.length - 1];
                    if (map[pre] >= map[c]) {
                        calc(nums, ops);
                    } else {
                        break;
                    }
                }
                ops.push(c);
            }
        }
    }

    while (ops.length) {
        calc(nums, ops);
    }
    return nums[nums.length - 1];
};

var calc = function(nums, ops) {
    if (!nums.length || nums.length < 2) {
        return;
    }
    if (!ops.length) {
        return;
    }

    let b = nums.pop(), a = nums.pop();
    let op = ops.pop();
    let res = 0;
    if (op === "+") {
        res = a + b;
    } else if (op === "-") {
        res = a - b;
    } else if (op === "*") {
        res = a * b;
    } else if (op === "/") {
        res = Math.floor(a / b);
    } else if (op === "^") {
        res = Math.pow(a, b);
    } else if (op === "%") {
        res = a % b;
    }
    nums.push(res);
}

var isNumber = function(c) {
    return !isNaN(c);
}
// @lc code=end

