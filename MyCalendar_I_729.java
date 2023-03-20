package LeetCode;

import java.util.*;

public class MyCalendar_I_729 {
  List<int[]> books;
  
  public MyCalendar_I_729() {
    this.books = new ArrayList<int[]>();
  }
  
  public boolean book(int start, int end) {
    for (int[] book : this.books) {
      if (Math.max(start, book[0]) < Math.min(end, book[1])) {
        return false;
      }
    }
    this.books.add(new int[]{start, end});
    return true;
  }
}
