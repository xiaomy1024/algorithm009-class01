package leetcode.editor.cn;
//给定一个可包含重复数字的序列，返回所有不重复的全排列。 
//
// 示例: 
//
// 输入: [1,1,2]
//输出:
//[
//  [1,1,2],
//  [1,2,1],
//  [2,1,1]
//] 
// Related Topics 回溯算法


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsIi
{
  public static void main(String[] args) 
  {
      Solution solution = new PermutationsIi().new Solution();
      int[] nums = {3,3,0,3};
      List<List<Integer>> dataList = solution.permuteUnique(nums);

      for(List<Integer> list:dataList){
          System.out.println(Arrays.toString(list.toArray()));
      }
  }
  
  //题目编号:47
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private List<List<Integer>> dataList = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean [] used = new boolean[nums.length];

        // 排序（升序或者降序都可以），排序是剪枝的前提
        Arrays.sort(nums);

        doPermuteUnique(new ArrayList<>(),nums,used,0);

        return dataList;
    }

    private  void doPermuteUnique(List<Integer> list,int[] nums,
                                  boolean [] used,int depth){
        if(depth == nums.length){
            dataList.add(new ArrayList<>(list));
            return;
        }

        for(int i = 0;i < nums.length;i++){
            if(!used[i]){

                // 写 !used[i - 1] 是因为 nums[i - 1] 在深度优先遍历的过程中刚刚被撤销选择
                if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                    continue;
                }

                used[i] = true;
                list.add(nums[i]);

                doPermuteUnique(list,nums,used,depth + 1);

                //回溯
                used[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}