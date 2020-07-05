package leetcode.editor.cn;
//给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
// 
//
// 
// 每次转换只能改变一个字母。 
// 转换过程中的中间单词必须是字典中的单词。 
// 
//
// 说明: 
//
// 
// 如果不存在这样的转换序列，返回 0。 
// 所有单词具有相同的长度。 
// 所有单词只由小写字母组成。 
// 字典中不存在重复的单词。 
// 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。 
// 
//
// 示例 1: 
//
// 输入:
//beginWord = "hit",
//endWord = "cog",
//wordList = ["hot","dot","dog","lot","log","cog"]
//
//输出: 5
//
//解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
//     返回它的长度 5。
// 
//
// 示例 2: 
//
// 输入:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//
//输出: 0
//
//解释: endWord "cog" 不在字典中，所以无法进行转换。 
// Related Topics 广度优先搜索


import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordLadder
{
  public static void main(String[] args) 
  {
       Solution solution = new WordLadder().new Solution();
  }
  
  //题目编号:127
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if(!wordSet.contains(endWord)){
            return 0;
        }

        Set<String> beginSet = new HashSet<>();beginSet.add(beginWord);
        Set<String> endSet = new HashSet<>();endSet.add(endWord);
        int step = 1;

        Set<String> visitedSet = new HashSet<>();

        while(beginSet.size() > 0 && endSet.size() > 0){
            //循环大的
            if(endSet.size() > beginSet.size()){
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }
            Set<String> next =  new HashSet<>();
            for(String word : beginSet){
                char[] orgin_char = word.toCharArray();
                for(int i = 0;i < orgin_char.length;i++){
                    char temp = orgin_char[i];
                    for(char k = 'a';k <= 'z';k++){
                        if(temp == k)continue;
                        orgin_char[i] = k;
                        String newStr = new String(orgin_char);
                        if(wordSet.contains(newStr) && !visitedSet.contains(newStr)){
                            if(endSet.contains(newStr))return step + 1;

                            visitedSet.add(newStr);
                            next.add(newStr);
                        }
                    }
                    //还原
                    orgin_char[i] = temp;
                }
            }
            beginSet = next;step++;
        }
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}