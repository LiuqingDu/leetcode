/*
 * @lc app=leetcode.cn id=816 lang=javascript
 *
 * [816] 模糊坐标
 */

// @lc code=start
/**
 * @param {string} s
 * @return {string[]}
 */
var ambiguousCoordinates = function(s) {
    
    const res = [];
    // 去掉前后的括号
    const sub = s.substring(1, s.length - 1);
    const n = sub.length;

    // i 表示左边 X 坐标数字的长度，从 1 开始，到 n-1 结束
    for (let i = 1; i < n; i++) {
        const leftStr = sub.substring(0, i);
        const rightStr = sub.substring(i);

        // 获取左边和右边所有合法的数字形态
        const leftList = getValid(leftStr);
        const rightList = getValid(rightStr);

        // 双重循环，自由组合
        for (const l of leftList) {
            for (const r of rightList) {
                res.push(`(${l}, ${r})`);
            }
        }
    }

    return res;
};

/**
 * 辅助函数：为一个纯数字字符串寻找所有合法的数字（整数或小数）形态
 * @param {string} str
 * @return {string[]}
 */
function getValid(str) {
    const ans = [];
    const n = str.length;

    // 1. 尝试作为整数（不加小数点）
    // 如果长度为 1，或者长度大于 1 且首位不是 '0'
    if (n === 1 || str[0] !== '0') {
        ans.push(str);
    }

    // 2. 尝试加小数点，i 表示小数点前面的字符个数
    for (let i = 1; i < n; i++) {
        const integerPart = str.substring(0, i);   // 整数部分
        const decimalPart = str.substring(i);       // 小数部分

        // 判定整数部分：如果长度大于 1，绝对不能以 '0' 开头 (如 "01.2" 错误)
        if (integerPart.length > 1 && integerPart[0] === '0') {
            continue;
        }
        // 判定小数部分：绝对不能以 '0' 结尾 (如 "1.20" 或 "0.0" 错误)
        if (decimalPart[decimalPart.length - 1] === '0') {
            continue;
        }

        // 拼接成合法小数
        ans.push(`${integerPart}.${decimalPart}`);
    }

    return ans;
};
// @lc code=end

