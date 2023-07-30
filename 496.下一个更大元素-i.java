/*
 * @lc app=leetcode.cn id=496 lang=java
 *
 * [496] 下一个更大元素 I
 */

// @lc code=start

import java.util.Stack;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];

        // 先计算出nums2里每一个数字对应的下一个更大元素，存到map里
        // 再用nums1的数字去map里找
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        // 使用单调栈记录当前元素背后“能看到的”比它大的元素
        // 所谓“能看到的”，是指将每个数字化成柱状图，站在每个柱形图左侧朝右看
        // 只能看到依次越来越高的图案，也就是越来越大的数字，在大数字后面的小数字是看不到的
        Stack<Integer> stack = new Stack<Integer>();
        // 倒着往前依次计算从当前位置左侧往右看能看到的所有大数字
        // 这些数字肯定得大于自己，直到遇到一个比自己大的数字位置
        // 在第一个比自己大的数字之后，都是越来越大的，因为它们在之前的循环中已经被处理过了
        for (int i = nums2.length - 1; i >= 0; i--) {
            // 如果栈非空，则把没有当前数字大的都扔掉，只保留比自己大的
            // 直到遇到第一个比自己大的为止
            while(!stack.isEmpty() && stack.peek() <= nums2[i]) {
                stack.pop();
            }
            // 如果栈为空，说明自己之后没有比自己更大的，否则栈顶就是第一个比自己大的
            // map 用来记录一个数字及它对应的下一个大数
            map.put(nums2[i], stack.isEmpty()? -1 : stack.peek());
            // 把自己加入栈，等待后续比较（如果后续数字也就是左侧数字比自己大，自己就会被踢出去）
            stack.push(nums2[i]);
        }
        // 到目前为止 map 已经把 nums2 里的数字全都找到了他们的下一个大数

        // 从map中找到nums1的数字并把下一个大数存到ans结果里
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.get(nums1[i]);
        }

        return ans;
        
    }
}
// @lc code=end

