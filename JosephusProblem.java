package LeetCode;

public class JosephusProblem {
    public static int josephus(int n, int k) {
        int position = 0;
        for (int i = 2; i <= n; i++) {
            position = (position + k) % i;
        }
        return position + 1;
    }
    
    public static void main(String[] args) {
        int n = 6;
        int k = 4;
        int result = josephus(n, k);
        System.out.println("最后剩下的孩子是第 " + result + " 号孩子");
    }
}
// 在这个问题中，如果我们知道最后剩下的孩子在每一轮剔除之后的位置，就可以直接得出答案。
// 首先，我们注意到每一轮剔除之后，剩下的孩子的位置会向前移动了 k 个位置。所以我们可以得出如下的递推关系：
// 如果最后剩下的孩子在第 i 轮剔除之后的位置为 f(n, k, i)，那么在第 i+1 轮剔除之后，最后剩下的孩子的位置为：
// f(n, k, i+1) = (f(n, k, i) + k) % i
// 其中，% 表示取模运算。最后，当 i=n-1 时，就是最后一轮剔除之后的位置，也就是最后剩下的孩子的位置。
// 由于我们只需要求出最后一个孩子的位置，而不需要求出每一轮剔除之后的位置，所以我们可以使用迭代的方式来求解，而不需要存储每一轮的结果。