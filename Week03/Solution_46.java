package jk.wk3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 46. 全排列
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * @author Lenovo
 *
 */
public class Solution_46 {

	public List<List<Integer>> permute(int[] nums) {
		int len = nums.length;
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(len == 0)return res;
		
		//声明栈
		Deque<Integer> path = new ArrayDeque<>();
		boolean [] used = new boolean[len];
		dfs(nums,len,0,path,used,res);
		return res;
    }
	
	public void dfs(int [] nums ,int len ,int depth,Deque<Integer> path,boolean [] used,List<List<Integer>> res){
		//1,递归终结条件
		if(path.size() == len){
			res.add(new ArrayList(path));
			return;
		}
		
		//2，递归过程，构成nums.length 每一位数 都有
		//2.1  拿第一层举例，第一位数可以是第一个数，可以是第2个数，可以是N。 
		//2.2  那么nums里面每一个数，都可以第一个开头。
		//2.3  因为是递归，所以先选中1，递归以1开始的排列组合。 
		//2.4 1开始的排列组合结束。 递归以2开始的排列组合，就需要把首字母清除。
		for(int i =0 ; i< len ; i++){
			if(used[i])continue;
			path.addLast(nums[i]);
			used[i] = true;
			dfs(nums,len,depth+1,path,used,res);
			path.removeLast();
			used[i] = false;
		}
	}
}
