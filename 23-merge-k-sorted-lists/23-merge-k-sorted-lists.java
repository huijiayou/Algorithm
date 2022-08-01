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
    static class Pair{
        int list;
        ListNode node;
        public Pair(int list, ListNode node) {
            this.list = list;
            this.node = node;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Pair> minheap = new PriorityQueue<Pair>(new Comparator<Pair>() {
            @Override
            public int compare(Pair p1, Pair p2) {
                if (p1.node.val == p2.node.val) return 0;
                return p1.node.val < p2.node.val ? -1 : 1;
            }
        });
        
        for (int i = 0; i < lists.length; i++) {
            ListNode list = lists[i];
            if (list != null) minheap.offer(new Pair(i, list));
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(!minheap.isEmpty()) {
            Pair min = minheap.poll();
            cur.next = min.node;
            if (min.node.next != null) minheap.offer(new Pair(min.list, min.node.next));
            cur = cur.next;
        }
        cur.next = null;
        return dummy.next;
    }
}