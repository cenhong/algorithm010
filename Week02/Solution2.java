package jk.wk2;

import java.util.HashMap;
import java.util.Map;

/**
 * url : https://leetcode-cn.com/problems/two-sum/description/
 * 
 * ����һ���������� nums ��һ��Ŀ��ֵ target�������ڸ��������ҳ���ΪĿ��ֵ���� ���� ���������������ǵ������±ꡣ
 * 
 * ����Լ���ÿ������ֻ���Ӧһ���𰸡����ǣ�������ͬһ��Ԫ�ز���ʹ�����顣
 * 
 * ���� nums = [2, 7, 11, 15], target = 9
 * ��Ϊ nums[0] + nums[1] = 2 + 7 = 9
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
