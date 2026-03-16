/*
 * @lc app=leetcode.cn id=1452 lang=javascript
 *
 * [1452] 收藏清单
 */

// @lc code=start
/**
 * @param {string[][]} favoriteCompanies
 * @return {number[]}
 */
var peopleIndexes = function(favoriteCompanies) {

    const n = favoriteCompanies.length;
    
    // 转成 Set 方便查找
    const sets = favoriteCompanies.map(list => new Set(list));
    
    const res = [];
    
    for (let i = 0; i < n; i++) {
        let isSubset = false;
        
        for (let j = 0; j < n; j++) {
            if (i === j) continue;
            
            // 小集合不可能包含大集合
            if (sets[j].size < sets[i].size) continue;
            
            // 判断 i 是否是 j 的子集
            const subset = [...sets[i]].every(c => sets[j].has(c));
            
            if (subset) {
                isSubset = true;
                break;
            }
        }
        
        if (!isSubset) res.push(i);
    }
    
    return res;
    
};
// @lc code=end

