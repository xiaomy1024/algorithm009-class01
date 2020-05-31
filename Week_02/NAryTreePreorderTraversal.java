package leetcode.editor.cn;
//给定一个 N 叉树，返回其节点值的前序遍历。 
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 返回其前序遍历: [1,3,5,6,2,4]。 
//
// 
//
// 说明: 递归法很简单，你可以使用迭代法完成此题吗? Related Topics 树


import java.util.ArrayList;
import java.util.List;

public class NAryTreePreorderTraversal
{
  public static void main(String[] args) 
  {
       Solution solution = new NAryTreePreorderTraversal().new Solution();
  }
  
  //题目编号:589
  //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    List<Integer> list = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        if(root == null) return list;

        //前序,先根节点
        list.add(root.val);
        if(root.children != null && root.children.size() > 0){
            for(Node child:root.children){
                preorder(child);
            }
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}