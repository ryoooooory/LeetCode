/*
・概要
自力解法・
10分ほどでAC

・解き方。
バブルソート的に、左から0を探して、そのindexより右側で0でないものと交換していく。

・計算量
時間：二重ループなのでO(n^2)
空間：O(1)

・所感
うまくやれば１ループでできそうな感じがするが思い浮かばなかった。

*/

public class solution1_1 {
  // [0,1,2] [2,1,0]
  public void moveZeroes(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != 0) {
        continue;
      }
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[j] == 0) {
          continue;
        }
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
        break;
      }
    }
  }
}
