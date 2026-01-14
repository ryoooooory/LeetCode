/*
・概要
自力解法
10分ほどでAC

・解き方
MTGの時間が重ならなければいいので、開始時間でソートして、前後の開始時間と終了時間が重なってないかを確認していく。

・計算量
時間：一回ソートしているのでO(nlogn) nが10^4なので、合計10^5くらいなので、だいたい0.01sくらいでできそう。
空間：O(n)

・所感
解き方はすぐでたが、配列のソートどうしようと悩んだ。priorityqueueとかもできるなと思ったがシンプルにリストにした方がわかりやすいかなと思いそちらで実装。
ラムダ式でソートしてみたが、ChatGPTによると、a - bの部分でオーバーフローになる危険性があるからcomparatorを使う方がいいと言われた。
実際に以下で試してみると確かにおかしくなった。(そらそう)
入力値：[-2147483648, 2147483647]
結果：[2147483647,-2147483648]

  public static void main(String[] args) {
    // testSort(Integer.MIN_VALUE + 1, Integer.MIN_VALUE);
    testSort(Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  public static void testSort(int x, int y) {
    List<Integer> list = new ArrayList();
    list.add(x);
    list.add(y);
    list.sort((a, b) -> (a - b));

    for (int num : list) {
      System.out.print(num);
      System.out.print(",");
    }
  }


  ということで、ソートするときはcompareを使う。
      list.sort((a, b) -> Integer.compare(a, b));


*/

public class solution1_1 {
  public boolean canAttendMeetings(int[][] intervals) {
    List<Interval> intervalList = new ArrayList<>();
    for (int[] interval : intervals) {
      intervalList.add(new Interval(interval[0], interval[1]));
    }
    intervalList.sort((a, b) -> (a.start - b.start)); // 上記の通り、compareを使うべき
    for (int i = 0; i < intervalList.size() - 1; i++) {
      if (intervalList.get(i + 1).start < intervalList.get(i).end) {
        return false;
      }
    }
    return true;
  }

  class Interval {
    int start;
    int end;

    Interval(int start, int end) {
      this.start = start;
      this.end = end;
    }
  }
}
