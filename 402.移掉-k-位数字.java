/*
 * @lc app=leetcode.cn id=402 lang=java
 *
 * [402] 移掉 K 位数字
 */

// @lc code=start
class Solution {
    public String removeKdigits(String num, int k) {
        // 两个位数相同的数字，它们的大小取决于从左往右第一个不同的数字的大小
        // 比如 123a456 和 123b456 这两个数字的大小取决于 a 和 b 的大小
        // 那么这道题可以这样思考，从左往右，每一位数字跟上一位保留的数字比较，
        // 如果当前数字小，那么上一位保留的应该删掉，用更小的代替上一位
        // 当然这里需要继续循环检查再上一个保留的，直到当前数字比之前的大为止
        // 如果当前数字大，那么当前数字就暂定为保留
        // 同时记录删除的数量，直到等于 k 为止就不继续删除，后续的就直接加入结果
        // 可以用栈来保存暂定保留的数字
        // 新来的数字跟栈顶比较，确保栈始终是最小数

        Deque<Character> stack = new LinkedList<>();
        
        // 遍历每个数字
        for (char digit : num.toCharArray()) {
            // 当前数字比栈顶小且k大于0时，弹出栈顶以确保形成最小数
            while (k > 0 && !stack.isEmpty() && stack.peekLast() > digit) {
                stack.pollLast();
                k--;
            }
            stack.addLast(digit); // 将当前数字加入栈
        }
        // 到这里无论 k 是否为 0，栈里都是已经处理过所有数字了

        // 如果 k 不为 0，说明还需要从栈里继续删
        for (int i = 0; i < k; i++) {
            stack.pollLast();
        }

        // 构建结果字符串，跳过前导零
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            char current = stack.pollFirst();
            if (!(result.length() == 0 && current == '0')) { // 去除前导零
                result.append(current);
            }
        }

        // 如果结果为空，返回"0"
        return result.length() == 0 ? "0" : result.toString();
        
    }
}
// @lc code=end

