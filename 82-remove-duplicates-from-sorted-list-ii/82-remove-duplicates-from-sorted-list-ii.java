/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        /*
            -1111 -> 3  -> 4   4   5   6
                     s
                                    f
            dummy
            dummy.next = head;
            slow = head;
            fast = head.next;
            prev = dummy;
            while(fast != null) 
                if (slow.val == fast.val)
                    slow = prev;
                    while (fast.val ==slow.next.val) {
                        fast = fast.next;
                    }
                else 
                    slow.next = fast;
                    prev = slow;
                    slow = slow.next;
                    fast = fast.next;
        */
        if (head == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null) {
            if (slow.val == fast.val) {
                slow = prev;
                while (fast != null && slow.next.val == fast.val) {
                    fast = fast.next;
                }
                slow.next = null;
            } else {
                slow.next = fast;
                prev = slow;
                slow = slow.next;
                fast = fast.next;
            }
        }
        return dummy.next;
    }
}