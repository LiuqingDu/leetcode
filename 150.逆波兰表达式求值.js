/*
 * @lc app=leetcode.cn id=150 lang=javascript
 *
 * [150] 逆波兰表达式求值
 */

// @lc code=start
/**
 * @param {string[]} tokens
 * @return {number}
 */
var evalRPN = function(tokens) {

    let stack = [];

    tokens.forEach(v => {
        switch(v) {
            case "+":
                b = stack.pop();
                a = stack.pop();
                stack.push(a + b);
                break;
            case "-":
                b = stack.pop();
                a = stack.pop();
                stack.push(a - b);
                break;
            case "*":
                b = stack.pop();
                a = stack.pop();
                stack.push(a * b);
                break;
            case "/":
                b = stack.pop();
                a = stack.pop();
                stack.push(parseInt(a / b));
                break;
            default:
                stack.push(Number(v));
                break;
        }
    })

    return stack.pop();
};
// @lc code=end

