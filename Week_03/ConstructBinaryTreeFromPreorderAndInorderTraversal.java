package leetcode.editor.cn;
//根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组


import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal
{
  public static void main(String[] args) 
  {
       Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
  }
  
  //题目编号:105
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
    private Map<Integer,Integer> indexMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0;i < inorder.length;i++){
            indexMap.put(inorder[i],i);
        }
        int n = preorder.length;

        return buildMyTree(preorder,inorder,0,n - 1,
                0,n - 1);
    }

    public TreeNode buildMyTree(int[] preorder, int[] inorder,
                                int preorder_left,int preorder_right,
                                int inorder_left,int inorder_right){
        if(preorder_left > preorder_right)return null;

        int pre_root = preorder_left;
        int in_root_index = indexMap.get(preorder[preorder_left]);
        TreeNode node = new TreeNode(preorder[preorder_left]);
        //左子树数量
        int left_size_sub = in_root_index - inorder_left;

        node.left = buildMyTree(preorder,inorder,preorder_left + 1,
                preorder_left + left_size_sub,inorder_left,in_root_index - 1);
        node.right = buildMyTree(preorder,inorder,preorder_left + left_size_sub + 1,
                preorder_right,in_root_index + 1,inorder_right);

        return node;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}