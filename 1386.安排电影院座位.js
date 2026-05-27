/*
 * @lc app=leetcode.cn id=1386 lang=javascript
 *
 * [1386] 安排电影院座位
 */

// @lc code=start
/**
 * @param {number} n
 * @param {number[][]} reservedSeats
 * @return {number}
 */
var maxNumberOfFamilies = function(n, reservedSeats) {
    
    // 1. 使用 Map 记录有预约的行。key: 行号, value: 这一行的座位状态（二进制数）
    const occupied = new Map();
    
    for (const [row, col] of reservedSeats) {
        // 我们只关心第 2 到第 9 列
        if (col >= 2 && col <= 9) {
            const currentMask = occupied.get(row) || 0;
            // 通过位运算，将对应列的二进制位置为 1
            occupied.set(row, currentMask | (1 << col));
        }
    }
    
    // 2. 预先假设所有行都是空的，每行默认可以坐 2 个家庭
    let ans = n * 2;
    
    // 3. 定义左、中、右三种方案的判定条件（对应二进制的十进制值）
    // 左边 (2,3,4,5): (1<<2)|(1<<3)|(1<<4)|(1<<5) = 60
    const leftMask = 60;
    // 中间 (4,5,6,7): (1<<4)|(1<<5)|(1<<6)|(1<<7) = 240
    const midMask = 240;
    // 右边 (6,7,8,9): (1<<6)|(1<<7)|(1<<8)|(1<<9) = 960
    const rightMask = 960;
    
    // 4. 遍历所有“有预约记录”的行，计算它们实际能坐多少个家庭
    for (const mask of occupied.values()) {
        let count = 0;
        
        // 按位与（&）结果为 0，说明这几个位置全都是空的
        const leftAvailable = (mask & leftMask) === 0;
        const rightAvailable = (mask & rightMask) === 0;
        
        if (leftAvailable) count++;
        if (rightAvailable) count++;
        
        // 特殊情况：如果左边和右边都被挡住了，看看中间能不能坐一个家庭
        if (!leftAvailable && !rightAvailable && (mask & midMask) === 0) {
            count++;
        }
        
        // 这一行原本默认扣了 2 个名额，现在补回实际能坐的家庭数 count
        // 相当于总数减去损失的差额：ans -= (2 - count)
        ans -= (2 - count);
    }
    
    return ans;
};
// @lc code=end

