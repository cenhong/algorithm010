package jk.wk4;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/assign-cookies/description/
 * 
 * 455. �ַ�����
 * ��������һλ�ܰ��ļҳ�����Ҫ����ĺ�����һЩС���ɡ����ǣ�ÿ���������ֻ�ܸ�һ����ɡ���ÿ������ i ������һ��θ��ֵ gi ���������ú���������θ�ڵı��ɵ���С�ߴ磻����ÿ����� j ������һ���ߴ� sj ����� sj >= gi �����ǿ��Խ�������� j ��������� i ��������ӻ�õ����㡣���Ŀ���Ǿ���������Խ�������ĺ��ӣ��������������ֵ��

ע�⣺

����Լ���θ��ֵΪ����
һ��С�������ֻ��ӵ��һ����ɡ�

ʾ�� 1:

����: [1,2,3], [1,1]

���: 1

����: 
�����������Ӻ�����С���ɣ�3�����ӵ�θ��ֵ�ֱ��ǣ�1,2,3��
��Ȼ��������С���ɣ��������ǵĳߴ綼��1����ֻ����θ��ֵ��1�ĺ������㡣
������Ӧ�����1��

��Դ�����ۣ�LeetCode��
���ӣ�https://leetcode-cn.com/problems/assign-cookies
����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @author Lenovo
 *
 */
public class Solution455 {
	/**
	 * 
	 * @param g С���б�
	 * @param s �����б�
	 * @return
	 */
	public int findContentChildren(int[] g, int[] s) {
      int  gi =0 , si =0;
      Arrays.sort(g);
      Arrays.sort(s);
      while(g.length>si && s.length >si){
    	  if(g[si]<s[gi]){
    		  gi++;
    	  }
    	  
    	  si ++;
      }
      return gi;
    }
}
