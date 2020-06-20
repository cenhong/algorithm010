package jk.wk2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * url : https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 * 429. N�����Ĳ������
 * 
 * ����һ�� N ������������ڵ�ֵ�Ĳ�������� (�������ң�������)��
 * @author Lenovo
 *
 */
public class Solution7 {

	public List<List<Integer>> levelOrder(Node root) {
		List<List<Integer>> l = new ArrayList<List<Integer>>();
		if(root == null)return l;
		Queue<Node> queue_cur = new LinkedList<>();
		queue_cur.add(root);
		Queue<Node> queue_cs = new LinkedList<>();
		while(!queue_cur.isEmpty()){
			List<Integer> sub = new ArrayList<Integer>();
			queue_cs = new LinkedList<>();
			for(Node cur : queue_cur){
				if(cur != null){
					sub.add(cur.val);
					if(cur.children !=null ){
						queue_cs.addAll(cur.children);
					}
				}
				
			}
			queue_cur = queue_cs;
			l.add(sub);
			
		}
		
		return l;
    }
	
	/**
	 * leedcode �ⷨ
	 * @param root
	 * @return
	 */
	public List<List<Integer>> levelOrder2(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node curr = queue.poll();
                level.add(curr.val);
                List<Node> children = curr.children;
                for (Node child : children) {
                    if (child != null) {
                        queue.add(child);
                    }
                }
            }
            result.add(level);
        }

        return result;
    }
	
}

