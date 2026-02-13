/*
 * @lc app=leetcode.cn id=1233 lang=javascript
 *
 * [1233] 删除子文件夹
 */

// @lc code=start
/**
 * @param {string[]} folder
 * @return {string[]}
 */
var removeSubfolders = function(folder) {
    folder.sort();

    let result = [];
    result.push(folder[0]);

    for (let i = 1; i < folder.length; i++) {
        let pre = result[result.length - 1];
        let cur = folder[i];

        if (!cur.startsWith(pre + "/")) {
            result.push(cur);
        }
    }

    return result;
};
// @lc code=end

