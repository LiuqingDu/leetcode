/*
 * @lc app=leetcode.cn id=402 lang=javascript
 *
 * [402] 移掉 K 位数字
 */

// @lc code=start
/**
 * @param {string} num
 * @param {number} k
 * @return {string}
 */
var removeKdigits = function(num, k) {
    
    const stack = [];
    
    for (let digit of num) {
        while (k > 0 && stack.length > 0 && stack[stack.length - 1] > digit) {
            stack.pop();
            k--;
        }
        stack.push(digit);
    }
    
    stack.splice(stack.length - k, k);

    // 去除前导零
    let index = 0;
    while (index < stack.length && stack[index] === '0') {
        index++;
    }

    // 提取有效数字部分
    const result = stack.slice(index).join('');
    
    return result === '' ? '0' : result;
};
// @lc code=end

