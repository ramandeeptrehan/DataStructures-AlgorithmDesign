package com.ramantrehan.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Tree<T> {
	private TreeNode<T> root;
	
	public Tree() {
		this.root = null;
	}
	
	public int getHeightOfTreeRecursive() {
		
		return heightOfTreeUtil(root);
	}
	
	public int getHeightOfTreeDFS() {
		Stack<StackPair<T>> stack = new Stack<>();
		
		int maxHeight = 0;
		if(root == null) {
			return maxHeight;
		}
		
		stack.push(new StackPair<T>(root, 1));
		
		StackPair<T> stackPair = null;
		TreeNode<T> treeNode = null;
		int level = 0;
		while(!stack.isEmpty()) {
			stackPair = stack.pop();
			treeNode = stackPair.getTreeNode();
			level = stackPair.getLevel();
			
			maxHeight = Math.max(maxHeight, level);
			
			if(treeNode.getLeftChild()!=null) {
				stack.push(new StackPair<T>(treeNode.getLeftChild(), level+1));
			}
			
			if(treeNode.getRightChild()!=null) {
				stack.push(new StackPair<T>(treeNode.getRightChild(), level+1));
			}
		}
		
		return maxHeight;
	}

	public int getHeightOfTreeBFS() {
		Queue<TreeNode<T>> queue = new LinkedList<>();
		int depth = 0;

		if(root == null) {
			return depth;
		}
		
		queue.add(root);
		int size = 0;
		
		TreeNode<T> queuedNode = null;
		while(!queue.isEmpty()) {
			
			size = queue.size();
			
			for(int i = 0; i<size; i++) {
				queuedNode = queue.remove();
				
				if(queuedNode.getLeftChild()!=null) {
					queue.add(queuedNode.getLeftChild());
				}
				
				if(queuedNode.getRightChild()!=null) {
					queue.add(queuedNode.getRightChild());
				}
			}
			
			depth++;
		}
		
		return depth;
	}
	
	private int heightOfTreeUtil(TreeNode<T> node) {
		
		if(node == null) {
			return 0;
		}
		
		return 1 + Math.max(heightOfTreeUtil(node.getLeftChild()), heightOfTreeUtil(node.getRightChild()));
	}

	public void addNode(T value) {
		
		//base case
		if(root == null) {
			root = new TreeNode<T>(value);
			return;
		}
		
		//do level order traversal and insert wherever applicable
		Queue<TreeNode<T>> queue = new LinkedList<>();
		queue.add(root);
		
		TreeNode<T> node = null;
		
		while(!queue.isEmpty()) {
			node = queue.remove();
			
			if(node.getLeftChild() == null) {
				TreeNode<T> newNode = new TreeNode<T>(value);
				node.setLeftChild(newNode); 
				break;
			} else {
				queue.add(node.getLeftChild());
			}
			
			if(node.getRightChild() == null) {
				TreeNode<T> newNode = new TreeNode<T>(value);
				node.setRightChild(newNode);
				break;
			} else {
				queue.add(node.getRightChild());
			}
		}
	}
}
