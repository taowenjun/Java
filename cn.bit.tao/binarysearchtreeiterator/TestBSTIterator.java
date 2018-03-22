package cn.bit.tao.binarysearchtreeiterator;

import org.junit.Test;

public class TestBSTIterator {
	@Test
	public void test(){
		TreeNode root = new TreeNode(4);
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(3);
		TreeNode node3 = new TreeNode(5);
		root.left=node1;
		node1.right=node2;
		root.right=node3;
		
		BSTIterator ite = new BSTIterator(root);
		while(ite.hasNext()){
			System.out.print(ite.next()+ " "); 
		}
		//2 3 4 5 
	}
}
