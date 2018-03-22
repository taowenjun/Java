package cn.bit.tao.binarysearchtreeiterator;

import java.util.Stack;

/** 
 * @author Tao wenjun
 * 二叉搜索树迭代器
 */

public class BSTIterator {
	private Stack<TreeNode> stack = new Stack<TreeNode>();
	
	public BSTIterator(TreeNode root){
		if(root!=null){
			pushLeft(root);
		}
	}
	
	/**
	 * 判断是否还有下一个节点
	 * @return
	 */
	public boolean hasNext(){
		return !stack.isEmpty();
	}
	
	/**
	 * 获取下一个节点
	 * @return
	 */
	public int next(){
		TreeNode top = stack.peek();
		stack.pop();
		if(top.right!=null){
			pushLeft(top.right);
		}
		return top.val;
	}
	
	/**
	 * 将节点的左子节点及其后代的左子节点放进栈中
	 * @param root
	 */
	private void pushLeft(TreeNode root){
		TreeNode temp = root;
		while(temp!=null){
			stack.push(temp);
			temp=temp.left;
		}
	}
}

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){
		val = x;
	}
}
