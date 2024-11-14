/*
 * @lc app=leetcode.cn id=468 lang=javascript
 *
 * [468] 验证IP地址
 */

// @lc code=start
/**
 * @param {string} queryIP
 * @return {string}
 */
var validIPAddress = function(queryIP) {

    let isIPv4 = function(ip) {
        const parts = ip.split('.');
        if (parts.length !== 4) return false;
        for (let part of parts) {
            if (part.length === 0 || part.length > 3) return false;
            if (part[0] === '0' && part.length > 1) return false;
            if (!/^\d+$/.test(part)) return false; // 确保是数字
            const num = parseInt(part, 10);
            if (num < 0 || num > 255) return false;
        }
        return true;
    }

    let isIPv6 = function(ip) {
        const parts = ip.split(':');
        if (parts.length !== 8) return false;
        for (let part of parts) {
            if (part.length === 0 || part.length > 4) return false;
            for (let char of part) {
                if (!isHexDigit(char)) return false;
            }
        }
        return true;
    }

    let isHexDigit = function(char) {
        return (char >= '0' && char <= '9') ||
            (char >= 'a' && char <= 'f') ||
            (char >= 'A' && char <= 'F');
    }
    
    if (queryIP.split('.').length === 4) {
        return isIPv4(queryIP) ? "IPv4" : "Neither";
    } else if (queryIP.split(':').length === 8) {
        return isIPv6(queryIP) ? "IPv6" : "Neither";
    }
    return "Neither";
};
// @lc code=end

