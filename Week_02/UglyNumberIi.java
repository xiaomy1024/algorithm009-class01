package leetcode.editor.cn;
//编写一个程序，找出第 n 个丑数。 
//
// 丑数就是质因数只包含 2, 3, 5 的正整数。 
//
// 示例: 
//
// 输入: n = 10
//输出: 12
//解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。 
//
// 说明: 
//
// 
// 1 是丑数。 
// n 不超过1690。 
// 
// Related Topics 堆 数学 动态规划

  
 
public class UglyNumberIi
{
  public static void main(String[] args) 
  {
      Solution solution = new UglyNumberIi().new Solution();
      System.out.println(solution.nthUglyNumber(10));
  }
  
  //题目编号:264
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int nthUglyNumber(int n) {
        if(n <= 0){
            return 0;
        }
        //思路暴力法，循环判断数值是否，数的条件，时间复杂度O(3^n),时间过长
        //思路2，找规律，后续丑数 O(n)
        int a = 0,b=0,c=0;
        int []nums = new int[n];
        nums[0] = 1;//第一个
        int index = 1;
        while(n - 1 > 0){
            int n2 = nums[a] * 2;
            int n3 = nums[b] * 3;
            int n5 = nums[c] * 5;
            nums[index] = Math.min(Math.min(n2,n3),n5);
            if(nums[index] == n2)a++;
            if(nums[index] == n3)b++;
            if(nums[index] == n5)c++;
            index++;
            n--;
        }
        return nums[index-1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}