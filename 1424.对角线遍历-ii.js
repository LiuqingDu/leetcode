/*
 * @lc app=leetcode.cn id=1424 lang=javascript
 *
 * [1424] 对角线遍历 II
 */

// @lc code=start
/**
 * @param {number[][]} nums
 * @return {number[]}
 */
var findDiagonalOrder = function(nums) {
    
    const buckets = [];
    let totalElements = 0;

    // 1. 遍历二维数组，将相同 i + j 的元素归入同一个桶
    for (let i = 0; i < nums.length; i++) {
        for (let j = 0; j < nums[i].length; j++) {
            const sum = i + j;
            if (!buckets[sum]) {
                buckets[sum] = [];
            }
            buckets[sum].push(nums[i][j]);
            totalElements++;
        }
    }

    // 2. 初始化结果数组，并逆序提取每个桶中的元素
    const result = new Array(totalElements);
    let index = 0;

    for (let k = 0; k < buckets.length; k++) {
        const bucket = buckets[k];
        if (!bucket) continue; // 兼容稀疏数组的情况（如果有空桶）
        
        // 关键：同一对角线内，后遍历到的行号大（在左下方），应先输出，所以逆序循环
        for (let i = bucket.length - 1; i >= 0; i--) {
            result[index++] = bucket[i];
        }
    }

    return result;
};
// @lc code=end

