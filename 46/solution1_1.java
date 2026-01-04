/*
・概要
自力解法。Listの操作メソッドを間違えて２回エラーになったが、10分ほどでAC

・解法
再帰処理として、現在までに追加されてない要素を現在のpermutationに追加して、次の階層に渡していくもの。

あとからLeetCodeの回答もみたがBacktrackingについては、ほぼこちらの解法と一緒。

・計算量
時間：わからなかった。並べ替えについて考えるとn!で、再帰の中でのループがnなのでO(n*n!) ?
空間：返却するListのサイズについて時間でみつもったn^nと一緒になる？再帰の深さはnなのでスタックはn

・その他
permutationを最後にallの方に追加する時に、Javaでは参照渡しではないが、オブジェクトが引数のときは参照の値が渡されるので、実質変更を加えるとそれが反映されてしまうのでコピーを作る必要があることに気づけたのはよかった。
コピーについては
List<Integer> copy = new ArrayList<Integer>(permutation);
とかaddAllとかで簡単にできる。

*/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class solution1_1 {
  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> allPermutations = new ArrayList<>();
    makeAllPermutation(nums, allPermutations, new ArrayList<>(), new HashSet<>());
    return allPermutations;
  }

  private void makeAllPermutation(
      int[] nums,
      List<List<Integer>> allPermutasions,
      List<Integer> permutation,
      Set<Integer> seen) {
    if (permutation.size() == nums.length) {
      // これは　List<Integer> copy = new ArrayList<Integer>(permutation);　で代用できる。
      List<Integer> copy = new ArrayList<Integer>();
      for (int num : permutation) {
        copy.add(num);
      }
      allPermutasions.add(copy);
      return;
    }
    for (int num : nums) {
      if (seen.contains(num)) {
        continue;
      }
      permutation.add(num);
      seen.add(num);
      makeAllPermutation(nums, allPermutasions, permutation, seen);
      permutation.remove(permutation.size() - 1);
      seen.remove(num);
    }
  }
}
