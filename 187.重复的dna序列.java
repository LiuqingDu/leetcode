/*
 * @lc app=leetcode.cn id=187 lang=java
 *
 * [187] 重复的DNA序列
 */

// @lc code=start
class Solution {
    // 容易想到的方法是滑动窗口，窗口宽度固定为 10，把每个窗口的字符串放到 map 里
    // 当集合里已经存在的时候，且自己是第二次出现，加入 res 中
    // 不能用 set 是因为 set 不知道自己第几次出现，可能重复，比如第二次出现和第三次出现都会加到 res 里
    // 这个方法在处理数据过多的时候效率不高，集合占用空间过多
    // 考虑到可能的字符有 4 种，可以用00,01,10,11来表示，也就是可以用两位二进制来表示
    // 那么每一个长度为 10 的子串可以用 20 位二进制表示，一个 int 是 32 位，足够表示一个子串
    // 滑动窗口的时候就是位操作，往左移动两位，右边加进来新来的两位，左边剔除掉第 20 位左侧的
    // 剔除可以用位运算，跟（20位 1）进行与计算，保留右边 20 位

    static int L = 10;

    Map<Character, Integer> bin = new HashMap<Character, Integer>() {{
        put('A', 0);
        put('C', 1);
        put('G', 2);
        put('T', 3);
    }};

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<String>();

        int n = s.length();
        if (n <= L) {
            return res;
        }

        // x 是表示窗口内的字符的20位数字
        // 先初始化 9 位，剩下一位后续循环里加入
        int x = 0;
        for (int i = 0; i < L - 1; i++) {
            x = (x << 2) | bin.get(s.charAt(i));
        }

        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
        for (int i = 0; i <= n - L; i++) {
            // 每次从右边取一位加入窗口，然后跟(20 位 1)进行与运算，保留右边 20 位
            x = ((x << 2) | bin.get(s.charAt(i + L - 1))) & ((1 << (L * 2)) - 1);
            cnt.put(x, cnt.getOrDefault(x, 0) + 1);
            if (cnt.get(x) == 2) {
                res.add(s.substring(i, i + L));
            }
        }

        return res;
    }
}
// @lc code=end

