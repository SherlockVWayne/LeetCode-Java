package LeetCode;

public class LongPressedName_925 {
    public boolean isLongPressedName(String name, String typed) {

        int nameIndex = 0;

        for (int typedIndex = 0; typedIndex < typed.length(); typedIndex ++) {
            if (nameIndex < name.length() && name.charAt(nameIndex) == typed.charAt(typedIndex)) {
                nameIndex ++;
            } else if(typedIndex == 0 || typed.charAt(typedIndex) != typed.charAt(typedIndex - 1)) {
                return false;
            }
        }

        return nameIndex == name.length();
    }
}
