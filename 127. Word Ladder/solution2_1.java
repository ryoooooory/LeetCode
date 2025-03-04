public class solution2_1 {
  /**
   * LeetCodeの解法 時間計算量: O(n * n * m), 空間計算量: O(n * n * m) m: wordListの要素数、　n: 要素の文字数
   * 解法については、「１文字違いの単語にtransform」の部分を*を用いた代替単語を作成し、それをMapで保持することで探索する時にその情報をつかうもの。 //
   * 所感としては、自力でアプローチによって計算量がかなり変わることに気づいて実装できてれば自力でとけたのでもったいないなとおもった。 //
   * 今回の問題で言うと、１文字違いをどうやって効率的に保持してDFSorBFSの時に使うかが重要。wordListについて全て１文字違いかどうかを確認するとなるとO(n*n*m*m)となってしまい厳しい→文字を変換したものをMapのKeyにすることで、
   * // 探索時は文字変換処理の分だけ少しだけ手間がかかるが全体としてはO(n * n * m)に抑えられるといった流れでいけると理想
   *
   * <p>// https://github.com/tshimosake/arai60/pull/11/files　よりendWordのearly return //
   * https://github.com/Hurukawa2121/leetcode/pull/20/files よりbfsの内部処理を別関数に移行（ループはなるべく２重までがよさそう） //
   * https://github.com/seal-azarashi/leetcode/pull/19/files
   * '*'が文字列に含まれていた時の考慮、最短経路問題ではまずBFSを頭に浮かべたい
   */
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    int wordLength = beginWord.length();
    Map<String, List<String>> allComboDict = new HashMap<>();
    boolean isExistEndWordInWordList = false;
    for (String word : wordList) {
      if (word.equals(endWord)) {
        isExistEndWordInWordList = true;
      }
      for (int i = 0; i < wordLength; i++) {
        String alternativeWord = word.substring(0, i) + '*' + word.substring(i + 1, wordLength);
        List<String> alternativeWords =
            allComboDict.getOrDefault(alternativeWord, new ArrayList<>());
        alternativeWords.add(word);
        allComboDict.put(alternativeWord, alternativeWords);
      }
    }
    if (!isExistEndWordInWordList) {
      return 0;
    }
    return countTransformation(beginWord, endWord, wordList, allComboDict);
  }

  private int countTransformation(
      String beginWord,
      String endWord,
      List<String> wordList,
      Map<String, List<String>> allComboDict) {
    Queue<Transformation> transformations = new ArrayDeque();
    transformations.offer(new Transformation(beginWord, 1));
    Set<String> visitedWords = new HashSet<>();
    visitedWords.add(beginWord);
    int wordLength = beginWord.length();

    while (!transformations.isEmpty()) {
      Transformation current = transformations.poll();
      String word = current.word;
      int transformCount = current.count;
      for (int i = 0; i < wordLength; i++) {
        String alternativeWord = word.substring(0, i) + '*' + word.substring(i + 1, wordLength);
        for (String adjacentWord :
            allComboDict.getOrDefault(alternativeWord, new ArrayList<String>())) {
          if (adjacentWord.equals(endWord)) {
            return transformCount + 1;
          }
          if (!visitedWords.contains(adjacentWord)) {
            visitedWords.add(adjacentWord);
            transformations.offer(new Transformation(adjacentWord, transformCount + 1));
          }
        }
      }
    }
    return 0;
  }

  record Transformation(String word, int count) {}
  ;
}
