package jk.wk2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * url : https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/
 * 
 * ����һ�� N ������������ڵ�ֵ��ǰ�������
 * 
 * ˵��: �ݹ鷨�ܼ򵥣������ʹ�õ�������ɴ�����?
 * 
 * @author Lenovo
 *
 */
public class Solution3 {
	//�ⷨ1 �ݹ�
	public List<Integer> preorder(Node root) {
        List<Integer> l = new ArrayList<Integer>();
	     getvs(l,root);
	     return l;
    }
	private void getvs(List<Integer> l, Node root) {
		if(root == null)return;
		l.add(root.val);
		if(root.children == null)return;
		
		for(Node c : root.children){
			getvs(l, c);
		}
	}
	
	//�ⷨ2 ��stack . �������  ������
	public List<Integer> preorder2(Node root) {
		List<Integer> l = new ArrayList<Integer>(); //��Ž��
		Stack<Node> stack = new Stack<Node>();
		
		stack.push(root);
		while(!stack.isEmpty()){
			Node node = stack.pop();
			if(node != null)
				l.add(node.val);
			if(node != null && node.children!=null){
				Collections.reverse(node.children);
				for(Node item : node.children){
					stack.push(item);
				}
			}
		}
		
		return l;
	}
	
}

//Definition for a Node.
class Node {
 public int val;
 public List<Node> children;

 public Node() {}

 public Node(int _val) {
     val = _val;
 }

 public Node(int _val, List<Node> _children) {
     val = _val;
     children = _children;
 }
};
