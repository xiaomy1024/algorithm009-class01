package leetcode.editor.cn;
//给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。 
//
// 示例 1: 
//
// 输入: [1,2,3,4,5,6,7] 和 k = 3
//输出: [5,6,7,1,2,3,4]
//解释:
//向右旋转 1 步: [7,1,2,3,4,5,6]
//向右旋转 2 步: [6,7,1,2,3,4,5]
//向右旋转 3 步: [5,6,7,1,2,3,4]
// 
//
// 示例 2: 
//
// 输入: [-1,-100,3,99] 和 k = 2
//输出: [3,99,-1,-100]
//解释: 
//向右旋转 1 步: [99,-1,-100,3]
//向右旋转 2 步: [3,99,-1,-100] 
//
// 说明: 
//
// 
// 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。 
// 要求使用空间复杂度为 O(1) 的 原地 算法。 
// 
// Related Topics 数组


import java.util.Arrays;

public class RotateArray
{
  public static void main(String[] args) 
  {
       Solution solution = new RotateArray().new Solution();
       int []nums = {1,2,3,4,5,6,7};
       solution.doTest2(nums,3);
  }
  
  //题目编号:189
  //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void rotate(int[] nums, int k) {
            //第一种方法O(n)
            doTest2(nums,k);
        }

        private void doTest1(int[] nums,int k)
        {
            //第一种方法O(n^2)
            for(int i = 0;i < k;i++){
                int temp = nums[nums.length - 1];
                System.arraycopy(nums,0,nums,1,nums.length - 1);
                nums[0] =  temp;
            }
            System.out.println(Arrays.toString(nums));
        }

      /**
       * 环状运动法
       * @param nums
       * @param k
       */
        private void doTest2(int[] nums,int k)
        {
            k = k % nums.length;
            int count = 0;
            for(int i = 0;count < nums.length;i++){
                //移动的下一个位置
                int next = i;
                int pre = nums[i];
                do{
                    next = (next + k) % nums.length;
                    int temp = nums[next];
                    nums[next] = pre;
                    pre = temp;
                    count++;
                }while ( i!= next);
            }
            System.out.println(Arrays.toString(nums));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}