/*
 * @lc app=leetcode.cn id=1358 lang=javascript
 *
 * [1358] 包含所有三种字符的子字符串数目
 */

// @lc code=start
/**
 * @param {string} s
 * @return {number}
 */
var numberOfSubstrings = function(s) {
    
    const n = s.length;
    let ans = 0;
    
    const pre = Array.from({ length: 3 }, () => new Array(n + 1).fill(0));
    for (let i = 0; i < n; i++) {
        for (let j = 0; j < 3; j++) {
            pre[j][i + 1] = pre[j][i];
        }
        pre[s.charCodeAt(i) - 97][i + 1]++;
    }
    
    for (let i = 0; i < n; i++) {
        let left = i + 1, right = n, pos = -1;
        while (left <= right) {
            const mid = left + ((right - left) >> 1);
            
            if (pre[0][mid] - pre[0][i] > 0 && 
                pre[1][mid] - pre[1][i] > 0 && 
                pre[2][mid] - pre[2][i] > 0) {
                right = mid - 1;
                pos = mid;
            } else {
                left = mid + 1;
            }
        }
        
        if (pos !== -1) {
            ans += n - pos + 1;
        }
    }
    
    return ans;
};
// @lc code=end

