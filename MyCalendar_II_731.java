package LeetCode;

import java.util.*;

public class MyCalendar_II_731 {
  private TreeMap<Integer, Integer> books;
  
  public MyCalendar_II_731() {
    this.books = new TreeMap<Integer, Integer>();
  }
  
  public boolean book(int start, int end) {
    this.books.put(start, this.books.getOrDefault(start, 0) + 1);
    // one new event will be starting at start
    this.books.put(end, this.books.getOrDefault(end, 0) - 1);
    // one new event will be ending at end
    
    int overlappingCount = 0;
    
    for (Map.Entry<Integer, Integer> entry : books.entrySet()) {
      overlappingCount += entry.getValue();
      if (overlappingCount >= 3) {
        this.books.put(start, this.books.get(start) - 1);
        if (this.books.get(start) == 0) {
          this.books.remove(start);
        }
        
        this.books.put(end, this.books.get(end) + 1);
        if (this.books.get(end) == 0) {
          this.books.remove(end);
        }
        return false;
      }
    }
    
    return true;
  }
}
