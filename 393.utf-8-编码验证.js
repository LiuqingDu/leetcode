/*
 * @lc app=leetcode.cn id=393 lang=javascript
 *
 * [393] UTF-8 编码验证
 */

// @lc code=start
/**
 * @param {number[]} data
 * @return {boolean}
 */
var validUtf8 = function(data) {
    let one = 128;
    let two = 192;
    let three = 224;
    let four = 240;
    let five = 248;

    let invalidSecondary = function(n) {
        return !(n >= one && n < two);
    }

    let i = 0;
    while (i < data.length) {
        if (data[i] >= five) {
            return false;
        } else if (data[i] >= four) {
            if (i + 3 >= data.length
                || invalidSecondary(data[i + 1])
                || invalidSecondary(data[i + 2])
                || invalidSecondary(data[i + 3])) {
                return false;
            }
            i += 4;
        } else if (data[i] >= three) {
            if (i + 2 >= data.length
                || invalidSecondary(data[i + 1])
                || invalidSecondary(data[i + 2])) {
                return false;
            }
            i += 3;
        } else if (data[i] >= two) {
            if (i + 1 >= data.length
                || invalidSecondary(data[i + 1])) {
                return false;
            }
            i += 2;
        } else if (data[i] >= one) {
            return false;
        } else {
            i++;
        }
    }
    return true;
};
// @lc code=end

