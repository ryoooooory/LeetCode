public class solution2_3 {
  /**
   * 他の人の解法をみているうちに最初の自力解法(solution1）も計算量のオーダーは変わらないのではとおもいsolution1をベースに改良したもの
   * DFSをBFSにしたことでTLEにはならなかったが、かなり遅い。探索中は２回同じ要素をみることはないので、そもそも隣接wordのリストを作ること自体不要だった（なのでsolution2_2のが計算量は一緒だが早い）
   */
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    Map<String, Set<String>> adjacentWordsMap = makeAdjacentWordsMap(beginWord, endWord, wordList);
    return getShortestTransfomrationSequcenceCount(beginWord, endWord, 0, adjacentWordsMap);
  }

  private Map<String, Set<String>> makeAdjacentWordsMap(
      String beginWord, String endWord, List<String> wordList) {
    Map<String, Set<String>> adjacentWordsMap = new HashMap<>();
    for (int i = 0; i < wordList.size(); i++) {
      String word = wordList.get(i);
      for (int j = 0; j < wordList.size(); j++) {
        addAdjacentWord(adjacentWordsMap, word, wordList.get(j));
      }
    }
    for (int i = 0; i < wordList.size(); i++) {
      addAdjacentWord(adjacentWordsMap, beginWord, wordList.get(i));
    }
    return adjacentWordsMap;
  }

  private void addAdjacentWord(
      Map<String, Set<String>> adjacentWordsMap, String word, String adjacentCandidate) {
    int diff = 0;
    for (int l = 0; l < word.length(); l++) {
      if (word.charAt(l) != adjacentCandidate.charAt(l)) {
        diff++;
      }
      if (1 < diff) {
        return;
      }
    }
    if (diff == 1) {
      Set<String> adjacentWords = adjacentWordsMap.getOrDefault(word, new HashSet<>());
      adjacentWords.add(adjacentCandidate);
      adjacentWordsMap.put(word, adjacentWords);
    }
  }

  private int getShortestTransfomrationSequcenceCount(
      String beginWord,
      String endWord,
      int count,
      Map<String, Set<String>> wordsDiffedByOneLetter) {
    Queue<WordDistance> wordDistances = new ArrayDeque<>();
    wordDistances.offer(new WordDistance(beginWord, 1));
    Set<String> visited = new HashSet<>();
    visited.add(beginWord);

    while (!wordDistances.isEmpty()) {
      WordDistance current = wordDistances.poll();
      if (current.word.equals(endWord)) {
        return current.distance;
      }
      for (String targetWord :
          wordsDiffedByOneLetter.getOrDefault(current.word, new HashSet<String>())) {
        if (targetWord.equals(endWord)) {
          return current.distance + 1;
        }
        if (!visited.contains(targetWord)) {
          visited.add(targetWord);
          wordDistances.offer(new WordDistance(targetWord, current.distance + 1));
        }
      }
    }
    return 0;
  }

  record WordDistance(String word, int distance) {}
}
