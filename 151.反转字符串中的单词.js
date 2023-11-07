/*
 * @lc app=leetcode.cn id=151 lang=javascript
 *
 * [151] 反转字符串中的单词
 */

// @lc code=start
/**
 * @param {string} s
 * @return {string}
 */
var reverseWords = function(s) {
    let arr = [];

    for (let i = 0; i < s.length; i++) {
        if (s.charAt(i) !== " ") {
            arr.push(s.charAt(i));
        } else {
            if (arr.length && arr[arr.length - 1] !== " ") {
                arr.push(" ");
            }
        }
    }

    if (!arr.length) {
        return "";
    }

    if (arr[arr.length - 1] === " ") {
        arr.pop();
    }

    let reverse = function(arr, i, j) {
        while (i < j) {
            let tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            i++;
            j--;
        }
    }

    reverse(arr, 0, arr.length - 1);

    for (let i = 0; i < arr.length;) {
        for (let j = i; j < arr.length; j++) {
            if (j === arr.length - 1 || arr[j + 1] === " ") {
                reverse(arr, i, j);
                i = j + 2;
                break;
            }
        }
    }

    return arr.join("");

};
// @lc code=end

