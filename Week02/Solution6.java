package jk.wk2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * url : https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 * ��������ǰ���������--��--��
 * 
 * ����: �ݹ��㷨�ܼ򵥣������ͨ�������㷨�����
 * @author Lenovo
 *
 */
public class Solution6 {

	//�ⷨһ �ݹ�
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
	
	//�ⷨ���� ����
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
