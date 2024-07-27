/*
 * @lc app=leetcode.cn id=696 lang=java
 *
 * [696] 计数二进制子串
 */

// @lc code=start
class Solution {
    public int countBinarySubstrings(String s) {
        // 符合要求的字串其实就两部分，一半全是0一半全是1，且两部分长度相同
        // 对于原字符串，可以看出每一个0和1的分界处是关键点，
        // 围绕这个分界线，两侧分别是0和1，这两边的长度中较短的那个长度决定了这部分0和1能形成
        // 多少个符合要求的字串
        // 比如00111，可以形成2个符合要求的字串（01,0011），由较短的两个0的长度决定
        // 那么把原先的字符串统计成一个数组，里面依次是相同的字符的数量
        // 比如00111记为[2,3]，表示有2个A字符和3个B字符，这里其实A和B具体是0还是1并不影响
        // 因为11000其实也是一回事
        // 这样每两个相邻的长度就是一次0和1的变换，
        // 然后依次比较相邻两个数字（也就是长度），取小值，就是这两部分0和1（或者1和0）能组成的
        // 符合要求的字串的数量
        // 最后把这些数量累加起来

        // int i = 0, n = s.length();
        // List<Integer> arr = new LinkedList<Integer>();
        // // 统计连续相同字符的数量
        // while (i < n) {
        //     // 当前要处理的字符
        //     char c = s.charAt(i);
        //     int count = 0;
        //     // 统计与当前字符相同的连续数量
        //     while (i < n && s.charAt(i) == c) {
        //         count++;
        //         i++;
        //     }
        //     arr.add(count);
        // }

        // // 统计总共有多少个子串
        // // 相邻的两个长度就是一次0和1的变换，可以形成一组子串
        // int res = 0;
        // for (i = 1; i < arr.size(); i++) {
        //     res += Math.min(arr.get(i), arr.get(i - 1));
        // }
        // return res;

        // 实际上可以发现第二轮计算的时候我们只需要相邻的两个数字，再之前的就不需要了，
        // 可以用两个变量表示从而避免使用数组
        // 有一个测试用例比较长，用上面的数组无法通过
        
        int i = 0, n = s.length();
        int pre = 0;
        int res = 0;
        // 统计连续相同字符的数量
        while (i < n) {
            // 当前要处理的字符
            char c = s.charAt(i);
            int count = 0;
            // 统计与当前字符相同的连续数量
            while (i < n && s.charAt(i) == c) {
                count++;
                i++;
            }
            // 遍历同时计算res
            res += Math.min(pre, count);
            pre = count;
        }
        return res;
    }
}
// @lc code=end

