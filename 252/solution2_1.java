/*
他の人の解法
https://github.com/Satorien/LeetCode/pull/54/files
あーたしかに全スケジュールを時間の配列つくってBlockする方法もあるか

https://github.com/hayashi-ay/leetcode/pull/59/files
まあheapでも同じようにできるよね。

https://github.com/hayashi-ay/leetcode/pull/59/files
あーendTimeを変数でもって、それを各intervalの最初と比べるのか〜。ただこれだと番兵とかいるな〜と言う印象

ということでHeapで実装してみる。
*/

public class solution2_1 {
  public boolean canAttendMeetings(int[][] intervals) {
    if (intervals.length == 0) {
      return true;
    }
    PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> (Integer.compare(a[0], b[0])));
    for (int[] interval : intervals) {
      heap.offer(interval);
    }
    int lastEndTime = heap.peek()[0];
    while (!heap.isEmpty()) {
      int[] current = heap.poll();
      if (current[0] < lastEndTime) {
        return false;
      }
      lastEndTime = current[1];
    }
    return true;
  }
}
