import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/** コメントをいただきsolution3_1をネストが深くならないように改善したもの */
public class solution3_1 {

  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    Queue<String> transformWords = new ArrayDeque<>();
    transformWords.offer(beginWord);
    int sequenceLength = 1;
    if (beginWord.equals(endWord)) {
      return sequenceLength;
    }
    Set<String> wordSet = new HashSet<>(wordList);
    while (!transformWords.isEmpty()) {
      String currentWord = transformWords.poll();
      if (currentWord.equals(endWord)) {
        return sequenceLength;
      }
      Queue<String> adjacentWords = new ArrayDeque<>();
      searchAdjacentWord(currentWord, wordSet, adjacentWords);
      transformWords = adjacentWords;
      sequenceLength++;
    }
    return 0;
  }

  private void searchAdjacentWord(String word, Set<String> wordSet, Queue<String> adjacentWords) {
    StringBuilder transformWord = new StringBuilder(word);
    for (int wordIndex = 0; wordIndex < transformWord.length(); wordIndex++) {
      for (char convertingChar = 'a'; convertingChar <= 'z'; convertingChar++) {
        char originalChar = transformWord.charAt(wordIndex);
        transformWord.setCharAt(wordIndex, convertingChar);
        String targetWord = transformWord.toString();
        if (wordSet.contains(targetWord)) {
          adjacentWords.offer(targetWord);
          wordSet.remove(targetWord);
        }
        transformWord.setCharAt(wordIndex, originalChar);
      }
    }
  }
}
