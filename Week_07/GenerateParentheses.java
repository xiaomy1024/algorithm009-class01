package leetcode.editor.cn;
//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例： 
//
// 输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
// 
// Related Topics 字符串 回溯算法


import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses
{
  public static void main(String[] args) 
  {
       Solution solution = new GenerateParentheses().new Solution();
  }
  
  //题目编号:22
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {

        doCreate(n,0,0,"");
        return result;
    }

    //生成括号
    public  void doCreate(int n,int left,int right,String str){
        if(right == n){
            result.add(str);
            return;
        }

        if(left < n){
            doCreate(n,left + 1,right,str + "(");
        }
        if(right < left){
            doCreate(n,left,right + 1,str + ")");
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}