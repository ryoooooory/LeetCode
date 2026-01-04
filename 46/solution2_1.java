/*
・概要
他の人の解法を参考にしたもの
https://github.com/Satorien/LeetCode/pull/49/files
再帰を使わずに繰り返し処理で行ったもの。オプションとして良さそう

https://github.com/shintaro1993/arai60/pull/54/files
計算量の考え方は一緒そう。リンク先の方ではSetを使ってない分再帰のループ内での処理がn^2かかっている違いはある。
こちらでも繰り返し処理をしている。
https://github.com/Ryotaro25/leetcode_first60/pull/54/files#r1986035628
ここで似たような話があった。

https://github.com/akmhmgc/arai60/pull/44/files#r2404282404
ここら辺でもあるが、再帰使ったほうが配列のコピーを都度作らなくていいので多少効率良さそう

特に今回の問題は順番は関係ないのでStackでなく普通のListで実装してみる。
実装してみたら、思ったよりコピーなどの処理で煩雑になるので、やはりstack使ったほうが結構楽になるなとおもったのでsolution2_2で改めて実装




*/

public class solution2_1 {
  public List<List<Integer>> permute(int[] nums) {
    List<PermutaionData> allPermutationsData = new ArrayList<>();
    allPermutationsData.add(new PermutaionData());
    int length = 0;
    while (length < nums.length) {
      List<PermutaionData> subData = new ArrayList<>();
      for (PermutaionData permutationData : allPermutationsData) {
        for (int num : nums) {
          List<Integer> copy = new ArrayList<>(permutationData.permutation);
          Set<Integer> copyContained = new HashSet<>(permutationData.contained);
          if (copyContained.contains(num)) {
            continue;
          }
          copy.add(num);
          copyContained.add(num);
          PermutaionData newData = new PermutaionData();
          newData.permutation = copy;
          newData.contained = copyContained;
          subData.add(newData);
          continue;
        }
      }
      allPermutationsData = subData;
      length++;
    }
    List<List<Integer>> allPermutations = new ArrayList<>();
    for (PermutaionData permutationData : allPermutationsData) {
      allPermutations.add(permutationData.permutation);
    }
    return allPermutations;
  }

  class PermutaionData {
    List<Integer> permutation;
    Set<Integer> contained;

    PermutaionData() {
      permutation = new ArrayList<>();
      contained = new HashSet<>();
    }
  }
}
