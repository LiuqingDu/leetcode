/*
 * @lc app=leetcode.cn id=1249 lang=javascript
 *
 * [1249] 移除无效的括号
 */

// @lc code=start
/**
 * @param {string} s
 * @return {string}
 */
var minRemoveToMakeValid = function(s) {
    
    let arr = s.split('');

    // 第1遍：去掉多余的 ')'
    let balance = 0;
    for (let i = 0; i < arr.length; i++) {
        if (arr[i] === '(') {
            balance++;
        } else if (arr[i] === ')') {
            if (balance === 0) {
                arr[i] = '#'; // 标记删除
            } else {
                balance--;
            }
        }
    }

    // 第2遍：去掉多余的 '('
    balance = 0;
    for (let i = arr.length - 1; i >= 0; i--) {
        if (arr[i] === ')') {
            balance++;
        } else if (arr[i] === '(') {
            if (balance === 0) {
                arr[i] = '#'; // 标记删除
            } else {
                balance--;
            }
        }
    }

    // 构建结果
    return arr.filter(c => c !== '#').join('');
};
// @lc code=end

