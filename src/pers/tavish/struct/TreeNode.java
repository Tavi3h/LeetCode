package pers.tavish.struct;

public class TreeNode {
    public int val;
    public TreeNode left, right;

    public TreeNode(int x) {
        val = x;
    }
    
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private static TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        int rootVal = preorder[preStart], rootIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                rootIndex = i;
                break;
            }
        }
        int len = rootIndex - inStart;
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(preorder, preStart + 1, preStart + len, inorder, inStart, rootIndex - 1);
        root.right = buildTree(preorder, preStart + len + 1, preEnd, inorder, rootIndex + 1, inEnd);
        return root;
    }
}
