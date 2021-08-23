package cn.kobe;

public class Solution {
    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        //树为空
        if (pNode == null)
            return null;
        TreeLinkNode pNext = null;//当前节点的下一节点
        //如果当前节点有右子节点，下一节点为右子树的最左子节点
        if (pNode.right != null) {
            TreeLinkNode pRight = pNode.right;//当前节点的右子节点
            while (pRight.left != null)
                pRight = pRight.left;
            pNext = pRight;
        } else if (pNode.next != null) {
            TreeLinkNode pCur = pNode;//当前节点
            TreeLinkNode pParent = pNode.next;//当前节点的父节点
            //若当前节点是其父节点的右子节点,遍历，直到当前节点没有父节点，或者当前节点是其父节点的左子节点，则下一节点就是其父节点
            while (pParent != null && pCur == pParent.right) {
                pCur = pParent;
                pParent = pParent.next;
            }
            pNext = pParent;

        }
        return pNext;
    }
}
