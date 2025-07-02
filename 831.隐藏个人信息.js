/*
 * @lc app=leetcode.cn id=831 lang=javascript
 *
 * [831] 隐藏个人信息
 */

// @lc code=start
/**
 * @param {string} s
 * @return {string}
 */
var maskPII = function(s) {
    s = s.toLowerCase();
    if (s.includes('@')) {
        // 处理电子邮件
        const [local, domain] = s.split('@');
        const maskedLocal = local[0] + '*****' + local[local.length - 1];
        return `${maskedLocal}@${domain}`;
    } else {
        // 处理电话号码
        const digits = s.replace(/\D/g, '');
        const maskedDigits = digits.length > 10 ? `+${'*'.repeat(digits.length - 10)}-` : '';
        return `${maskedDigits}***-***-${digits.slice(-4)}`;
    }
};
// @lc code=end

