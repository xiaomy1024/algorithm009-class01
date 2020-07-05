package leetcode.editor.cn;
//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1: 
//
// 输入:
//[
//['1','1','1','1','0'],
//['1','1','0','1','0'],
//['1','1','0','0','0'],
//['0','0','0','0','0']
//]
//输出: 1
// 
//
// 示例 2: 
//
// 输入:
//[
//['1','1','0','0','0'],
//['1','1','0','0','0'],
//['0','0','1','0','0'],
//['0','0','0','1','1']
//]
//输出: 3
//解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集

  
 
public class NumberOfIslands
{
  public static void main(String[] args) 
  {
       Solution solution = new NumberOfIslands().new Solution();
  }
  
  //题目编号:200
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private int[] coloffset = {1,-1,0,0};
    private int[] rowOffset = {0,0,-1,1};

    public int numIslands(char[][] grid) {
        int count = 0;
        for(int row = 0;row < grid.length;row++){
            for(int col = 0; col < grid[row].length;col++){
                if(grid[row][col] == '1'){
                    count++;
                    fill(grid,row,col);
                }
            }
        }
        return count;
    }

    public  void  fill(char[][] grid,int row,int col){
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[row].length){
            return;
        }
        if(grid[row][col] == '0')return;

        grid[row][col] = '0';
        for(int i = 0;i < 4;i++){
            int new_row = row + rowOffset[i];
            int new_col = col + coloffset[i];
            fill(grid,new_row,new_col);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}