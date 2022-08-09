/**
 * This is the interface for the expression tree Node.
 * You should not remove it, and you can define some classes to implement it.
 */

abstract class Node {
    public abstract int evaluate();
    // define your fields here
};

class NumNode extends Node {
    private int val;
    public NumNode(int val) {
        this.val = val;
    }
    public int evaluate() {
        return this.val;
    }
}

class OperNode extends Node {
    private char oper;
    private Node left;
    private Node right;
    public OperNode(char oper, Node left, Node right) {
        this.oper = oper;
        this.left = left;
        this.right = right;
    }
    public int evaluate() {
        switch(this.oper) {
            case '+':
                return this.left.evaluate() + this.right.evaluate();
            case '-':
                return this.left.evaluate() - this.right.evaluate();
            case '*':
                return this.left.evaluate() * this.right.evaluate();
            case '/':
                return this.left.evaluate() / this.right.evaluate();
            default:
                return 0;
        }
    }
}

/**
 * This is the TreeBuilder class.
 * You can treat it as the driver code that takes the postinfix input 
 * and returns the expression tree represnting it as a Node.
 */

class TreeBuilder {
    Node buildTree(String[] postfix) {
        Deque<Node> stack = new ArrayDeque<>();
        for (String ch : postfix) {
            char cur = ch.charAt(0);
            if (Character.isDigit(cur)) {
                stack.offerLast(new NumNode(Integer.parseInt(ch)));
            } else {
                Node right = stack.pollLast();
                Node left = stack.pollLast();
                Node newNode = new OperNode(cur, left, right);
                stack.offerLast(newNode);
            }
        }
        return stack.pollLast();
    }
};


/**
 * Your TreeBuilder object will be instantiated and called as such:
 * TreeBuilder obj = new TreeBuilder();
 * Node expTree = obj.buildTree(postfix);
 * int ans = expTree.evaluate();
 */