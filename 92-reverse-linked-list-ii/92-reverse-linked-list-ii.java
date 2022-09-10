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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode start = dummy;
        ListNode end = dummy;
        ListNode cur = dummy;
        int count = 0;
        while (cur != null) {
            if (left - 1 == count) {
                start = cur;
            }
            if (right == count) {
                end = cur;
            }
            cur = cur.next;
            count++;
        }
        ListNode secondHead = start.next;
        start.next = null;
        ListNode thirdHead = end.next;
        end.next = null;
        cur = secondHead;
        ListNode prev = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        start.next = prev;
        secondHead.next = thirdHead;
        return dummy.next;
    }
}