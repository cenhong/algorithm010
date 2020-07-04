package jk.wk3;

/**
 * 236. �������������������
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * ����һ��������, �ҵ�����������ָ���ڵ������������ȡ�
 * ������������ȵĶ���Ϊ���������и��� T ��������� p��q������������ȱ�ʾΪһ����� x������ x �� p��q �������� x ����Ⱦ����ܴ�һ���ڵ�Ҳ���������Լ������ȣ�����

                    ��Դ�����ۣ�LeetCode��
                     ���ӣ�https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree
                    ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @author Lenovo
 *
 */
public class Solution_236 {

	TreeNode ans = null;
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root,p,q);
        return ans;
    }
	
	public boolean dfs(TreeNode root, TreeNode p, TreeNode q){
		//1�����õݹ��ս�����
		if(root == null ){
			return false;
		}
		
		//2,��Ҫ�ݹ���߼�
		boolean ltree = dfs(root.left,p,q);
		boolean rtree = dfs(root.right,p,q);
		
		//3,���ҵ��������� ��ֵ
		if((ltree&& rtree) || ((root.val == p.val || root.val == q.val) && (ltree || rtree))){
			ans = root;
		}
		
		//4,���صݹ�Ľ���� ����������������ң�ֻҪ���ҵ��ͷ���true
		return ltree || rtree || root.val == p.val || root.val == q.val ;
	} 
}
