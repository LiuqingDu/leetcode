/*
 * @lc app=leetcode.cn id=457 lang=javascript
 *
 * [457] 环形数组是否存在循环
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {boolean}
 */
var circularArrayLoop = function(nums) {
    
    const n = nums.length;
    
    const getNextPos = (curr) => {
        const currDir = nums[curr] > 0 ? 1 : -1;
        const next = ((curr + nums[curr]) % n + n) % n;
        
        if (nums[next] === 0 || (nums[next] > 0 ? 1 : -1) !== currDir) {
            return -1;
        }
        return next;
    };
    
    for (let i = 0; i < n; i++) {
        if (nums[i] === 0) continue;
        
        let slow = i, fast = i;
        
        while (true) {
            slow = getNextPos(slow);
            if (slow === -1) break;
            
            fast = getNextPos(fast);
            if (fast === -1) break;
            fast = getNextPos(fast);
            if (fast === -1) break;
            
            if (slow === fast) {
                if (slow === getNextPos(slow)) break;
                return true;
            }
        }
        
        let curr = i;
        while (curr !== -1) {
            const next = getNextPos(curr);
            nums[curr] = 0;
            curr = next;
        }
    }
    
    return false;
};
// @lc code=end

