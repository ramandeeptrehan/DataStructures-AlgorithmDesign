package com.ramantrehan.tree;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TreeTest {
	Tree<Integer> tree;
	
	@BeforeEach
	public void setup() {
		this.tree = new Tree<Integer>();
	}
	
	@Test
	public void testHeightOfTree() {
		tree.addNode(2);
		
		assertNotNull(tree.getRoot());
		assertEquals(2, tree.getRoot().getValue());
		assertEquals(1, tree.getHeightOfTreeRecursive());
		assertEquals(1, tree.getHeightOfTreeDFS());
		assertEquals(1, tree.getHeightOfTreeBFS());

		
		tree.addNode(4);
		tree.addNode(1);
		assertEquals(2, tree.getHeightOfTreeRecursive());
		assertEquals(2, tree.getHeightOfTreeDFS());
		assertEquals(2, tree.getHeightOfTreeBFS());
		assertEquals(4, tree.getRoot().getLeftChild().getValue());
		assertEquals(1, tree.getRoot().getRightChild().getValue());
	
		tree.addNode(8);
		tree.addNode(2);
		tree.addNode(100);
		tree.addNode(-90);
		assertEquals(3, tree.getHeightOfTreeRecursive());
		assertEquals(3, tree.getHeightOfTreeDFS());
		assertEquals(3, tree.getHeightOfTreeBFS());
		
		tree.addNode(89);
		assertEquals(4, tree.getHeightOfTreeRecursive());
		assertEquals(4, tree.getHeightOfTreeDFS());
		assertEquals(4, tree.getHeightOfTreeBFS());
	}
}
