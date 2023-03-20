package LeetCode;

public class Print {
  public static void printIntArray(int[] array) {
    for (int i : array) {
      System.out.print(i + " ");
    }
    System.out.println();
  }
  
  public static void printInt2DArray(int[][] array) {
    for (int[] i : array) {
      Print.printIntArray(i);
    }
    System.out.println();
  }
  
  public static void printIntegerArray(Integer[] array) {
    for (Integer i : array) {
      System.out.print(i + " ");
    }
    System.out.println();
  }
  
  public static void printStringArray(String[] array) {
    for (String i : array) {
      System.out.print(i + " ");
    }
    System.out.println();
  }
  
}
