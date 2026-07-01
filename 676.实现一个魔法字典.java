/*
 * @lc app=leetcode.cn id=676 lang=java
 *
 * [676] 实现一个魔法字典
 */

// @lc code=start
class MagicDictionary {

    List<String> dict;

    public MagicDictionary() {
        dict = new ArrayList<>();
    }
    
    public void buildDict(String[] dictionary) {
        for (String word : dictionary) {
            dict.add(word);
        }
    }
    
    public boolean search(String searchWord) {
        for (String word : dict) {

            if (word.length() != searchWord.length()) {
                continue;
            }

            int diff = 0;

            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) != searchWord.charAt(i)) {
                    diff++;
                    if (diff > 1) {
                        break;
                    }
                }
            }

            if (diff == 1) {
                return true;
            }
        }

        return false;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */
// @lc code=end

