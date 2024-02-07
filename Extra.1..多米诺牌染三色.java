import java.util.List;

/**
 * We have a board with a 2×N grid. Snuke covered the board with N dominoes without overlaps. Here,
 * a domino can cover a 1×2 or 2×1 square.
 *
 * Then, Snuke decided to paint these dominoes using three colors: red, cyan and green. Two dominoes
 * that are adjacent by side should be painted by different colors. Here, it is not always necessary
 * to use all three colors.
 *
 * Find the number of such ways to paint the dominoes, modulo 1000000007.
 *
 * The arrangement of the dominoes is given to you as two strings S1 and S2 in the following manner:
 *
 * Each domino is represented by a different English letter (lowercase or uppercase). The j-th
 * character in Si represents the domino that occupies the square at the i-th row from the top and
 * j-th column from the left.
 *
 * Constraints 1≤N≤52 |S1|=|S2|=N S1 and S2 consist of lowercase and uppercase English letters. S1
 * and S2 represent a valid arrangement of dominoes.
 *
 * 题意：有一个 2*n 大小的区域，上面有 n 个1*2 的牌将所有区域覆盖，现在给出 n 和 n 个牌的排列方式，要在这些牌中涂上三种颜色，要求相邻颜色不同，问有多少中涂色方法
 *
 * 思路：递推
 *
 * 首先考虑最左边的一个或两个矩形，如果最左边是一个竖着的牌，那么涂色情况有三种；如果最左边是两个横着的牌，那么涂色情况有 C(3,1)*C(3,2)=6 种情况
 *
 * 于是，可以根据最左边的情况，向右进行递推：
 *
 * 当左边的牌是竖着的牌，右边的牌是竖着的牌，那么在两种颜色中选一个涂，即在原基础上乘以 C(2,1)=2 当左边的牌是竖着的牌，右边的牌是两个横着的牌，那么两种颜色都要涂上，即在原基础上乘以
 * A(2,2)=2 当左边的牌是两个横着的牌，右边的牌是竖着的牌，那么右边的牌没有选择，只能涂剩下的那一种颜色，即不做改变 当左边的牌是两个横着的牌，右边的牌是两个横着的牌，此时假设左上涂颜色
 * 1，左下涂颜色 2，那么右上只能涂颜色 2 或颜色 3，当右上涂颜色 2 时，右下要么涂颜色 1 要么涂颜色 3；当右上涂颜色 3 时，右下没有选择，只能涂颜色 1，即在原基础上乘以 2+1=3
 *
 * https://blog.csdn.net/u011815404/article/details/93053540
 *
 */
class solution {
  public int coloring(List<String> str) {
    char[] str1 = str.get(0).toCharArray();
    char[] str2 = str.get(1).toCharArray();
    int n = str1.length;

    int res = 1;
    int pre = 0;
    int i = 0;
    int MOD = 1000000007;

    if (str1[i] == str2[i]) {
      res = 3;
      pre = 1;
      i++;
    } else {
      res = 6;
      pre = 2;
      i += 2;
    }

    while (i < n) {
      if (str1[i] == str2[i]) {
        if (pre == 1) {
          res = res * 2 % MOD;
          pre = 1;
          i++;
        } else {
          res = res * 1;
          pre = 2;
          i += 2;
        }
      } else {
        if (pre == 1) {
          res = res * 2 % MOD;
          pre = 2;
          i += 2;
        } else {
          res = res * 3 % MOD;
          pre = 2;
          i += 2;
        }
      }
    }
    return res;
  }
}
