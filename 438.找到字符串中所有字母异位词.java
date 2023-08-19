/*
 * @lc app=leetcode.cn id=438 lang=java
 *
 * [438] 找到字符串中所有字母异位词
 */

// @lc code=start

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new LinkedList<Integer>();

        if (s.length() < p.length()) {
            return res;
        }

        // 窗口的长度固定为p.lentgh()，因为长度不同的话肯定不符合
        // 两个数组分别对应窗口里的字母数量和p的字母数量，当这两个数组相同的时候就说明符合要求
        // 数组的索引表示字母，对应字母减去'a'的ASCII码就是索引
        int[] window = new int[26];
        int[] pArr = new int[26];

        for (int i = 0; i < p.length(); i++) {
            // 因为是循环的p的长度，下面这句正好把s的前p.length()个字符统计到window里去
            window[s.charAt(i) - 'a']++;
            pArr[p.charAt(i) - 'a']++;
        }

        int left = 0;
        // 注意这里left可以等于s.len-p.len，因为此时从left开始正好长度等于p.len
        // 但当left等于s.len-p.len的时候，索引可能超出范围，因为后面有一个把窗口往后移动的操作
        // 当最后一个满足要求的窗口判断完之后，会把窗口再往后移动一下，这里就出错了，因为窗口尾部超出范围了
        // 因此最后一个满足要求的窗口（也就是left=s.len-p.len时）需要特殊判断
        while (left < s.length() - p.length()) {
            if (Arrays.equals(pArr, window)) {
                res.add(left);
            }
            window[s.charAt(left) - 'a']--;
            // 如果允许left=s.len-p.len，下面这里会索引超出范围
            window[s.charAt(left + p.length()) - 'a']++;
            
            left++;
        }
        // 这里判断一下最后一个窗口
        if (Arrays.equals(pArr, window)) {
            res.add(left);
        }

        return res;
    }
}
// @lc code=end

