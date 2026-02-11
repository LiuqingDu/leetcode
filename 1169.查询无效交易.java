/*
 * @lc app=leetcode.cn id=1169 lang=java
 *
 * [1169] 查询无效交易
 */

// @lc code=start
class Solution {
    static class Transaction {
        String name;
        int time;
        int amount;
        String city;
        String raw; // 原始字符串

        Transaction(String s) {
            raw = s;
            String[] parts = s.split(",");
            name = parts[0];
            time = Integer.parseInt(parts[1]);
            amount = Integer.parseInt(parts[2]);
            city = parts[3];
        }
    }

    public List<String> invalidTransactions(String[] transactions) {
        int n = transactions.length;
        Transaction[] list = new Transaction[n];
        boolean[] invalid = new boolean[n];

        // 1. 解析交易
        for (int i = 0; i < n; i++) {
            list[i] = new Transaction(transactions[i]);
            if (list[i].amount > 1000) {
                invalid[i] = true;
            }
        }

        // 2. 检查同名 + 不同城市 + 60分钟内
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (list[i].name.equals(list[j].name)
                        && !list[i].city.equals(list[j].city)
                        && Math.abs(list[i].time - list[j].time) <= 60) {
                    invalid[i] = true;
                    invalid[j] = true;
                }
            }
        }

        // 3. 收集结果
        List<String> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (invalid[i]) {
                result.add(list[i].raw);
            }
        }

        return result;
    }
}
// @lc code=end

