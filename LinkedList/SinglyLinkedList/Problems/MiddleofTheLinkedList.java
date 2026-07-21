// 876. Middle of the Linked List
// Given the head of a singly linked list, return the middle node of the linked list.
// If there are two middle nodes, return the second middle node.

package Problems;

public class MiddleofTheLinkedList {
  public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
  

  public ListNode middleNode(ListNode head) {
        // int size = 0;
        // ListNode temp = head;

        // while (temp != null) {
        //     temp = temp.next;
        //     size++;
        // }

        // size /= 2;

        // ListNode res = head;

        // for (int i = 1; i <= size; i++) {
        //     res = res.next;
        // }

        // System.out.println(size);
        // return res;

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
          slow = slow.next;
          fast = fast.next.next;
        }
        
        return slow;
    }
}
