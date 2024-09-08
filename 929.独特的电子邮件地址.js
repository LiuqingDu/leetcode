/*
 * @lc app=leetcode.cn id=929 lang=javascript
 *
 * [929] 独特的电子邮件地址
 */

// @lc code=start
/**
 * @param {string[]} emails
 * @return {number}
 */
var numUniqueEmails = function(emails) {
    let set = new Set();
    for (let email of emails) {
        let s = "";
        let n = email.length;
        let i = 0;
        let flag = true;
        while (i < n) {
            if (email[i] === "@") {
                break;
            }
            if (email[i] === ".") {
                i++;
                continue;
            }
            if (email[i] == "+") {
                flag = false;
            }
            if (flag) {
                s += email[i];
            }
            i++;
        }
        set.add(s + email.substring(i))
    }
    return set.size
};
// @lc code=end

