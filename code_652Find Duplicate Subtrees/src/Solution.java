import java.util.*;

/**
 * 作用：
 * 2020/10/16
 */
public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    //需要将树序列化一下，以便判断是都是相同结构
    Set<String> hashset = new HashSet<>();//会出现重复，即现在我们需要判断他出现了几次
    HashMap<String, Integer> map = new HashMap<>();
    Set<TreeNode> res = new HashSet<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        if (root == null) {
            return null;
        }
        dfs(root);
        return new ArrayList<>(res);
    }

    public String dfs(TreeNode root) {
        if (root != null) {
            String left = dfs(root.left);
            String right = dfs(root.right);
            //后序，
            String sb = left + "," + right + "," + root.val;
            int num = map.getOrDefault(sb, 0);
            if (num == 1)
                res.add(root);
            map.put(sb, num + 1);
            return sb;
        } else {
            return "#";
        }
    }
}
