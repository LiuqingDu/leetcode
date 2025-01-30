/*
 * @lc app=leetcode.cn id=1051 lang=java
 *
 * [1051] 高度检查器
 */

// @lc code=start
class Solution {
    public int heightChecker(int[] heights) {
        // 可以先排序然后再依次比对
        // 另一种方法是计数排序
        // 先统计每个高度出现的次数
        // 比如 [1,1,4,2,1,3]
        // 记录为 [0, 3, 1, 1, 1]
        // 这里下标表示对应高度, 数字表示同一高度有几个
        // 这样对于次数数组里每一个非零的数字,表示这个高度需要占用几个位置
        // 依次排下来就是预期的排序数组
        // 用原数组跟次数数组依次比较即可

        // 1. 找出身高的最大值 (本题最高是 100)
        int[] count = new int[101];  // 统计1~100每个身高的出现次数
        
        // 2. 统计每个高度的频率
        for (int h : heights) {
            count[h]++;
        }
        
        // 3. 生成排序后的 heights
        int index = 0;  // 用于遍历 heights
        int mismatch = 0; // 记录位置不同的个数
        
        for (int h = 1; h <= 100; h++) {  // 从 1 遍历到 100
            while (count[h] > 0) {  // 该高度还有剩余, 表示当前高度还需要继续占用位置
                if (heights[index] != h) {  // 当前位置的高度不匹配
                    mismatch++;
                }
                // 占用一个位置,位置索引后移
                index++;
                // 还未占位置的高度减少一个
                count[h]--; // 填入一个身高，减少计数
            }
        }
        
        return mismatch;
    }
}
// @lc code=end

