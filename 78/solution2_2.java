/*
・概要
solution2_1と同じく、各要素についていれるいれないで繰り返しながらindexを増やしていくもの。Stackで実装してみた。


・所感
繰り返しだとやはり再帰の深さを気にしなくていいのはいい利点だな〜とおもいつつ、繰り返しで渡すものが１つでないと構造体をつくったり少し面倒なので、可読性や書きやすさは再帰だなと再認識した。

*/

public class solution2_2 {
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> allSubset = new ArrayList<>();
    Deque<SubsetAndIndex> stack = new ArrayDeque<>(); // さすがに変数名stackはそのまますぎるかな
    stack.push(new SubsetAndIndex(new ArrayList<>(), 0));
    while (!stack.isEmpty()) { // 他の人のPRのコメントでfor文でもいいというコメントあった。たしかにそれはそう。
      SubsetAndIndex current = stack.pop();
      if (current.index == nums.length) {
        allSubset.add(current.subset);
        continue;
      }

      List<Integer> subsetWithNum = new ArrayList<>(current.subset);
      subsetWithNum.add(nums[current.index]);
      stack.push(new SubsetAndIndex(subsetWithNum, current.index + 1));
      stack.push(new SubsetAndIndex(new ArrayList<>(current.subset), current.index + 1));
    }
    return allSubset;
  }

  class SubsetAndIndex {
    List<Integer> subset;
    int index;

    SubsetAndIndex(List<Integer> subset, int index) {
      this.subset = subset;
      this.index = index;
    }
  }
}
