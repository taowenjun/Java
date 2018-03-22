package cn.bit.tao.binarysearchtreeiterator;

import java.util.Stack;

/** 
 * @author Tao wenjun
 * ����������������
 */

public class BSTIterator {
	private Stack<TreeNode> stack = new Stack<TreeNode>();
	
	public BSTIterator(TreeNode root){
		if(root!=null){
			pushLeft(root);
		}
	}
	
	/**
	 * �ж��Ƿ�����һ���ڵ�
	 * @return
	 */
	public boolean hasNext(){
		return !stack.isEmpty();
	}
	
	/**
	 * ��ȡ��һ���ڵ�
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
	 * ���ڵ�����ӽڵ㼰���������ӽڵ�Ž�ջ��
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
