/*
 * @lc app=leetcode.cn id=777 lang=javascript
 *
 * [777] 在 LR 字符串中交换相邻字符
 */

// @lc code=start
/**
 * @param {string} start
 * @param {string} result
 * @return {boolean}
 */
var canTransform = function(start, result) {
    
    const n = start.length;
    let i = 0, j = 0;
    
    while (i < n || j < n) {
        // 1. 跳过 start 中的所有 'X'
        while (i < n && start[i] === 'X') {
            i++;
        }
        // 2. 跳过 result 中的所有 'X'
        while (j < n && result[j] === 'X') {
            j++;
        }
        
        // 3. 如果其中一个指针到头了，另一个也必须到头
        if (i === n || j === n) {
            return i === n && j === n;
        }
        
        // 4. 相对顺序检查：当前非 'X' 字符必须相同
        if (start[i] !== result[j]) {
            return false;
        }
        
        // 5. 移动方向检查
        // 'L' 只能向左移动，所以 start 中的索引 i 必须大于或等于 result 中的索引 j
        if (start[i] === 'L' && i < j) {
            return false;
        }
        // 'R' 只能向右移动，所以 start 中的索引 i 必须小于或等于 result 中的索引 j
        if (start[i] === 'R' && i > j) {
            return false;
        }
        
        // 6. 匹配成功，两个指针同时后移
        i++;
        j++;
    }
    
    return true;
};
// @lc code=end

