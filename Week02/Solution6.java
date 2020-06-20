package jk.wk2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * url : https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 * 二叉树的前序遍历。根--左--右
 * 
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * @author Lenovo
 *
 */
public class Solution6 {

	//解法一 递归
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> l = new ArrayList<Integer>();
		getv(root,l);
		return l;
    }

	private void getv(TreeNode root, List<Integer> l) {
		if(root != null){
			l.add(root.val);
			if(root.left != null)
				getv(root.left,l);
			if(root.right != null)
				getv(root.right,l);
		}
	}
	
	//解法二、 迭代
	public List<Integer> preorderTraversal2(TreeNode root) {
		List<Integer> l = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>(); 
		
		if(root != null)
			stack.push(root);
		TreeNode curr;
		while(!stack.isEmpty()){
			curr = stack.pop();
			l.add(curr.val);
			
			if(curr.right!=null){
				stack.push(curr.right);
			}
			
			if(curr.left!= null){
				stack.push(curr.left);
			}
			
		}
		
		return l;
	}
}
