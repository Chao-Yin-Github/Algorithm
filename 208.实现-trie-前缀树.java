/*
 * @lc app=leetcode.cn id=208 lang=java
 *
 * [208] 实现 Trie (前缀树)
 *
 * https://leetcode-cn.com/problems/implement-trie-prefix-tree/description/
 *
 * algorithms
 * Medium (65.50%)
 * Likes:    225
 * Dislikes: 0
 * Total Accepted:    28.3K
 * Total Submissions: 43.2K
 * Testcase Example:  '["Trie","insert","search","search","startsWith","insert","search"]\n' +
  '[[],["apple"],["apple"],["app"],["app"],["app"],["app"]]'
 *
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 * 
 * 示例:
 * 
 * Trie trie = new Trie();
 * 
 * trie.insert("apple");
 * trie.search("apple");   // 返回 true
 * trie.search("app");     // 返回 false
 * trie.startsWith("app"); // 返回 true
 * trie.insert("app");   
 * trie.search("app");     // 返回 true
 * 
 * 说明:
 * 
 * 
 * 你可以假设所有的输入都是由小写字母 a-z 构成的。
 * 保证所有输入均为非空字符串。
 * 
 * 
 */

// @lc code=start
class Trie {
    TreeNode root;

    class TreeNode {
        TreeNode[] nodes;
        char val;

        public TreeNode() {
            nodes = new TreeNode[26];
        }

        public TreeNode(char val) {
            nodes = new TreeNode[26];
            this.val = val;
        }
    }

    /** Initialize your data structure here. */
    public Trie() {
        root = new TreeNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (root.nodes[chars[i] - 'a'] != null) {
                continue;
            } else {
                root.nodes[chars[i] - 'a'] = new TreeNode(chars[i]);
            }
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TreeNode tempNode = root;
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (tempNode.nodes[chars[i] - 'a'] == null) {
                return false;
            }
            tempNode = tempNode.nodes[chars[i] - 'a'];
        }
        // tempNode = tempNode.nodes[chars[i]-'a'];
        System.out.println(tempNode.val);
        for (int i = 0; i < 26; i++) {
            if (tempNode.nodes[i] != null) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TreeNode tempNode = root;
        char[] chars = prefix.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (tempNode.nodes[chars[i] - 'a'] == null) {
                return false;
            }
            tempNode = tempNode.nodes[chars[i] - 'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such: Trie obj = new
 * Trie(); obj.insert(word); boolean param_2 = obj.search(word); boolean param_3
 * = obj.startsWith(prefix);
 */
// @lc code=end
