package jk.wk2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * url : https://leetcode-cn.com/problems/valid-anagram/description/
 * 
 * 242. ��Ч����ĸ��λ�� 
 * ���������ַ��� s �� t ����дһ���������ж� t �Ƿ��� s ����ĸ��λ�ʡ�
 * 
 * ����: s = "anagram", t = "nagaram"
           ���: true

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
		//��Ч����
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
