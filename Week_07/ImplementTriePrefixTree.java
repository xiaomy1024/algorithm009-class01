package leetcode.editor.cn;
//实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。 
//
// 示例: 
//
// Trie trie = new Trie();
//
//trie.insert("apple");
//trie.search("apple");   // 返回 true
//trie.search("app");     // 返回 false
//trie.startsWith("app"); // 返回 true
//trie.insert("app");   
//trie.search("app");     // 返回 true 
//
// 说明: 
//
// 
// 你可以假设所有的输入都是由小写字母 a-z 构成的。 
// 保证所有输入均为非空字符串。 
// 
// Related Topics 设计 字典树

  
 
public class ImplementTriePrefixTree
{
  public static void main(String[] args) 
  {
       Solution solution = new ImplementTriePrefixTree().new Solution();
  }
  
  //题目编号:208
  //leetcode submit region begin(Prohibit modification and deletion)
class Trie {

    private TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for(char letter:word.toCharArray()){
            if(node.next[letter - 'a'] == null){
                node.next[letter - 'a'] = new TrieNode();
            }
            node = node.next[letter - 'a'];
        }
        node.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = root;
        for(char letter:word.toCharArray()){
            if(node.next[letter - 'a'] == null){
                return false;
            }
            node = node.next[letter - 'a'];
        }
        return node.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for(char letter:prefix.toCharArray()){
            if(node.next[letter - 'a'] == null){
                return false;
            }
            node = node.next[letter - 'a'];
        }
        return node != null;
    }

    class TrieNode{
        private boolean isEnd = false;
        private TrieNode[] next = new TrieNode[26];
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)

}