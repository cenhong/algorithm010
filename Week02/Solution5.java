package jk.wk2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * url : https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 * 给定一个二叉树，返回它的中序 遍历。左--根--右
 * 
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * @author Lenovo
 *
 */

public class Solution5 {
	
	//递归求解
	 public List<Integer> inorderTraversal(TreeNode root) {
		 List<Integer> l = new ArrayList<Integer>();
		 getv(root,l);
		 return l;
	 }

	private void getv(TreeNode root, List<Integer> l) {
		
		//左--根--右
		if(root != null){
			//1,左
			if(root.left!= null){
				getv(root.left,l);
			}
			l.add(root.val);
			if(root.right!= null){
				getv(root.right ,l);
			}
		}
	}
	
	//迭代算法
	public List<Integer> inorderTraversal2(TreeNode root) {
		 List<Integer> l = new ArrayList<Integer>();
		 Stack<TreeNode> stack = new Stack<TreeNode>();
		 
		 TreeNode curr = root;
		 while(curr != null || !stack.isEmpty()){
			 //左孩子都压栈
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