package leetcode.editor.cn;
//给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
// 
//
// 示例: 
//
// 输入: 
//words = ["oath","pea","eat","rain"] and board =
//[
//  ['o','a','a','n'],
//  ['e','t','a','e'],
//  ['i','h','k','r'],
//  ['i','f','l','v']
//]
//
//输出: ["eat","oath"] 
//
// 说明: 
//你可以假设所有输入都由小写字母 a-z 组成。 
//
// 提示: 
//
// 
// 你需要优化回溯算法以通过更大数据量的测试。你能否早点停止回溯？ 
// 如果当前单词不存在于所有单词的前缀中，则可以立即停止回溯。什么样的数据结构可以有效地执行这样的操作？散列表是否可行？为什么？ 前缀树如何？如果你想学习如何
//实现一个基本的前缀树，请先查看这个问题： 实现Trie（前缀树）。 
// 
// Related Topics 字典树 回溯算法


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordSearchIi
{
  public static void main(String[] args) 
  {
       Solution solution = new WordSearchIi().new Solution();
  }
  
  //题目编号:212
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
      private TrieTree tree = new TrieTree();
      private List<String> r = new ArrayList();

      public List<String> findWords(char[][] board, String[] words) {
          init(words);

          //查找
          for(int row = 0;row < board.length;row++){
              for(int col = 0;col < board[row].length;col++){
                  //找到开始的字母
                  if(tree.root.chridren.containsKey(board[row][col])){
                      doFind(row,col,tree.root.chridren.get(board[row][col]),board);
                  }
              }
          }

          return r;
      }

      //递归查找
      public void  doFind(int row,int col,TrieNode parent,char[][] board){
          if(parent == null){
              return;
          }

          if(parent.word != null){
              r.add(parent.word);
              parent.word = null;
          }

          char letter = board[row][col];
          //同一次查找，只能使用一次
          board[row][col] = '@';

          //上下左右的查找
          int[] rowOffset = {0,0,-1,1};
          int[] colOffset = {1,-1,0,0};
          for(int i = 0;i < 4;i++){
              int newrow = row + rowOffset[i];
              int newcol = col + colOffset[i];
              if(newrow < 0 || newcol < 0 || newrow >= board.length || newcol >= board[row].length){
                  continue;
              }

              if(parent.chridren.containsKey(board[newrow][newcol])){
                  doFind(newrow,newcol,parent.chridren.get(board[newrow][newcol]),board);
              }
          }

          //还原
          board[row][col] = letter;
      }


      //构建字典树
      public void init(String[] words){
          for(String word:words){
              tree.insert(word);
          }
      }

      class TrieTree{
          public TrieNode root = new TrieNode();
          //插入数据
          public void insert(String word){
              TrieNode node = root;
              char[] chars =  word.toCharArray();
              for(char letter:chars){
                  if(node.chridren.containsKey(letter)){
                      node = node.chridren.get(letter);
                  }else{
                      TrieNode newNode = new TrieNode();
                      node.chridren.put(letter,newNode);
                      node = newNode;
                  }
              }
              node.word = word;
          }
      }

      //构建字典树
      class TrieNode{
          private String word = null;
          private Map<Character,TrieNode> chridren = new HashMap();
      }
}
//leetcode submit region end(Prohibit modification and deletion)

}