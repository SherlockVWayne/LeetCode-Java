package LeetCode;

import java.util.List;

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
    
    public static void printChar2DArray(Character[][] array) {
        for (Character[] i : array) {
            Print.printCharArray(i);
        }
        System.out.println();
    }
    
    public static void printIntegerArray(Integer[] array) {
        for (Integer i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    
    public static void printCharArray(Character[] array) {
        for (Character i : array) {
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
    
    public static void printStringList(List<String> array) {
        for (String i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    
    public static void printIntList(List<Integer> array) {
        for (Integer i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
