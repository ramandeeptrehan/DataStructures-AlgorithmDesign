package com.ramantrehan.tree;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class StackPair<T> {
	private TreeNode<T> treeNode;
	private int level;
	
	public StackPair(TreeNode<T> treeNode, int level) {
		this.treeNode = treeNode;
		this.level = level;
	}
}
