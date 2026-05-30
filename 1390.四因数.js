/*
 * @lc app=leetcode.cn id=1390 lang=javascript
 *
 * [1390] 四因数
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var sumFourDivisors = function(nums) {
    let totalSum = 0;
    
    for (let num of nums) {
        // 累加每个数字求出的 4 因数之和（如果不满足 4 个，该函数返回 0）
        totalSum += getFourDivisorsSum(num);
    }
    
    return totalSum;
};

/**
 * 辅助函数：计算单个数字的因数，若恰好有 4 个则返回它们的和，否则返回 0
 */
function getFourDivisorsSum(n) {
    let count = 0; // 记录因数个数
    let sum = 0;   // 记录因数之和
    
    // 只需遍历到根号 n
    for (let i = 1; i * i <= n; i++) {
        if (n % i === 0) {
            // 找到了第一个因数 i
            count++;
            sum += i;
            
            // 找到对应的配对因数 n / i
            // 比如 n=21, i=3 时，对应的配对因数是 7
            if (i * i !== n) { 
                // 特别注意：如果 i * i === n（如 4 = 2 * 2），说明是完全平方数
                // 此时配对因数和 i 是同一个数，不能重复计算
                count++;
                sum += n / i;
            }
            
            // 💡 剪枝优化：如果因数个数已经超过 4 个，直接淘汰，没必要继续算了
            if (count > 4) {
                return 0;
            }
        }
    }
    
    // 只有当因数个数【恰好】等于 4 时，才返回因数之和，否则返回 0
    return count === 4 ? sum : 0;
};
// @lc code=end

