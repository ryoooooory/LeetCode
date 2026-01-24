/*
・概要
自力解法
5分くらいで思いついて、15分くらいで実装。
何度かループ条件などを間違えたのちにAC

・解き方
k番目の値がどうなるかを考えると、問題文の通り0, 10と前の状態を反転したものを加えていくので、必然的に再帰的な処理で実装できると感じた。
そこから、繰り返しの処理はどうなるかを考えると、現在知りたいindexが前の状態で左から何番目の位置にあったかが分かれば、最終的に最初の0が反転すべき位置なのかがわかる。
前の状態については、数字が2倍ずつ増えていくことより、２のx乗 < 現在地となる最大のxを求めれば、2のx乗までの文字が前の状態となる。
上記を繰り返すことで、最終的にk番目の値が最初の0を反転するか否かがわかる。

・計算量
時間：O(logk * logk)
空間：O(1)

・所感
だいぶ頭に解法を浮かべて実装する流れはできてきたが、まだふわっとした解法からしっかりした解法にする部分と、解法を実装にする力がまだ不足している。
また最終的にエッジケースをうかべて条件式などを修正する力も弱いのでここらへんを意識してこれからの問題を解きたい。
しっかり解法にするところは、簡単なケースを複数用意して実際に処理を追っていくのをもうすこし精度高くする。
実装力はなれ？


*/

public class solution1_1 {
  // 0, 01, 0110, 01101001,
  // 1:0, 2:1, 3:1, 4:0
  public int kthGrammar(int n, int k) {
    boolean reversed = false;
    int currentTarget = k;
    while (currentTarget != 1) {
      int nearPow = getNearPow(currentTarget); // 変数名、関数名があきらかによくないよなと思う。nearってなんやねん感
      currentTarget = currentTarget - nearPow;
      reversed = !reversed;
    }
    return reversed ? 1 : 0;
  }

  private int getNearPow(int target) {
    int base = 2;
    int result = 1;
    while (result <= target) {
      if (target <= result * base) {
        break;
      }
      result *= base;
    }
    return result;
  }
}
