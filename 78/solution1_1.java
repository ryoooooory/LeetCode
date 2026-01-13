/*
・概要
自力解法しようとしたが、重複不可の部分がわからず、10分考えてわからなかったのでLeetCodeの回答見た。
最初のイメージだと再帰しながら、Listに要素をつっこんでいくイメージだったが、上記にある通りこれだと最終的にソートとかして同一判定をする必要がでてくるなと思い、そこから別の案が思いつかなかった。

・解き方
単純に、numsについて１つずつ見ていく方法で、現在あるすべてのSubsetについてコピーしてその配列に要素を追加し、最終的にSubsetsに加えると言う方法。


*/

public class solution1_1 {
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> allSubsets = new ArrayList<>();
    allSubsets.add(new ArrayList<>());
    for (int num : nums) {
      List<List<Integer>> tempSubsets = new ArrayList<>();
      for (List<Integer> subset : allSubsets) {
        List<Integer> tempSubset = new ArrayList<Integer>(subset);
        tempSubset.add(num);
        tempSubsets.add(tempSubset);
      }
      allSubsets.addAll(tempSubsets);
    }
    return allSubsets;
  }
}
