/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Map<Node, Node> map = new HashMap<>();
        map.put(head, new Node(head.val));
        Node curold = head;
        Node curnew = map.get(head);
        
        while (curold != null) {
            if (curold.next != null) {
                if(!map.containsKey(curold.next)) {
                    map.put(curold.next, new Node(curold.next.val));
                }
                curnew.next = map.get(curold.next);
            }
            if (curold.random != null) {
                if(!map.containsKey(curold.random)) {
                    map.put(curold.random, new Node(curold.random.val));
                }
                curnew.random = map.get(curold.random);
            }
            curold = curold.next;
            curnew = curnew.next;
        }
        return map.get(head);
    }
}