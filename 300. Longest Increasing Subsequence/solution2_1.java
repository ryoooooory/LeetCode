/*
 * ・概要
 * LeetCodeの解説やhttps://github.com/tokuhirat/LeetCode/pull/31/files, https://github.com/seal-azarashi/leetcode/pull/28/filesで同じような二分探索をつかった高速化の解法がある。
 * しかしその解法だと、部分配列でないのに長さがあっているって気づきにくくないかな？
 * 仕組みを言われればわかるけど、自分で思いつきはしなさそうに感じる（[1,3,4,2]で部分文字列が、[1]→[1,3]→[1,3,4]→[2,3,4]とするのが違和感（長さは一緒だからOKという理屈はわかるが直感的でないなあというイメージ））
 * https://github.com/TORUS0818/leetcode/blob/e70ab6ae799404d8f841f259e48183bc41122031/medium/300/answer.md　同じ気持ちの人がいた
 * これの元となったPatientSortというものがあるらしいのでそこからまず調べる。
 *
 * ・PatientSort
 * 最長増加列の効率的なアプローチ。
 * 基本的な戦略は以下の二つで、前提として配列はA、積み上げる部分をP(パイル)とする
 * 1, Aについて左から右に読み込み、Pに積み上げる。Pは単純増加としPの先頭より小さい場合のみ積み上げられる。条件を満たすものがない時は新しいPを作る。
 * 2, Pから順番に上の値をヒープにいれて、そこから出力していく。
 * 参考：https://qiita.com/kgoto/items/d1e9d39b8b391fc19970、https://en.wikipedia.org/wiki/Patience_sorting
 *
 *
 * ・今回の問題へのPatientSortを使ったアプローチ
 * 思考の流れを整理してみる。
 * PatientSortのステップ1のように単純増加のパイルを作っていく。
 * パイルの数が最長文字列の長さになる。
 *
 * ・計算量
 * 時間計算量：O(n^2) :nはnumsの要素数
 * 空間計算量：O(n)
 *
 * ・その他
 * 線形でパイルを走査している部分を二分探索で高速化できるので、solution2_2でやる。
 * 実装後に気づいたが、各pileについて一番後ろしかみてないので、2次元にしなくても1次元でいい気がする。
 *
 * ・所感
 * 解説や他の方の解法をみても腑に落ちなかったので暗記するかあと思ったが、冷静に背景知識なども調べることで理解が深まって腑に落ちたので良かった。
 * 振りかえってみても配列を左から見て、その要素よりも大きい値といれかえながら部分列をつくっていくアプローチは言われて証明も難しそうだし、思考ステップの飛躍が結構あると思う。（まあ上記のアプローチもPatientSortを知らなければ思いつくのは無理な気もするが）
 *
 */

public class solution2_1 {
  public int lengthOfLIS(int[] nums) {
    List<List<Integer>> piles = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      boolean isExistValidPile = false;
      for (int j = 0; j < piles.size(); j++) {
        List<Integer> pile = piles.get(j);
        if (nums[i] <= pile.get(pile.size() - 1)) {
          isExistValidPile = true;
          piles.get(j).add(nums[i]);
          break;
        }
      }
      if (!isExistValidPile) {
        List<Integer> pile = new ArrayList<>();
        pile.add(nums[i]);
        piles.add(pile);
      }
    }
    return piles.size();
  }
}
