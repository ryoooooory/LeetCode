/*
他の人の解法を参考にした。
https://github.com/Satorien/LeetCode/pull/55/files
まずHeapにいれて、その後Heapの中身見ながらRoomを別の配列に入れていくもの。Roomを入れる配列は毎回ソートする。
あーたしかにとはおもいつつも、毎回ソートするならpriorityqueueでもいいかもなと思った。

https://github.com/Kaichi-Irie/leetcode-python/pull/21/files
Roomいれる配列について維持したまま、置き換えていくイメージ。

https://github.com/Fuminiton/LeetCode/pull/49/files
タプルを使って開始と終了についてそれぞれ時刻とあわせた情報をもち、それを全部配列にいれてソートして±変えていくもの。
これは思いつかない発想だったすごい。

https://github.com/Fuminiton/LeetCode/pull/49#discussion_r2221896539
これはほんとに自分も癖つけた方がいいなと思った（計算量だけで満足することもおおいので）


ということで、開始・終了についてそれぞれ時刻とあわせた情報をもち、それを全部配列にいれてソートして±変えていくもので実装
*/

public class solution2_1 {
  public int minMeetingRooms(int[][] intervals) {
    List<MeetingEvent> sortedIntervals = new ArrayList<>();
    for (int[] interval : intervals) {
      sortedIntervals.add(new MeetingEvent(interval[0], EventType.START));
      sortedIntervals.add(new MeetingEvent(interval[1], EventType.END));
    }
    sortedIntervals.sort(
        (a, b) -> {
          if (a.time != b.time) {
            return Integer.compare(a.time, b.time);
          }
          return a.type.compareTo(b.type);
        });
    int needMaxRoomCounts = 0;
    int needRoomCounts = 0;
    for (MeetingEvent event : sortedIntervals) {
      if (event.type == EventType.START) {
        needRoomCounts++;
      } else if (event.type == EventType.END) {
        needRoomCounts--;
      }
      needMaxRoomCounts = Math.max(needMaxRoomCounts, needRoomCounts);
    }
    return needMaxRoomCounts;
  }

  enum EventType {
    END,
    START
  }

  class MeetingEvent {
    int time;
    EventType type;

    MeetingEvent(int time, EventType type) {
      this.time = time;
      this.type = type;
    }
  }
}
