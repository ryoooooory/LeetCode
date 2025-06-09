/*
 * ・概要
 * 自力解法
 * 最初に各要素についてとるとらないを考えて2^nになるなと思った。
 * i番目の家でrobするかどうかを考えると、２個前までの最大値＋現在の家の合計 or １個前の最大値（現在の家はとらない）の大きい方をとればいいのだと考えDPで実装。
 * dp[i]: i番目まででの最高Rob
 * dp[i] = max(dp[i - 1], dp[i - 2] + nums[i])
 * 実装はできてあってるんだけど、1個前の最大値については、1個前が使われてない場合もあるのになんでnums[i]を一律つかわないでいいんだろう、あまり腹落ちしない
 * ↓
 * solution1_3まで実装して気づいたが、solution1_3を思いつく→改良する→solution1_1の解法を思いつくが思考として自然だと感じた。
 *  *
 * 5分くらいでAC
 *
 * ・計算量
 * O(n): nはnumsの要素数
 * O(n)
 *
 * ・その他
 * よくよく考えると、１次元配列で１、２つ前の値しか使わないので変数でいける→空間はO(1)にできそう。
 * もっとわかりやすく考えると、とる、とらないの二次元配列にして、最大をとったほうが直感的かも。
 *
 */
public class solution1_1 {
  public int rob(int[] nums) {
    if (nums.length == 0) {
      return 0;
    } else if (nums.length == 1) {
      return nums[0];
    } else if (nums.length == 2) {
      return Math.max(nums[0], nums[1]);
    }
    int[] currentMaxSum = new int[nums.length];
    currentMaxSum[0] = nums[0];
    currentMaxSum[1] = Math.max(nums[0], nums[1]);
    for (int i = 2; i < nums.length; i++) {
      currentMaxSum[i] = Math.max(currentMaxSum[i - 1], currentMaxSum[i - 2] + nums[i]);
    }
    return currentMaxSum[nums.length - 1];
  }
}
