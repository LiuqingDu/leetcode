/*
 * @lc app=leetcode.cn id=119 lang=java
 *
 * [119] 杨辉三角 II
 */

// @lc code=start
class Solution {
    public List<Integer> getRow(int rowIndex) {
        // 类似118，只是只输出最后一行
        // 只要做到只保存上一行，然后根据上一行原地生成下一行就行
        // 因为新的一行的每一个元素依赖于上一行的同位置元素以及左边位置的元素
        // 如果我们从左边开始原地修改的话，相当于上一行的左边的元素已经被改成新的了
        // 那么就从右边往左原地修改，这样就不会被影响到了

        List<Integer> cur = new ArrayList<Integer>();
        // 第一行
        cur.add(1);

        // 注意行数从0开始，题目要求输入索引为rowIndex行
        // 也就是实际上，我们从第二行（i=1）开始,到i=rowIndex为止
        for (int i = 1; i <= rowIndex; i++) {
            // 从最右一个元素开始往左，直到第二个元素为止（也就是j>0）
            // 因为第一个元素始终为1，不用改
            for (int j = i - 1; j > 0; j--) {
                cur.set(j, cur.get(j - 1) + cur.get(j));
            }
            cur.add(1);
        }
        return cur;
    }
}
// @lc code=end

