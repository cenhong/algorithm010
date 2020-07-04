package jk.wk4;

/**
 * https://leetcode-cn.com/problems/lemonade-change/
 * 
 * 860. ����ˮ����
������ˮ̯�ϣ�ÿһ������ˮ���ۼ�Ϊ 5 ��Ԫ��

�˿��Ŷӹ�����Ĳ�Ʒ�������˵� bills ֧����˳��һ�ι���һ����

ÿλ�˿�ֻ��һ������ˮ��Ȼ�����㸶 5 ��Ԫ��10 ��Ԫ�� 20 ��Ԫ��������ÿ���˿���ȷ���㣬Ҳ����˵��������ÿλ�˿�����֧�� 5 ��Ԫ��

ע�⣬һ��ʼ����ͷû���κ���Ǯ��

������ܸ�ÿλ�˿���ȷ���㣬���� true �����򷵻� false ��

ʾ�� 1��

���룺[5,5,5,10,20]
�����true
���ͣ�
ǰ 3 λ�˿�������ǰ�˳����ȡ 3 �� 5 ��Ԫ�ĳ�Ʊ��
�� 4 λ�˿����������ȡһ�� 10 ��Ԫ�ĳ�Ʊ�������� 5 ��Ԫ��
�� 5 λ�˿���������һ�һ�� 10 ��Ԫ�ĳ�Ʊ��һ�� 5 ��Ԫ�ĳ�Ʊ��
�������пͻ����õ�����ȷ�����㣬����������� true��

ʾ�� 2��

���룺[5,5,10]
�����true

ʾ�� 3��

���룺[10,10]
�����false

��Դ�����ۣ�LeetCode��
���ӣ�https://leetcode-cn.com/problems/lemonade-change
����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * 
 * @author Lenovo
 *
 */
public class Solution_860 {
	/**
	 * ̰���㷨 
	 * ֻ���ǵ�ǰ�����Ž�
	 * @param bills
	 * @return
	 */
	public boolean lemonadeChange(int[] bills) {

		int bill_5=0,bill_10=0;
		for(int bill : bills){
			switch (bill) {
			case 5 : bill_5++; break;
			case 10: bill_5--; bill_10++; break;
			case 20: {
				if(bill_10>0){
					bill_5--;
					bill_10--;
				}else{
					bill_5-=3;
				}
				break;
			 }
		   }
			
			if(bill_5<0 ){
				return false;
			}
		}
		return true;
    }
}
