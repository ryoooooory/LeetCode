public class solution2_2 {
  /**
   * https://github.com/seal-azarashi/leetcode/pull/19/filesを元にした解放 時間計算量: O(m * m * n), 空間計算量: O(n)
   * 解法としてはシンプルにstartWordから隣接単語があるかをBFSで見る方法
   * 派生として、WordDistanceを作らなくても、whileの中で現在のQueueのsizeを取得してfor分でその回数分まわし、その後にcounterをインクリメントするようにすれば、QueueはStringを保持するだけでSequenceの長さを保持する必要はなくなる→ただしsolution2_4にもあるとおり、あまり一般的でない？かもなので素直にrecord作った方が無難かも
   */
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    record WordDistance(String word, int distance) {}
    ;

    Queue<WordDistance> wordDistances = new ArrayDeque<>();
    wordDistances.offer(new WordDistance(beginWord, 1));
    while (!wordDistances.isEmpty()) {
      WordDistance current = wordDistances.poll();
      if (current.word.equals(endWord)) {
        return current.distance;
      }
      Set<String> addedWords = new HashSet<>();
      for (String targetWord : wordList) {
        if (!isTransformable(current.word, targetWord)) {
          continue;
        }
        addedWords.add(targetWord);
        wordDistances.offer(new WordDistance(targetWord, current.distance + 1));
      }
      wordList.removeAll(addedWords);
    }
    return 0;
  }

  private boolean isTransformable(String lhs, String rhs) {
    char[] leftChars = lhs.toCharArray();
    char[] rightChars = rhs.toCharArray();
    int diff = 0;
    for (int i = 0; i < leftChars.length; i++) {
      if (leftChars[i] != rightChars[i]) {
        diff++;
      }
      if (1 < diff) {
        return false;
      }
    }
    return true;
  }
}
