package leetcode.editor.cn;
//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
//的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例： 
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针


import java.util.*;

public class ThreeSum
{
  public static void main(String[] args) 
  {
      Solution solution = new ThreeSum().new Solution();
      int []nums = {-1, 0, 1, 2, -1, -4};
      List<List<Integer>> dataList = solution.threeSum(nums);
      for(List<Integer> data:dataList)
      {
          System.out.println(Arrays.toString(data.toArray()));
      }
  }
  
  //题目编号:15
  //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
           return sum3(nums);
        }

      /**
       * 双指针法
       * @param nums
       * @return
       */
      private List<List<Integer>> sum3(int[] nums){
          if(nums == null || nums.length < 3)return Collections.emptyList();
          List<List<Integer>> result = new ArrayList<>();
          Arrays.sort(nums);//排序
          for (int i = 0;i < nums.length;i++){
              if(nums[i] > 0)return result;//最小值都大于0了，没必要找了
              if(i > 0 && nums[i] == nums[i-1])continue;//去重

              int target = -nums[i];
              int left = i + 1,right = nums.length - 1;
              while(left < right){
                  int temp = nums[left] + nums[right];
                  if(temp == target){
                      while(left < right && nums[left] == nums[left + 1])left++;//去重
                      while(left < right && nums[right] == nums[right - 1])right--;//去重
                      result.add(Arrays.asList(nums[left],nums[i],nums[right]));
                      left++;right--;
                  } else {
                      if(temp > target){
                          right--;
                      } else {
                          left++;
                      }
                  }
              }
          }
          return result;
      }


      /**
       * hash 法时间，复杂度 O(n^2)
       * @param nums
       * @return
       */
      private List<List<Integer>> sum2(int[] nums){

          if (nums == null || nums.length <= 2) {
              return Collections.emptyList();
          }

          Set<List<Integer>> set = new HashSet<List<Integer>>();

          for(int i = 0;i < nums.length;i++){
              int target = -nums[i];
              Map<Integer,Integer> cache = new HashMap<Integer, Integer>();
              for(int j = i+1;j < nums.length - 2;i++){
                 int findVal = target - nums[j];
                 Integer otherVal = cache.get(findVal);
                 if(otherVal!=null){
                     List<Integer> list = Arrays.asList(nums[i],nums[j],otherVal);
                     list.sort(Comparator.<Integer>naturalOrder());
                     set.add(list);
                 } else {
                     cache.put(nums[j],nums[j]);
                 }
              }
          }
          return new ArrayList<List<Integer>>(set);
      }

      /**
       * 暴力法，时间复杂度O(n^3)
       * @param nums
       * @return
       */
        private List<List<Integer>> sum1(int[] nums){
            Arrays.sort(nums);
            Set<List<Integer>> set = new HashSet<List<Integer>>();

            //暴力法
            for(int i = 0;i < nums.length - 2;i++){
                for(int j = i + 1;j < nums.length - 1;j++){
                    for(int k = j + 1;k < nums.length;k++){
                        if(nums[i] + nums[j] + nums[k] == 0){
                            List<Integer> result = Arrays.asList(nums[i],nums[j],nums[k]);
                            set.add(result);
                        }
                    }
                }
            }
            return new ArrayList<List<Integer>>(set);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}