/*
・概要
solution1_1にて、Listでソートしていたが、配列でもできるので配列でやってみた。
ソートについては同じだが、今回はstreamを使ってソートしたもののコピーを作ってみた。
streamの利点としてやはり元のデータを壊さないことがいい。
*/

public class solution1_2 {
  public boolean canAttendMeetings(int[][] intervals) {
    int[][] sortedIntervals =
        Arrays.stream(intervals)
            .sorted((a, b) -> Integer.compare(a[0], b[0]))
            .toArray(int[][]::new);
    for (int i = 0; i < sortedIntervals.length - 1; i++) {
      if (sortedIntervals[i + 1][0] < sortedIntervals[i][1]) {
        return false;
      }
    }
    return true;
  }
}
