/*
・概要
自力解法。25分ほどでAC

・計算量
時間：O(nlogn)  ソート部分が一番大きいので.今回はn<=100なので、nlogn ≒ 300 となり、300 / 10^8とすると 30マイクロ秒くらいで終わりそう
空間：O(n)

・解き方
ぱっと見よくわからないので、４つ数字があるときの様子を追ってみる。
よくみると、右から見ていきnums[i] < nums[i+1]となったときに、そのnums[i]は変わる必要があることがわかる。
そのあと、何と交換するかであるが辞書順の次なので、nums[i]より大きい最小の値となるはずである。
ということで、iよりおおきいindexについてみていき最小の値をみつけてnums[i]とswapする。
そのあとはiより右側は昇順ソートすればおk

・所感
かなり最初は無理そうだったが、よくよく観察することでとけた。
アルゴリズムさえわかれば実装は問題なさそう。
アルゴリズムについては本番でみつけられるかというとこの問題は結構むずかしそうだなと思った。
簡単な例から法則性を見出す練習を積むしかなさそう

 */

public class solution1_1 {
  // [1,2,3,4]
  // [1,2,4,3]
  // [1,3,2,4]
  // [1,3,4,2]
  // [1,4,2,3]
  // [1,4,3,2]
  // [2,1,3,4]
  // 右から見る、num[i] < num[i + 1]となるiをみつける
  // num[i]より大きい最初の値をiの右側で見つける。
  // 右側は、昇順になるようにする。
  // O(nlogn)
  public void nextPermutation(int[] nums) {
    // 降順チェック。
    boolean isDesending = true;
    for (int i = 0; i < nums.length - 1; i++) {
      if (nums[i] < nums[i + 1]) {
        isDesending = false;
      }
    }
    if (isDesending) {
      Arrays.sort(nums);
      return;
    }
    List<Integer> sortedNums = new ArrayList<>();
    for (int i = nums.length - 2; 0 <= i; i--) {
      if (nums[i] < nums[i + 1]) {
        int swapIndex = i + 1;
        for (int j = i + 2; j < nums.length; j++) {
          if (nums[i] < nums[j] && nums[j] < nums[swapIndex]) {
            swapIndex = j;
          }
        }
        int tmp = nums[i];
        nums[i] = nums[swapIndex];
        nums[swapIndex] = tmp;

        for (int j = i + 1; j < nums.length; j++) {
          sortedNums.add(nums[j]);
        }
        Collections.sort(sortedNums);
        for (int j = i + 1; j < nums.length; j++) {
          nums[j] = sortedNums.get(j - (i + 1));
        }
        return;
      }
    }
  }
}
