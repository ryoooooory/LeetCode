/*
・概要
自力解法。
テストケースの洗い出しが足りず、そもそも求められているものと違うことに気づくが、解法がわからずACできず。
15分くらい

*/

import javax.swing.tree.TreeNode;

public class solution1_1 {
  public TreeNode[] splitBST(TreeNode root, int target) {
    if (root.val == target) {
      return new TreeNode[] {root, null};
    }
    return new TreeNode[] {getTargetTreeAndChangeSubTree(root, target), root};
  }

  private TreeNode getTargetTreeAndChangeSubTree(TreeNode current, int target) {
    if (current == null) {
      return null;
    }
    if (target < current.val) {
      if (current.left == null) {
        return null;
      }
      if (current.left.val == target) {
        TreeNode subTree = current.left;
        current.left = current.left.right;
        subTree.right = null;
        return subTree;
      } else {
        return getTargetTreeAndChangeSubTree(current.left, target);
      }
    } else {
      if (current.right == null) {
        return null;
      }
      if (current.right.val == target) {
        TreeNode subTree = current.right;

        current.right = current.right.left;
        subTree.left = null;
        return subTree;
      } else {
        return getTargetTreeAndChangeSubTree(current.right, target);
      }
    }
  }
}
