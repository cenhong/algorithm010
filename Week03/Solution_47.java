package jk.wk3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 47. 全排列 II
 * https://leetcode-cn.com/problems/permutations-ii/
 * 
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。

示例:

输入: [1,1,2]
输出:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/permutations-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

个人见解，递归下表就行了
 * @author Lenovo
 *
 */
public class Solution_47 {
	 public List<List<Integer>> permuteUnique(int[] nums) {

		int len = nums.length;
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(len == 0)return res;
		
		//jdk 栈的实现
		Deque<Integer> path = new ArrayDeque<Integer>() ;
		boolean [] used = new boolean[len];
		dfs(nums,len,0,path,used,res);
		return res;
	 }

	/**
	 * 
	 * @param nums
	 * @param len
	 * @param depth 深度
 	 * @param path
	 * @param used
	 * @param res
	 */
	private void dfs(int[] nums, int len, int depth, Deque<Integer> path, boolean[] used, List<List<Integer>> res) {
		if(path.size() == len){
			res.add(new ArrayList<>(path));
			return;
		}
		
		for(int i =0 ; i < len ; i++){
			if(used[i]) continue;
			
			// 剪枝条件：i > 0 是为了保证 nums[i - 1] 有意义
            // 写 !used[i - 1] 是因为 nums[i - 1] 在深度优先遍历的过程中刚刚被撤销选择
			//需要研究研究一下愿意
			if(i>0 && nums[i] == nums[i-1] && !used[i-1]){
				continue;
			}
			
			path.addLast(nums[i]);
			used[i] = true;
			dfs(nums,len,depth+1,path,used,res);
			used[i] = false;
			path.removeLast();
		}
	}
}
