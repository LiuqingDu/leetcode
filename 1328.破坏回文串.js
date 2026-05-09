/*
 * @lc app=leetcode.cn id=1328 lang=javascript
 *
 * [1328] 破坏回文串
 */

// @lc code=start
/**
 * @param {string} palindrome
 * @return {string}
 */
var breakPalindrome = function(palindrome) {
    const n = palindrome.length;

    // 长度为1，无法变成非回文
    if (n === 1) {
        return "";
    }

    // 转成数组方便修改
    let chars = palindrome.split('');

    // 只遍历前半部分
    for (let i = 0; i < Math.floor(n / 2); i++) {

        // 找到第一个不是'a'的字符
        if (chars[i] !== 'a') {

            // 改成'a'
            chars[i] = 'a';

            return chars.join('');
        }
    }

    // 前半部分全是'a'
    // 最后一个字符改成'b'
    chars[n - 1] = 'b';

    return chars.join('');
};
// @lc code=end

