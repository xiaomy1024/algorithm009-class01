package leetcode.editor.cn;
//给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。 
//
// 你需要返回给定数组中的重要翻转对的数量。 
//
// 示例 1: 
//
// 
//输入: [1,3,2,3,1]
//输出: 2
// 
//
// 示例 2: 
//
// 
//输入: [2,4,3,5,1]
//输出: 3
// 
//
// 注意: 
//
// 
// 给定数组的长度不会超过50000。 
// 输入数组中的所有数字都在32位整数的表示范围内。 
// 
// Related Topics 排序 树状数组 线段树 二分查找 分治算法

  
 
public class ReversePairs
{
  public static void main(String[] args) 
  {
       Solution solution = new ReversePairs().new Solution();
  }
  
  //题目编号:493
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int reversePairs(int[] nums) {

        return mergeSort(nums,0,nums.length - 1);
    }

  /**
   * 排序
   * @param nums
   * @param left
   * @param right
   * @return
   */
    private int mergeSort(int[] nums,int left,int right){
        if(left >= right)return 0;
        int mid = ((right - left) >> 2 ) + left;

        int count = mergeSort(nums,left,mid) + mergeSort(nums,mid + 1,right);
        int i = left,j = mid + 1,k = 0,p = left;
        int [] temps = new int[right - left + 1];

        //合并
        while(j <= right){
            while(p <= mid && nums[p] <= 2L * nums[j])p++;
            count += mid + 1 - p;

            while(i <= mid && nums[i] <= nums[j])temps[k++] = nums[i++];
            temps[k++] = nums[j++];
        }

        //合并剩下的左边数组
        while(i <= mid)temps[k++] = nums[i++];

        System.arraycopy(temps,0,nums,left,temps.length);
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}