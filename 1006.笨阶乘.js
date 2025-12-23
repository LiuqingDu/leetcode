/*
 * @lc app=leetcode.cn id=1006 lang=javascript
 *
 * [1006] 笨阶乘
 */

// @lc code=start
/**
 * @param {number} n
 * @return {number}
 */
var clumsy = function(n) {
    const stack = [n--];

    let index = 0; // 用于控制乘、除、加、减
    while (n > 0) {
        if (index % 4 == 0) {
            stack.push(stack.pop() * n);
        } else if (index % 4 == 1) {
            const cur = stack.pop();
            stack.push(cur > 0 ? Math.floor(cur / n) : Math.ceil(cur / n));
        } else if (index % 4 == 2) {
            stack.push(n);
        } else {
            stack.push(-n);
        }
        index++;
        n--;
    }

    // 把栈中所有的数字依次弹出求和
    let sum = 0;
    stack.forEach((element) => {
        sum += element;
    })
    return sum;
};
// @lc code=end

