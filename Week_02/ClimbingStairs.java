package leetcode.editor.cn;
//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 注意：给定 n 是一个正整数。 
//
// 示例 1： 
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶 
//
// 示例 2： 
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
// 
// Related Topics 动态规划

  
 
public class ClimbingStairs
{
  public static void main(String[] args) 
  {
      Solution solution = new ClimbingStairs().new Solution();
      System.out.println(solution.climbStairs(4));
  }
  
  //题目编号:70
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int climbStairs(int n) {
        if(n <= 2){
            return n;
        }

        //思路1，暴力，没戏
        //思路2，找最小执行单位 n1 = 1 n2 = 1,2   n3 = n1 + n2   n4 = n3+n2
        //多少种方法
        int result = 0;
        int n1 = 1;
        int n2 = 2;
        for(int i = 2;i < n;i++){
            result = n1 + n2;
            n1 = n2;
            n2 = result;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}