/*
・概要
自力解法
5分くらいでAC

・解き方。
252 Meeting Roomと同様にまずintervalの開始でソートしてみていく。
今回はかさなった重なったintervalがあったらそのぶん部屋を追加できるので、重なった部分を保持する必要がある。
intervalを見るときは、その現在使われているintervalがないかをみて、現在のintervalの開始より前の時間で終了しているintervalは保持から削除していく。
ということで、保持する必要があり、かつ保持したものを削除するのにソートされていた方が効率的なので両方を満たすPriorityQueueで実装する。

・計算量
時間：O(nlogn) n:intervalsの要素数。　問題制約からnは10^4なので、だいたい10^5くらいなので、0.01sくらいで終わりそう
空間；O(n)

・所感
なんか実装方針がわかれば自然に実装ができるようになってきた気がする。
言語化しづらいが、自分の頭でえがいたものパソコン（まあJavaだけど）に伝えるのができるようになってきた実感？
多分慣れと手段という知識が増えたこと、アルゴリズムを頭に描いてから実装という流れの定着、実装して理解より、理解して実装が増えてきたからな気がする
コードを頭の中でもんで再定義したり、他の人の解法で少し違う実装を見たりして、コードと思考がつながってきたのも大きい。


*/

public class solution1_1 {
  public int minMeetingRooms(int[][] intervals) {
    List<Interval> sortedIntervals = new ArrayList<>();
    for (int[] interval : intervals) {
      sortedIntervals.add(new Interval(interval[0], interval[1]));
    }
    sortedIntervals.sort((a, b) -> (Integer.compare(a.start, b.start)));
    PriorityQueue<Interval> pq =
        new PriorityQueue<>(
            (a, b) -> (Integer.compare(a.end, b.end))); // pqよりusedRoomsとかのがコンテキストにあってそう。
    int maxRoomCounts = 0;
    for (Interval interval : sortedIntervals) {
      while (!pq.isEmpty() && pq.peek().end <= interval.start) {
        pq.poll();
      }
      pq.offer(interval);
      maxRoomCounts = Math.max(maxRoomCounts, pq.size());
    }
    return maxRoomCounts;
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
