package leetcode.editor.cn;
//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 
//
// 上图为 8 皇后问题的一种解法。 
//
// 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。 
//
// 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 示例: 
//
// 输入: 4
//输出: [
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
//解释: 4 皇后问题存在两个不同的解法。
// 
//
// 
//
// 提示： 
//
// 
// 皇后，是国际象棋中的棋子，意味着国王的妻子。皇后只做一件事，那就是“吃子”。当她遇见可以吃的棋子时，就迅速冲上去吃掉棋子。当然，她横、竖、斜都可走一到七步
//，可进可退。（引用自 百度百科 - 皇后 ） 
// 
// Related Topics 回溯算法


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NQueens
{
  public static void main(String[] args) 
  {
       Solution solution = new NQueens().new Solution();
  }
  
  //题目编号:51
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private Set<Integer> cols = new HashSet<>();
    private Set<Integer> pres = new HashSet<>();
    private Set<Integer> nas = new HashSet<>();
    private int [] queens;
    private List<List<String>>  result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        queens = new int[n];
        doSolveNQueen(0,n);
        return result;
    }

    private void  doSolveNQueen(int row,int n){
        for(int col = 0;col < n;col++){
            if(!isAttack(row,col)){
                put(row,col);
                if(row + 1 == n)print(n);
                else doSolveNQueen(row + 1,n);

                remove(row,col);
            }

        }
    }

    private void put(int row,int col){
        queens[row] = col;
        cols.add(col);
        pres.add(row + col);
        nas.add(row - col);
    }

    private void remove(int row,int col){
        queens[row] = 0;
        cols.remove(col);
        pres.remove(row + col);
        nas.remove(row - col);
    }

    private void print(int n){
        List<String> list = new ArrayList<>();
        for(int row = 0;row < n;row ++){
            StringBuilder sb = new StringBuilder();
            int col = queens[row];
            for(int i = 0;i < col;i++){
                sb.append(".");
            }
            sb.append("Q");
            for(int i = col + 1;i < n;i++){
                sb.append(".");
            }
            list.add(sb.toString());
        }
        result.add(list);
    }

    private  boolean isAttack(int row,int col){
        if(cols.contains(col) || pres.contains(row + col) || nas.contains(row - col))
            return true;
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}