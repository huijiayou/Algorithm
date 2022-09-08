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
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return head;
        }
        ListNode smaller = new ListNode(0);
        ListNode larger = new ListNode(0);
        ListNode smallerCur = smaller;
        ListNode largerCur = larger;
        
        while (head != null) {
            if (head.val < x) {
                smallerCur.next = head;
                smallerCur = smallerCur.next;
            } else {
                largerCur.next = head;
                largerCur = largerCur.next;
            }
            head = head.next;
        }
        largerCur.next = null;
        smallerCur.next = larger.next;
        larger.next = null;
        return smaller.next;
    }
}