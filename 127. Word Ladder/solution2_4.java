import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class solution2_4 {
  /**
   * solution2_1と同様に、効率的に計算するために小文字英単語（26文字）で現在の単語を変えて、wordListにあるかを見ながら探索していく解法 計算量としては、O(n * n *
   * m)
   *
   * <p>https://github.com/Ryotaro25/leetcode_first60/pull/22/files
   * https://github.com/Hurukawa2121/leetcode/pull/20/files を参考に実装した。
   * 上記のPRのコメントにもあるようにQueueのサイズを元にその階層での回す回数をもつみたいなのは一般的でないかも？他のSolutionと同じく、recordなどで要素と階層を記録した方がいいかもしれない。
   */
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    Queue<String> transformWords = new ArrayDeque<>();
    transformWords.offer(beginWord);
    int sequenceLength = 1;
    if (beginWord.equals(endWord)) {
      return sequenceLength;
    }
    Set<String> wordSet = new HashSet<>(wordList);
    while (!transformWords.isEmpty()) {
      int adjacentsCount = transformWords.size();
      for (int i = 0; i < adjacentsCount; i++) {
        String currentWord = transformWords.poll();
        if (currentWord.equals(endWord)) {
          return sequenceLength;
        }
        StringBuilder transformWord = new StringBuilder(currentWord);
        for (int wordIndex = 0; wordIndex < transformWord.length(); wordIndex++) {
          for (char convertingChar = 'a'; convertingChar <= 'z'; convertingChar++) {
            char originalChar = transformWord.charAt(wordIndex);
            transformWord.setCharAt(wordIndex, convertingChar);
            String targetWord = transformWord.toString();
            if (wordSet.contains(targetWord)) {
              transformWords.offer(targetWord);
              wordSet.remove(targetWord);
            }
            transformWord.setCharAt(wordIndex, originalChar);
          }
        }
      }
      sequenceLength++;
    }
    return 0;
  }
}
