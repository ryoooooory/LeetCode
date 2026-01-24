/*
・概要
solution2_1についてStackを使った繰り返し処理にしたもの。

・改善点
リネーム
Stackを使ったことで、処理をシンプルにした
独自クラスについてinitializerを改善し、冗長なコードを削除。

・補足
前もコメントいただいたが、JavaではStackについてDequeインターフェイスが推奨されている
https://docs.oracle.com/javase/jp/8/docs/api/java/util/Deque.html


*/

public class solution2_2 {
  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> allPermutations = new ArrayList<>();
    Deque<PermutationState> allPermutationStates = new ArrayDeque<>();
    allPermutationStates.push(new PermutationState(new ArrayList<>(), new HashSet<>()));

    while (!allPermutationStates.isEmpty()) {
      PermutationState permutationState = allPermutationStates.pop();
      if (permutationState.permutation.size() == nums.length) {
        allPermutations.add(permutationState.permutation);
        continue;
      }
      for (int num : nums) {
        if (permutationState.contained.contains(num)) {
          continue;
        }
        List<Integer> nextPermutation = new ArrayList<>(permutationState.permutation);
        Set<Integer> nextContained = new HashSet<>(permutationState.contained);
        nextPermutation.add(num);
        nextContained.add(num);
        PermutationState newState = new PermutationState(nextPermutation, nextContained);
        allPermutationStates.push(newState);
      }
    }
    return allPermutations;
  }

  class PermutationState {
    List<Integer> permutation;
    Set<Integer> contained;

    PermutationState(List<Integer> permutation, Set<Integer> contained) {
      this.permutation = permutation;
      this.contained = contained;
    }
  }
}
