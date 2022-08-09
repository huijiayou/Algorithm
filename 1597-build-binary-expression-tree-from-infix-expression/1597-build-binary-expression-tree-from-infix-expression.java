/**
 * Definition for a binary tree node.
 * class Node {
 *     char val;
 *     Node left;
 *     Node right;
 *     Node() {this.val = ' ';}
 *     Node(char val) { this.val = val; }
 *     Node(char val, Node left, Node right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public Node expTree(String s) {
        /*
              - same priority, pop and add
              - incoming higher priority operator, add
              - incoming lower priority, pop and add
              - (, add
              - ), pop until find the first (

              - convert infix to postfix
              - convert postfix to tree
        */
        Map<Character, Integer> map = Map.of('+', 1, '-', 1, '*', 2, '/', 2, '(', 3);
        String postfix = createPostfix(s, map);
        return createTree(postfix);
    }
    private Node createTree(String postfix) {
        Deque<Node> stack = new ArrayDeque<>();
        for (char ch : postfix.toCharArray()) {
            if (Character.isDigit(ch)) {
                stack.offerLast(new Node(ch));
            } else {
                Node newNode = new Node(ch);
                newNode.right = stack.pollLast();
                newNode.left = stack.pollLast();
                stack.offerLast(newNode);
            }
        }
        return stack.pollLast();
    }
    private String createPostfix(String s, Map<Character, Integer> map) {
        StringBuilder sb = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>();
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                sb.append(ch);
            } else {
                if (ch == '(') {
                    stack.offerLast(ch);
                } else if (ch == ')') {
                    while (!stack.isEmpty() && stack.peekLast() != '(') {
                        sb.append(stack.pollLast());
                    }
                    stack.pollLast();
                } else {
                    while (!stack.isEmpty() && map.get(stack.peekLast()) >= map.get(ch) && stack.peekLast() != '(') {
                        sb.append(stack.pollLast());
                    }
                    stack.offerLast(ch);
                }
            }
        }
        while (!stack.isEmpty()) sb.append(stack.pollLast());
        System.out.println(sb.toString());
        return sb.toString();
    }
}







