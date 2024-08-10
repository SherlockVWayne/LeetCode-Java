package LeetCode;

import java.util.Arrays;

public class ReformatDate_1507 {
    static String[] month = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    
    public static String reformatDate(String date) {
        String[] strArr = date.split(" ");
        StringBuilder sb = new StringBuilder();
        sb.append(strArr[2]).append("-");
        String mon = String.valueOf(Arrays.asList(month).indexOf(strArr[1]) + 1);
        sb.append(mon.length() == 1 ? "0" + mon : mon).append("-");
        
        String day = strArr[0].substring(0, strArr[0].length() - 2);
        sb.append((day.length() == 1 ? "0" + day : day));
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(reformatDate("6th Jun 1933"));
    }
}
