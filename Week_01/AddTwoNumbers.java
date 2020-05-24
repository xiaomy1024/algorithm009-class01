package leetcode.editor.cn;
//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。 
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 示例： 
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
// 
// Related Topics 链表 数学

  
 
public class AddTwoNumbers
{
  public static void main(String[] args)
  {
      Solution solution = new AddTwoNumbers().new Solution();
      ListNode l1 = new ListNode(2);
      l1.next = new ListNode(4);
      l1.next.next = new ListNode(3);


      ListNode l2 = new ListNode(5);
      l2.next = new ListNode(6);
      l2.next.next = new ListNode(4);

     ListNode result = solution.addTwoNumbers(l1,l2);
     while(result!=null)
     {
         System.out.printf(result.val+"");
         result = result.next;
     }
  }
  
  //思路：
  //从左到右开始计算，满10 进 1 用于下一位的添加运算，可以使用循环实现
  //也可以使用递归实现
  //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

            //思路：
            //从左到右开始计算，满10 进 1 用于下一位的添加运算，可以使用循环实现
            //也可以使用递归实现
            //运算时间复杂度,取决于数字的位数，0(n)

            //结果
            ListNode result = new ListNode(0);

            //当前结算节点
            ListNode current = result;

            int add_value = 0;
            while(current != null) {

                int value1 = l1 == null?0:l1.val;
                int value2 = l2 == null?0:l2.val;

                //计算该位新值
                int new_val =  value1 + value2 + add_value;
                if(new_val >= 10){
                   new_val = new_val%10;
                   add_value =  1;
                } else {
                    add_value =  0;
                }
                //当前节点
                current.val = new_val;

                //是否需要计算下一个节点
                l1 = l1 == null?null:l1.next;
                l2 = l2 == null?null:l2.next;
                if(l1!=null || l2!=null || add_value != 0){
                    current.next = new ListNode(0);
                    current = current.next;
                }else{
                    current = null;
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static class ListNode
    {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
    }
}