package LeetCode;

public class CalculateMoneyInLeetcodeBank_1716 {
    public static int totalMoney(int n) {
        if (n <= 0) {
            return 0;
        }
        int weekNums = n / 7;
        int daysNums = n % 7;
        int a = 1;
        return 28 * weekNums + (weekNums * (weekNums - 1) / 2) * 7 + // complete weeks
            weekNums * daysNums + (1 + daysNums) * daysNums / 2;
    }
    
    public static void main(String[] args) {
        System.out.println(totalMoney(20));
    }
}
