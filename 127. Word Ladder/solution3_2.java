import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/** いただいたコメントを反映し、Solution2_2の変数名などを修正 */
public class solution3_2 {
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    if (beginWord.equals(endWord)) {
      return 1;
    }
    Queue<String> transformedWords = new ArrayDeque<>();
    transformedWords.offer(beginWord);
    int sequenceLength = 1;
    while (!transformedWords.isEmpty()) {
      Queue<String> adjacentWords = new ArrayDeque<>();
      while (!transformedWords.isEmpty()) {
        String current = transformedWords.poll();
        if (current.equals(endWord)) {
          return sequenceLength;
        }
        Set<String> visitedWords = new HashSet<>();
        for (String word : wordList) {
          if (isAdjacent(current, word)) {
            adjacentWords.offer(word);
            visitedWords.add(word);
          }
        }
        wordList.removeAll(visitedWords);
      }
      transformedWords = adjacentWords;
      sequenceLength++;
    }
    return 0;
  }

  boolean isAdjacent(String word1, String word2) {
    char[] word1Chars = word1.toCharArray();
    char[] word2Chars = word2.toCharArray();
    int diff = 0;
    for (int i = 0; i < word1Chars.length; i++) {
      if (word1Chars[i] != word2Chars[i]) {
        diff++;
        if (1 < diff) {
          return false;
        }
      }
    }
    return true;
  }
}
