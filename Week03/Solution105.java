package jk.wk3;

import java.util.HashMap;
import java.util.Map;

public class Solution105 {
	 public TreeNode buildTree(int[] preorder, int[] inorder) {
		 int len_pre = preorder.length;
		 int len_ind = inorder.length;
		 if(len_pre != len_ind){
			 throw new RuntimeException(" data unvalid");
		 }
		 
		 Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		 for(int i  =0 ; i <len_ind ; i++){
			 map.put(inorder[i],i );
		 }
		 
		 return buildTree(preorder,0,len_pre-1,map,0,len_ind-1);
	 }

	private TreeNode buildTree(int[] preorder, int pre_left, int pre_right,
			Map<Integer, Integer> map, int in_left, int in_right) {
		if( pre_left > pre_right || in_left > in_right ){
			return null;
		}
		//先序遍历区间的第一个元素是 根节点
		int pivot = preorder[pre_left];
		TreeNode root = new TreeNode(pivot);
		
		int pivot_index = map.get(pivot);
		
		root.left = buildTree(preorder,pre_left+1,pivot_index-in_left+pre_left,
				map,in_left,pivot_index-1);
		root.right = buildTree(preorder,pivot_index-in_left+pre_left+1,pre_right,
				map,pivot_index+1,in_right);
		
		return root;
	}
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
	TreeNode(int x) { val = x; }
 }
