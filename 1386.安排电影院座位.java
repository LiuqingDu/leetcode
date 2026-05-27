/*
 * @lc app=leetcode.cn id=1386 lang=java
 *
 * [1386] 安排电影院座位
 */

// @lc code=start
class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        
        // key: 行号, value: 这一行座位的被占用状态（用二进制表示）
        Map<Integer, Integer> occupied = new HashMap<>();
        
        // 1. 遍历预约记录，把被占用的座位用位运算记录下来
        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];
            // 我们只关心 2 到 9 列
            if (col >= 2 && col <= 9) {
                int currentMask = occupied.getOrDefault(row, 0);
                // 将对应列的二进制位置为 1
                occupied.put(row, currentMask | (1 << col));
            }
        }
        
        // 2. 预先假设所有行都是空的，每行默认可以坐 2 个家庭
        // 后面我们只扣除那些“有预约记录的行”少坐的家庭数
        int ans = n * 2;
        
        // 3. 定义左、中、右三种方案的判定条件（看这些位置上是否有 1）
        // 左边需要 2,3,4,5 为空。二进制：(1<<2)|(1<<3)|(1<<4)|(1<<5) = 4 + 8 + 16 + 32 = 60
        int leftMask = 60;  
        // 中间需要 4,5,6,7 为空。二进制：(1<<4)|(1<<5)|(1<<6)|(1<<7) = 16 + 32 + 64 + 128 = 240
        int midMask = 240;  
        // 右边需要 6,7,8,9 为空。二进制：(1<<6)|(1<<7)|(1<<8)|(1<<9) = 64 + 128 + 256 + 512 = 960
        int rightMask = 960; 

        // 4. 遍历所有“有预约”的行，计算它们实际能坐多少人
        for (int mask : occupied.values()) {
            int count = 0;
            boolean leftAvailable = (mask & leftMask) == 0;
            boolean rightAvailable = (mask & rightMask) == 0;
            
            if (leftAvailable) {
                count++;
            }
            if (rightAvailable) {
                count++;
            }
            // 如果左边和右边都不能坐，看看中间能不能坐
            if (!leftAvailable && !rightAvailable && (mask & midMask) == 0) {
                count++;
            }
            
            // 这一行原本默认能坐 2 个，现在只能坐 count 个
            // 所以总数要减去损失的差额：(2 - count)
            ans -= (2 - count);
        }
        
        return ans;
    }
}
// @lc code=end

