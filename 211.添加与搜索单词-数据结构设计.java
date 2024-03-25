/*
 * @lc app=leetcode.cn id=211 lang=java
 *
 * [211] 添加与搜索单词 - 数据结构设计
 */

// @lc code=start
class WordDictionary {
    
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean end = false;
    }

    TrieNode root = new TrieNode();

    public WordDictionary() {

    }
    
    public void addWord(String word) {

        TrieNode node = root;
        for (char c: word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.end = true;

    }
    
    public boolean search(String word) {

        return dfs(root, word.toCharArray(), 0);
    }

    private boolean dfs(TrieNode node, char[] chars, int ind) {
        if (ind == chars.length) {
            return node.end;
        }
        if (chars[ind] != '.') {
            return node.children[chars[ind] - 'a'] != null && dfs(node.children[chars[ind] - 'a'], chars, ind + 1);
        } else {
            for (TrieNode t: node.children) {
                if (t != null && dfs(t, chars, ind + 1)) {
                    return true;
                }
            }
            return false;
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
// @lc code=end

