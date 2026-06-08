/*
 * @lc app=leetcode.cn id=1409 lang=java
 *
 * [1409] 查询带键的排列
 */

// @lc code=start
class Solution {
    public int[] processQueries(int[] queries, int m) {
        
        // 1. 初始化排列 P
        List<Integer> p = new ArrayList<>();
        for (int i = 1; i <= m; i++) {
            p.add(i);
        }
        
        // 2. 准备一个数组用来存放结果
        int[] result = new int[queries.length];
        
        // 3. 按顺序处理每一个查询
        for (int i = 0; i < queries.length; i++) {
            int target = queries[i];
            
            // 找到 target 在当前 P 中的位置（索引从 0 开始）
            int index = p.indexOf(target);
            result[i] = index;
            
            // 将 target 移到开头：先删除，再插入到索引 0
            // 注意：这里传入的是 Integer 对象，确保按值删除，而不是按索引删除
            p.remove((Integer) target); 
            p.add(0, target);
        }
        
        return result;
    }
}
// @lc code=end

