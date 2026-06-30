/*
 * @lc app=leetcode.cn id=792 lang=java
 *
 * [792] 匹配子序列的单词数
 */

// @lc code=start
class Solution {
    // 创建一个简单的节点类，用来记录单词以及当前匹配到了第几个字符
    class Node {
        String word;
        int index;

        Node(String word, int index) {
            this.word = word;
            this.index = index;
        }
    }

    public int numMatchingSubseq(String s, String[] words) {
        // 26个桶，对应 'a' 到 'z'
        List<Node>[] buckets = new ArrayList[26];
        for (int i = 0; i < 26; i++) {
            buckets[i] = new ArrayList<>();
        }

        // 初始化：把所有单词根据首字母扔进对应的桶里
        for (String word : words) {
            char firstChar = word.charAt(0);
            buckets[firstChar - 'a'].add(new Node(word, 0));
        }

        int count = 0;

        // 开始扫描字符串 s
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 拿到当前字符对应的桶
            List<Node> currentBucket = buckets[c - 'a'];
            
            // 因为在循环中我们会清空当前桶，所以先把它拷贝出来或者直接清空原桶
            // 这里为了防止并发修改错误，我们直接新建一个引用，并把原桶清空
            buckets[c - 'a'] = new ArrayList<>();

            for (Node node : currentBucket) {
                // 当前字符匹配成功，指针往后走一步
                node.index++;
                
                // 如果指针走到了单词末尾，说明整个单词匹配成功
                if (node.index == node.word.length()) {
                    count++;
                } else {
                    // 如果还没走完，看下一个字符是什么，扔进下一个字符的桶里
                    char nextChar = node.word.charAt(node.index);
                    buckets[nextChar - 'a'].add(node);
                }
            }
        }

        return count;
    }
}
// @lc code=end

