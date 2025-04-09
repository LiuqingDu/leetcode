/*
 * @lc app=leetcode.cn id=1496 lang=javascript
 *
 * [1496] 判断路径是否相交
 */

// @lc code=start
/**
 * @param {string} path
 * @return {boolean}
 */
var isPathCrossing = function(path) {
    let getHash = (x, y) => x * 10000 + y;

    let set = new Set();
    let x = 0, y = 0;
    set.add(getHash(x, y));

    for (let c of path) {
        switch (c) {
            case 'N':
                x--;
                break;
            case 'S':
                x++;
                break;
            case 'W':
                y--;
                break;
            case 'E':
                y++;
                break;
        }
        let hashValue = getHash(x, y);
        if (set.has(hashValue)) {
            return true;
        }
        set.add(hashValue);
    }
    return false;
};
// @lc code=end

