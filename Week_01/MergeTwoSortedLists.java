package leetcode.editor.cn;
//将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 示例： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
// 
// Related Topics 链表

  
 
public class MergeTwoSortedLists
{
    
  public static void main(String[] args) 
  {
       Solution solution = new MergeTwoSortedLists().new Solution();

      ListNode listNode1 = new MergeTwoSortedLists().new ListNode(1);
      MergeTwoSortedLists.ListNode listNode1_1 = new MergeTwoSortedLists().new ListNode(2);        
      listNode1.next = listNode1_1;  
      
      MergeTwoSortedLists.ListNode listNode1_2 = new MergeTwoSortedLists().new ListNode(4);   
      listNode1_1.next = listNode1_2;

      ListNode listNode2 = new MergeTwoSortedLists().new ListNode(1);
       MergeTwoSortedLists.ListNode listNode2_1 = new MergeTwoSortedLists().new ListNode(3);
       listNode2.next = listNode2_1;

       MergeTwoSortedLists.ListNode listNode2_2 = new MergeTwoSortedLists().new ListNode(4);
       listNode2_1.next = listNode2_2;                                                              MergeTwoSortedLists.ListNode listNode4 = new MergeTwoSortedLists().new ListNode(4);
     


      MergeTwoSortedLists.ListNode result = solution.mergeTwoLists(listNode1,listNode2);
      while(result!=null){
          System.out.print(result.val+",");
          result = result.next;
      }
  }
  
  //题目编号:21
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode phead = new ListNode(-1);
        ListNode head = phead;

        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                head.next = l1;
                l1 = l1.next;
            } else {
                head.next = l2;
                l2 = l2.next;
            }
            head =  head.next;
        }
        head.next = l1 != null?l1:l2;
        return phead.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
    public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
    }
}