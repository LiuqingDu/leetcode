/*
 * @lc app=leetcode.cn id=907 lang=javascript
 *
 * [907] 子数组的最小值之和
 */

// @lc code=start
/**
 * @param {number[]} arr
 * @return {number}
 */
var sumSubarrayMins = function(arr) {
    
    const MOD = 1e9 + 7;
    
    // 1. 前后添加哨兵 0，避免判断栈空和处理边界
    const extArr = [0, ...arr, 0];
    const stack = []; // 存储下标的单调递增栈
    let sum = 0;
    
    // 2. 遍历带有哨兵的数组
    for (let i = 0; i < extArr.length; i++) {
        // 当遇到当前元素比栈顶元素小时，说明栈顶元素的右边界找到了
        while (stack.length > 0 && extArr[i] < extArr[stack[stack.length - 1]]) {
            const curIdx = stack.pop();       // 当前要结算的元素下标
            const leftIdx = stack[stack.length - 1]; // 当前元素的左边界下标
            const rightIdx = i;               // 当前元素的右边界下标
            
            // 计算以 extArr[curIdx] 为最小值的子数组数量
            const count = (curIdx - leftIdx) * (rightIdx - curIdx);
            
            // 累加贡献值，并在每一步取模防止大数溢出
            sum = (sum + count * extArr[curIdx]) % MOD;
        }
        stack.push(i);
    }
    
    return sum;
};
// @lc code=end

