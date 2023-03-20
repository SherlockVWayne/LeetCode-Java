package LeetCode;

import java.util.*;

public class MyCalendar_III_732 {
  
  private TreeMap<Integer, Integer> books;
  // maintains ascending order(Sorted using the natural order of its key)
  
  public MyCalendar_III_732() {
    this.books = new TreeMap<Integer, Integer>();
  }
  
  public int book(int startTime, int endTime) {
    this.books.put(startTime, this.books.getOrDefault(startTime, 0) + 1);
    // one new event will be starting at startTime
    this.books.put(endTime, this.books.getOrDefault(endTime, 0) - 1);
    // one new event will be ending at startTime
    
    int overlappingCount = 0;
    int maxOverlapping = 0;
    
    for (Map.Entry<Integer, Integer> entry : this.books.entrySet()) {
      overlappingCount += entry.getValue();
      maxOverlapping = Math.max(maxOverlapping, overlappingCount);
    }
    
    return maxOverlapping;
  }
  
  public static void main(String[] args) {
    MyCalendar_III_732 myCalendar_iii_732 = new MyCalendar_III_732();
    System.out.println(myCalendar_iii_732.book(10, 20));
    System.out.println(myCalendar_iii_732.book(50, 60));
    System.out.println(myCalendar_iii_732.book(10, 40));
    System.out.println(myCalendar_iii_732.book(5, 15));
    System.out.println(myCalendar_iii_732.book(5, 10));
    System.out.println(myCalendar_iii_732.book(25, 55));
  }
}
/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(startTime,endTime);
 */