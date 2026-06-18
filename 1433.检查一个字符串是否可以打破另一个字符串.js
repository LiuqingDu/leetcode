/*
 * @lc app=leetcode.cn id=1433 lang=javascript
 *
 * [1433] 检查一个字符串是否可以打破另一个字符串
 */

// @lc code=start
/**
 * @param {string} s1
 * @param {string} s2
 * @return {boolean}
 */
var checkIfCanBreak = function(s1, s2) {
    
    // 1. 将字符串转为数组并进行升序排序
    // 注意：JS 的 sort() 默认是按 Unicode 码点排序，对小写字母直接 sort() 即可
    const arr1 = s1.split('').sort();
    const arr2 = s2.split('').sort();

    let s1BreaksS2 = true;
    let s2BreaksS1 = true;

    // 2. 同步遍历对比
    for (let i = 0; i < arr1.length; i++) {
        if (arr1[i] < arr2[i]) {
            s1BreaksS2 = false; // s1 存在字符小于 s2，s1 无法打破 s2
        }
        if (arr2[i] < arr1[i]) {
            s2BreaksS1 = false; // s2 存在字符小于 s1，s2 无法打破 s1
        }

        // 优化剪枝：如果两个方向都无法打破，提前返回 false
        if (!s1BreaksS2 && !s2BreaksS1) {
            return false;
        }
    }

    // 3. 只要有一种情况成立，就返回 true
    return true;
};
// @lc code=end

