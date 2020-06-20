package jk.wk2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * url : https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 * ����һ���������������������� ��������--��--��
 * 
 * ����: �ݹ��㷨�ܼ򵥣������ͨ�������㷨�����
 * @author Lenovo
 *
 */

public class Solution5 {
	
	//�ݹ����
	 public List<Integer> inorderTraversal(TreeNode root) {
		 List<Integer> l = new ArrayList<Integer>();
		 getv(root,l);
		 return l;
	 }

	private void getv(TreeNode root, List<Integer> l) {
		
		//��--��--��
		if(root != null){
			//1,��
			if(root.left!= null){
				getv(root.left,l);
			}
			l.add(root.val);
			if(root.right!= null){
				getv(root.right ,l);
			}
		}
	}
	
	//�����㷨
	public List<Integer> inorderTraversal2(TreeNode root) {
		 List<Integer> l = new ArrayList<Integer>();
		 Stack<TreeNode> stack = new Stack<TreeNode>();
		 
		 TreeNode curr = root;
		 while(curr != null || !stack.isEmpty()){
			 //���Ӷ�ѹջ
			 while(curr!= null){
				 stack.push(curr);
				 curr = curr.left;
			 }
			 curr = stack.pop();
			 l.add(curr.val);
			 curr = curr.right;
			 
		 }
		  
		 return l;
	 }

	
}


 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}