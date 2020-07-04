package jk.wk3;

/**
 * 236. 二叉树的最近公共祖先
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”

                    来源：力扣（LeetCode）
                     链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree
                    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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
		//1，设置递归终结条件
		if(root == null ){
			return false;
		}
		
		//2,需要递归的逻辑
		boolean ltree = dfs(root.left,p,q);
		boolean rtree = dfs(root.right,p,q);
		
		//3,当找到公共祖先 赋值
		if((ltree&& rtree) || ((root.val == p.val || root.val == q.val) && (ltree || rtree))){
			ans = root;
		}
		
		//4,返回递归的结果。 这里咱们是找左根右，只要能找到就返回true
		return ltree || rtree || root.val == p.val || root.val == q.val ;
	} 
}
