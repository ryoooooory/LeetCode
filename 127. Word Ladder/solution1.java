public class solution1 {
  /**
   * 自力解法 // TLEとなった。 // 時間計算量: O(m * m * n + n^n), 空間計算量: O(m * m * n) m: wordListの要素数、　n: 要素の文字数
   * 解法については、一文字ずつ変換して、最終的にendwordになればいいので、dfsで探索していく。その過程で無限ループに入るのを防ぐためSetを使いメモ化 //
   * また、dfsでの探索を効率化するためにはじめにwordListの各要素について１文字ちがいのものを洗い出し、Mapで保持する。 // //
   * 所感としては、まずそもそも解けなかったし、時間計算量の部分もあやしい（もっというと再帰のときの計算量のみつもりが怪しい）,変数名も良くない、adjacentとか使った方がシンプルそう
   */
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    Map<String, Set<String>> wordsDiffedByOneLetter = new HashMap<>();
    checkWordsDiffedByOneLetter(beginWord, endWord, wordList, wordsDiffedByOneLetter);
    Set<String> visited = new HashSet<String>();
    visited.add(beginWord);
    int minTransformationCount =
        getShortestTransfomrationSequcenceCount(
            beginWord, endWord, 0, wordsDiffedByOneLetter, visited);
    if (minTransformationCount == Integer.MAX_VALUE) {
      return 0;
    } else {
      return minTransformationCount;
    }
  }

  private void checkWordsDiffedByOneLetter(
      String beginWord,
      String endWord,
      List<String> wordList,
      Map<String, Set<String>> wordsDiffedByOneLetter) {
    for (int i = 0; i < wordList.size(); i++) {
      String word = wordList.get(i);
      for (int j = 0; j < wordList.size(); j++) {
        if (word.equals(wordList.get(j))) {
          continue;
        }
        addWordDiffedByOneLetter(wordsDiffedByOneLetter, word, wordList.get(j));
      }
    }
    for (int i = 0; i < wordList.size(); i++) {
      addWordDiffedByOneLetter(wordsDiffedByOneLetter, beginWord, wordList.get(i));
    }
  }

  private void addWordDiffedByOneLetter(
      Map<String, Set<String>> wordsDiffedByOneLetter, String word, String adjacent) {
    int diff = 0;
    for (int l = 0; l < word.length(); l++) {
      if (word.charAt(l) != adjacent.charAt(l)) {
        diff++;
      }
      if (1 < diff) {
        break;
      }
    }
    if (diff == 1) {
      Set<String> transformedWords = wordsDiffedByOneLetter.getOrDefault(word, new HashSet<>());
      transformedWords.add(adjacent);
      wordsDiffedByOneLetter.put(word, transformedWords);
    }
  }

  private int getShortestTransfomrationSequcenceCount(
      String current,
      String endWord,
      int count,
      Map<String, Set<String>> wordsDiffedByOneLetter,
      Set<String> visited) {
    if (current.equals(endWord)) {
      return count + 1;
    }
    Set<String> transformedWords = wordsDiffedByOneLetter.get(current);
    int minTransformationCount = Integer.MAX_VALUE;
    if (transformedWords == null) {
      return minTransformationCount;
    }
    for (String candidate : transformedWords) {
      if (visited.contains(candidate)) {
        continue;
      }
      visited.add(candidate);
      minTransformationCount =
          Math.min(
              minTransformationCount,
              getShortestTransfomrationSequcenceCount(
                  candidate, endWord, count + 1, wordsDiffedByOneLetter, visited));
      visited.remove(candidate);
    }
    return minTransformationCount;
  }
}
