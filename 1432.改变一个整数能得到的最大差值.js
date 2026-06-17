/*
 * @lc app=leetcode.cn id=1432 lang=javascript
 *
 * [1432] 改变一个整数能得到的最大差值
 */

// @lc code=start
/**
 * @param {number} num
 * @return {number}
 */
var maxDiff = function(num) {
    
    const s = num.toString();
    
    // 1. 求最大值 a
    let aStr = s;
    for (let i = 0; i < s.length; i++) {
        if (s[i] !== '9') {
            // 找到第一个不是 '9' 的数字，将其全部替换为 '9'
            aStr = s.replaceAll(s[i], '9');
            break;
        }
    }
    
    // 2. 求最小值 b
    let bStr = s;
    if (s[0] !== '1') {
        // 如果最高位不是 '1'，把最高位这个数字全部换成 '1'
        bStr = s.replaceAll(s[0], '1');
    } else {
        // 如果最高位已经是 '1'，从第二位开始找第一个既不是 '0' 也不不是 '1' 的数字
        for (let i = 1; i < s.length; i++) {
            if (s[i] !== '0' && s[i] !== '1') {
                // 全部替换成 '0'
                bStr = s.replaceAll(s[i], '0');
                break;
            }
        }
    }
    
    // 3. 返回差值（JS 在做减法时会自动将字符串隐式转换为数字）
    return Number(aStr) - Number(bStr);
};
// @lc code=end

