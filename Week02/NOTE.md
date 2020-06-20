
学习笔记
1，感谢助教先生鼎力相助，终于跟总部git挂上了。

一、
package jk.wk2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * url : https://leetcode-cn.com/problems/valid-anagram/description/
 * 
 * 242. 有效的字母异位词 
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 
 * 输入: s = "anagram", t = "nagaram"
           输出: true

 * @author Lenovo
 *
 */
public class Solution1 {

	public boolean isAnagram(String s, String t) {
		if(s.length() != t.length())
			return false;
		Map<String,Integer> m_s = new HashMap<String,Integer>();
		Map<String,Integer> m_t = new HashMap<String,Integer>();
		tomap( s, m_s);
		tomap( t, m_t);
		if(m_s.size() != m_t.size())
			return false;
		for(String key : m_s.keySet()){
			if(!m_t.containsKey(key))
				return false;
			if(m_s.get(key).intValue() != m_t.get(key).intValue())
				return false;
		}
		return true;
    }
	
	public boolean isAnagramgf(String s, String t) {
		//高效代码
		if(s.length() != t.length())
			return false;
		char[] s_c = s.toCharArray();
		char[] s_t = t.toCharArray();
		Arrays.sort(s_c);
		Arrays.sort(s_t);
		return Arrays.equals(s_c, s_t);
		
	}
	
	public void tomap(String s,Map<String,Integer> m){
		char[] s_c = s.toCharArray();
		for(char c : s_c){
			String key = c+"";
			if(m.containsKey(key)){
				Integer i = m.get(key);
				m.put(key, i+1);
			}else{
				m.put(key, 1);
			}
			
		}
	}
	
	public static void main(String args[]){
		String s = "anagram" , t = "nagaram";
		
		System.out.println(new Solution1().isAnagram(s,t));
	}
}

二、
package jk.wk2;

import java.util.HashMap;
import java.util.Map;

/**
 * url : https://leetcode-cn.com/problems/two-sum/description/
 * 
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * 
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 
 * @author Lenovo
 *
 */
public class Solution2 {

	
	public int[] twoSum(int[] nums, int target) {
		 int index1 =0;
	        int index2 =0;
	        boolean find = false;
	        for(index1 =0 ; index1< nums.length ; index1++){
	        	 int num2 = target - nums[index1];
	        	 for(int j = 0 ; j<nums.length ; j++){
	             	if(j != index1 && nums[j] == num2){
	             		index2 = j;
	             		find = true;
	             		break;
	             	}
	             }
	        	 if(find) break;
	        }
	       if(find)
	    	   return new int[]{index1,index2};
	       return null;
    }
	
	public int[] twoSum2(int[] nums, int target) {
		 Map<Integer,Integer> m = new HashMap<Integer,Integer>();
		 
		 for(int i =0 ; i < nums.length ; i++){
			 m.put(nums[i], i);
		 }
		 
		 for(int i =0 ; i < nums.length ; i++){
			 int num2 = target - nums[i];
			 if(m.containsKey(num2) && m.get(num2) != i){
				  return new int[]{i, m.get(num2)};
			 }
		 }
		 return null;
   }
	
	public int[] twoSum3(int[] nums, int target) {
		 Map<Integer,Integer> m = new HashMap<Integer,Integer>();
		 
		 for(int i =0 ; i < nums.length ; i++){
			 int num2 = target - nums[i];
			 if(m.containsKey(num2)){
				  return new int[]{i, m.get(num2)};
			 }
			 m.put(nums[i], i);
		 }
		 return null;
  }
}

三、
package jk.wk2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * url : https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/
 * 
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 * 
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
 * 
 * @author Lenovo
 *
 */
public class Solution3 {
	//解法1 递归
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
	
	//解法2 用stack . 先序遍历  跟左右
	public List<Integer> preorder2(Node root) {
		List<Integer> l = new ArrayList<Integer>(); //存放结果
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

四、
package jk.wk2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * url : https://leetcode-cn.com/problems/group-anagrams/
 * 
 * 49. 字母异位词分组
 * 
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
 * 
 * @author Lenovo
 *
 */
public class Solution4 {
	public List<List<String>> groupAnagrams(String[] strs) {

        Map<String,List<String>> m = new HashMap<String,List<String>>();
        for(String s : strs){
        	char[]c = s.toCharArray();
        	Arrays.sort(c);
        	String key = String.valueOf(c);
        	
        	if(!m.containsKey(key)) m.put(key, new ArrayList<String>());
        	
        	m.get(key).add(s);
        	
        }
        
       return new ArrayList<>(m.values());
    }
}

五、
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
六、
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

七、
package jk.wk2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * url : https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 * 429. N叉树的层序遍历
 * 
 * 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
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
	 * leedcode 解法
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


