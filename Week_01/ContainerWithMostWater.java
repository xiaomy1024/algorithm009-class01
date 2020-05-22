package leetcode.editor.cn;
//给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, 
//ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。 
//
// 说明：你不能倾斜容器，且 n 的值至少为 2。 
//
// 
//
// 
//
// 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。 
//
// 
//
// 示例： 
//
// 输入：[1,8,6,2,5,4,8,3,7]
//输出：49 
// Related Topics 数组 双指针

  
 
public class ContainerWithMostWater
{
  public static void main(String[] args) 
  {
       Solution solution = new ContainerWithMostWater().new Solution();
       int [] nums = {1,8,6,2,5,4,8,3,7};
      System.out.println(solution.maxArea(nums));
  }
  
  
  //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxArea(int[] height) {

            //思路，1.暴力算出所有柱子内的面积盛水面积,时间复杂度O(n^2)，找出最大的
            int max = 0;
//            for(int i =  0;i < height.length;i++){
//                for(int j = i + 1;j < height.length;j++){
//                    max = Math.max(max,(j - i) * Math.min(height[i],height[j]));
//                }
//            }
            //思路2 使用双指针法，时间复杂度O(n)
            //此处需要注意的是，移动矮柱子，原因:因为移动高柱子，后面计算的面积必然比原来的小，因此没有必要移动高柱子了
            for(int i = 0,j = height.length - 1;i < j;){
                //获取左右两个最短的柱子高度，并移动
                int minHeight = height[i] < height[j]?height[i++]:height[j--];
                //计算面积,这里加1的原因是，上面++或者--操作的时候，导致两个差值少了1，所以这里加回来
                max = Math.max(max,(j - i + 1) * minHeight);
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}