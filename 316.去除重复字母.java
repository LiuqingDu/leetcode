/*
 * @lc app=leetcode.cn id=316 lang=java
 *
 * [316] 去除重复字母
 */

// @lc code=start

class Solution {
    public String removeDuplicateLetters(String s) {

        // 先考虑如何形成最小字典序
        // abd和acd，前者b<c，所以abd的字典序<acd字典序
        // 字典序就是比较相同长度的两个字符串的第一个不同的字符
        // 如果两个字符串有同样的字符，那么为了形成最小字典序，
        // 就需要把更小的字符放在前面，比如abcd和acbd，只要把b放在c前面就可以得到更小的字典序
        // 维护一个栈，如果新的元素比栈顶大，那么就把这个元素放到栈顶，
        // 如果新元素比栈顶小，那么就应该把栈顶弹出，继续比较，直到遇到栈顶更小为止
        // 这样栈里面就是从小到大排序的元素并且也是按照原字符串顺序
        // 现在剩下的问题是需要确保每个字符出现一次
        // 在每次把栈顶弹出的时候判断一下，看看还没有处理的字符串里还有没有这个栈顶的元素
        // 确保弹出这个栈顶元素不是仅有的唯一一个元素即可。
        // 可以维护一个map记录每个字符还剩下多少个来判断是否还剩余的

        // 记录每个字符有多少个
        Map<Character, Long> countMap = s.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        
        // 栈
        Stack<Character> res = new Stack<>();

        // 遍历每个字符
        for (char c: s.toCharArray()) {
            // 栈里面相同字符只放一个，并且栈里面的元素都是排好顺序的，
            // 所以再遇到相同元素直接跳过，只往里面放新元素
            if (!res.contains(c)) {
                // 栈里有元素的情况下判断栈顶和新元素的大小
                // 如果栈顶元素更大，那么这个栈顶可能需要弹出
                // 弹出的条件是，未处理的字符串里，还存在这个栈顶元素
                // 否则栈顶元素即使大，也不能弹出，确保这个字母在栈里至少有一个
                while (res.size() != 0 && c < res.peek() && countMap.get(res.peek()) > 0) {
                    res.pop();
                }
                // 把新元素入栈
                res.push(c);
            }
            // 入栈后，更新剩余字符串里这个元素的个数
            countMap.put(c, countMap.get(c) - 1);
        }

        return res.stream().map(String::valueOf).collect(Collectors.joining());
    }
}
// @lc code=end

