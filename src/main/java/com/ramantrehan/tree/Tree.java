package com.ramantrehan.tree;

import java.util.LinkedList;
import java.util.Queue;

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
	
	public int getHeightOfTree() {
		
		return heightOfTreeUtil(root);
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
