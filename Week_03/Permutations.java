package leetcode.editor.cn;
//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法


import java.util.ArrayList;
import java.util.List;

public class Permutations
{
  public static void main(String[] args) 
  {
       Solution solution = new Permutations().new Solution();
  }
  
  //题目编号:46
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
      private List<List<Integer>> dataList = new ArrayList<>();
      public List<List<Integer>> permute(int[] nums) {
          boolean [] used = new boolean[nums.length];

          doPermute(new ArrayList<>(),nums,used,0);

          return dataList;
      }

      private  void doPermute(List<Integer> list,int[] nums,
                                    boolean [] used,int first){
          if(first == nums.length){
              dataList.add(new ArrayList<>(list));
              return;
          }

          for(int i = 0;i < nums.length;i++){
              if(!used[i]){
                  used[i] = true;
                  list.add(nums[i]);

                  doPermute(list,nums,used,first + 1);

                  //回溯
                  used[i] = false;
                  list.remove(list.size() - 1);
              }
          }
      }
}
//leetcode submit region end(Prohibit modification and deletion)

}