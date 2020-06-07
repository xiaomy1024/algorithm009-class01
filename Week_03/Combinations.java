package leetcode.editor.cn;
//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 
//
// 示例: 
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
// Related Topics 回溯算法


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combinations
{
  public static void main(String[] args) 
  {
      Solution solution = new Combinations().new Solution();
      List<List<Integer>> dataList = solution.combine(4,2);
      for(List<Integer> list:dataList){
          System.out.println(Arrays.toString(list.toArray()));
      }
  }
  
  //题目编号:77
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private List<List<Integer>> dataList = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {

        docombine(new ArrayList<>(),1,k,n);
        return dataList;
    }

    private void docombine(List<Integer> list,int frist,int k,int n){
        if(list.size() == k){
            dataList.add(new ArrayList<>(list));
            return;
        }

        for(int i = frist;i <= n;i++){
            list.add(i);
            docombine(list,i + 1,k,n);
            //回溯
            list.remove(list.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}