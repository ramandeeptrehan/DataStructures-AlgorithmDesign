//LC medium: premium account
//https://leetcode.com/problems/clone-binary-tree-with-random-pointer/

/*
A binary tree is given such that each node contains an additional random pointer which could point to any node in the tree or null.

Return a deep copy of the tree.

The tree is represented in the same input/output way as normal binary trees where each node is represented as a pair of [val, random_index] where:

val: an integer representing Node.val
random_index: the index of the node (in the input) where the random pointer points to, or null if it does not point to any node.
You will be given the tree in class Node and you should return the cloned tree in class NodeCopy. NodeCopy class is just a clone of Node class with the same attributes and constructors.

*/

/**
 * Definition for Node.
 * public class Node {
 *     int val;
 *     Node left;
 *     Node right;
 *     Node random;
 *     Node() {}
 *     Node(int val) { this.val = val; }
 *     Node(int val, Node left, Node right, Node random) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *         this.random = random;
 *     }
 * }
 */

class Solution {
    public NodeCopy copyRandomBinaryTree(Node root) {
        if(root == null) {
            return null;
        }
        
        Stack<Node> stack = new Stack<>();
        Map<Node, NodeCopy> map = new HashMap<>();
        
        stack.push(root);
        
        Node stackNode = null;
        while(!stack.isEmpty()) {
            stackNode = stack.pop();
            map.put(stackNode, new NodeCopy(stackNode.val));
            
            if(stackNode.left!=null) {
                stack.push(stackNode.left);
            }
            
            if(stackNode.right!=null) {
                stack.push(stackNode.right);
            }
        }
        
        //connect
        stack.clear();
        stack.push(root);
        
        while(!stack.isEmpty()) {
            stackNode = stack.pop();
            
            if(stackNode.left!=null) {
                map.get(stackNode).left = map.get(stackNode.left);
                stack.push(stackNode.left);
            }
            
            if(stackNode.right!=null) {
                map.get(stackNode).right = map.get(stackNode.right);
                stack.push(stackNode.right);
            }
            
            if(stackNode.random!=null) {
                map.get(stackNode).random = map.get(stackNode.random);
            }
        }
        
        return map.get(root);
    }
}
