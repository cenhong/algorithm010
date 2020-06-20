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
