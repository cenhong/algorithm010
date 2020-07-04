package jk.wk3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 46. ȫ����
 * ����һ�� û���ظ� ���ֵ����У����������п��ܵ�ȫ���С�
 * @author Lenovo
 *
 */
public class Solution_46 {

	public List<List<Integer>> permute(int[] nums) {
		int len = nums.length;
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(len == 0)return res;
		
		//����ջ
		Deque<Integer> path = new ArrayDeque<>();
		boolean [] used = new boolean[len];
		dfs(nums,len,0,path,used,res);
		return res;
    }
	
	public void dfs(int [] nums ,int len ,int depth,Deque<Integer> path,boolean [] used,List<List<Integer>> res){
		//1,�ݹ��ս�����
		if(path.size() == len){
			res.add(new ArrayList(path));
			return;
		}
		
		//2���ݹ���̣�����nums.length ÿһλ�� ����
		//2.1  �õ�һ���������һλ�������ǵ�һ�����������ǵ�2������������N�� 
		//2.2  ��ônums����ÿһ�����������Ե�һ����ͷ��
		//2.3  ��Ϊ�ǵݹ飬������ѡ��1���ݹ���1��ʼ��������ϡ� 
		//2.4 1��ʼ��������Ͻ����� �ݹ���2��ʼ��������ϣ�����Ҫ������ĸ�����
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
