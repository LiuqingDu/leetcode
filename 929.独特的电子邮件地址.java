/*
 * @lc app=leetcode.cn id=929 lang=java
 *
 * [929] 独特的电子邮件地址
 */

// @lc code=start
class Solution {
    public int numUniqueEmails(String[] emails) {
        // 域名部分不需要考虑，那么对于每个 email 只要找到@之前的部分就行了
        Set<String> set = new HashSet<>();
        for (String email: emails) {
            // 遍历每一个邮件地址
            StringBuilder sb = new StringBuilder();
            int n = email.length();
            int i = 0;
            // 标记当前字符是否为有效字符
            // 有遇到过加号的话就跳过，没有遇见的话那么当前字符就是有效的
            boolean flag = true;
            // 遍历每一个字符，直到遇到@为止，就是找邮箱名部分
            while (i < n) {
                char c = email.charAt(i);
                // 邮箱名已经结束
                if (c == '@') {
                    break;
                }
                // 遇到点可以跳过
                if (c == '.') {
                    i++;
                    continue;
                }
                // 遇到加号，后面的都要忽略
                if (c == '+') {
                    flag = false;
                }
                // 如果不能忽略，就加进去
                if (flag) {
                    sb.append(c);
                }
                i++;
            }
            set.add(sb.append(email.substring(i)).toString());
        }
        return set.size();
    }
}
// @lc code=end

