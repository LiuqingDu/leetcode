/*
 * @lc app=leetcode.cn id=537 lang=javascript
 *
 * [537] 复数乘法
 */

// @lc code=start
/**
 * @param {string} num1
 * @param {string} num2
 * @return {string}
 */
var complexNumberMultiply = function(num1, num2) {
        const parseComplex = (num) => {
            const [real, imaginary] = num.split('+');
            return [parseInt(real), parseInt(imaginary.slice(0, -1))]; // 去掉 'i' 转为整数
        };
    
        const [a, b] = parseComplex(num1);
        const [c, d] = parseComplex(num2);
    
        const realPart = a * c - b * d;
        const imaginaryPart = a * d + b * c;
    
        return `${realPart}+${imaginaryPart}i`;
};
// @lc code=end

