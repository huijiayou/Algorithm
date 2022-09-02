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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        int size = 0;
        ListNode cur = head;
        ListNode tail = head;
        while (cur != null) {
            size++;
            tail = cur;
            cur = cur.next;
        }
        k %= size;
        if (k == 0) {
            return head;
        }
        int skip = size - k;
        cur = head;
        while (skip > 1) {
            cur = cur.next;
            skip--;
        }
        ListNode newHead = cur.next;
        cur.next = null;
        tail.next = head;
        return newHead;
    }
}