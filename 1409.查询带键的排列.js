/*
 * @lc app=leetcode.cn id=1409 lang=javascript
 *
 * [1409] 查询带键的排列
 */

// @lc code=start
/**
 * @param {number[]} queries
 * @param {number} m
 * @return {number[]}
 */
var processQueries = function(queries, m) {
    
    // 1. 初始化排列 P = [1, 2, 3, ..., m]
    let P = [];
    for (let i = 1; i <= m; i++) {
        P.push(i);
    }
    
    // 2. 准备一个数组用来存放每一次查询的结果
    let result = [];
    
    // 3. 按顺序处理每一个查询
    for (let i = 0; i < queries.length; i++) {
        let target = queries[i];
        
        // 找到 target 在当前 P 中的索引
        let index = P.indexOf(target);
        result.push(index); // 记录答案
        
        // 将 target 移到开头：
        P.splice(index, 1); // 先从原位置删除
        P.unshift(target);  // 再塞到最前面
    }
    
    return result;
};
// @lc code=end

