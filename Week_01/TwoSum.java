package leetcode.editor.cn;
//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，
// 并返回他们的数组下标。
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。 
//
// 
//
// 示例: 
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
// 
// Related Topics 数组 哈希表


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum
{
  public static void main(String[] args) 
  {
      Solution solution = new TwoSum().new Solution();
      int[] nums = {7, 2, 11, 15,6,10};
      int []result = solution.twoSum(nums,12);
      System.out.print(Arrays.toString(result));
  }
  
  //思路：
  //思路1：暴力解法，嵌套循环找到两数之和的下标,时间复杂度O(n^2)
  //思路2：借助数据结构hash表，target 减去nums[i] 剩下的数据是否存在于hash表中,需要两次循环，时间复杂度O(2n)
  //思路3：可以对思路2，进行改进，使用1次循环
  //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer,Integer> cache = new HashMap<Integer, Integer>();
            for(int i = 0;i < nums.length;i++){
                int needVal = target - nums[i];
                //是否存在？
                Integer value = cache.get(needVal);
                if(value != null){
                    return new int[]{value,i};
                }
                cache.put(nums[i],i);
            }
            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}