/**
 * 自力解法。10分くらいでAC 時間計算量：O(n), 空間計算量O(n) nが10^4くらいで、再帰の深さは平衡木であることを考慮して最大でもlognなので13くらいなので問題なし。
 * 考え方としては、配列はソート済みで二部探索木の定義であるleft < root <
 * rightである点を考え、配列についてある範囲での中心Indexを根として再起的にそのIndexから左の範囲と、右の範囲で同じことをしていく。
 */
public class solution1_1 {
  public TreeNode sortedArrayToBST(int[] nums) {
    return sortedArrayToBSTHelper(nums, 0, nums.length - 1);
  }

  private TreeNode sortedArrayToBSTHelper(int[] nums, int startIndex, int endIndex) {
    if (endIndex < startIndex) {
      return null;
    }
    int centerIndex = (startIndex + endIndex) / 2;
    TreeNode rootNode = new TreeNode(nums[centerIndex]);
    rootNode.left = sortedArrayToBSTHelper(nums, startIndex, centerIndex - 1);
    rootNode.right = sortedArrayToBSTHelper(nums, centerIndex + 1, endIndex);
    return rootNode;
  }
}
