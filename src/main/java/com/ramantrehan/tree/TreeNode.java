package com.ramantrehan.tree;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TreeNode<T> {
	private T value;
	private TreeNode<T> leftChild;
	private TreeNode<T> rightChild;
	
	public TreeNode(T value) {
		this.value = value;
	}
}
