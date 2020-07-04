package jk.wk3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 47. ȫ���� II
 * https://leetcode-cn.com/problems/permutations-ii/
 * 
 * ����һ���ɰ����ظ����ֵ����У��������в��ظ���ȫ���С�

ʾ��:

����: [1,1,2]
���:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]

��Դ�����ۣ�LeetCode��
���ӣ�https://leetcode-cn.com/problems/permutations-ii
����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������

���˼��⣬�ݹ��±������
 * @author Lenovo
 *
 */
public class Solution_47 {
	 public List<List<Integer>> permuteUnique(int[] nums) {

		int len = nums.length;
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(len == 0)return res;
		
		//jdk ջ��ʵ��
		Deque<Integer> path = new ArrayDeque<Integer>() ;
		boolean [] used = new boolean[len];
		dfs(nums,len,0,path,used,res);
		return res;
	 }

	/**
	 * 
	 * @param nums
	 * @param len
	 * @param depth ���
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
			
			// ��֦������i > 0 ��Ϊ�˱�֤ nums[i - 1] ������
            // д !used[i - 1] ����Ϊ nums[i - 1] ��������ȱ����Ĺ����иոձ�����ѡ��
			//��Ҫ�о��о�һ��Ը��
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
