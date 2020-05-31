package leetcode.editor.cn;
//给定一个二叉树，返回它的 前序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [1,2,3]
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树


import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal
{
  public static void main(String[] args) 
  {
       Solution solution = new BinaryTreePreorderTraversal().new Solution();
  }
  
  //题目编号:144
  //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
    class Solution {
        private List<Integer> dataList = new ArrayList<>();
        public List<Integer> preorderTraversal(TreeNode root) {
            if(root == null){
                return dataList;
            }
            //前序 中，左，右
            dataList.add(root.val);

            //左
            preorderTraversal(root.left);

            //右
            preorderTraversal(root.right);
            return dataList;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}