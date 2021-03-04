package LeetCode;

public class BackspaceStringCompare_844 {
    public boolean backspaceCompare(String S, String T) {
        int SPointer =S.length() - 1;
        int TPointer =T.length() - 1;

        int SSkips = 0;
        int TSkips = 0;

        while (SPointer >= 0 || TPointer >= 0) {
            while (SPointer >= 0) {
                if (S.charAt(SPointer) == '#') {
                    SSkips += 1;
                    SPointer -= 1;
                } else if (SSkips > 0) {
                    SPointer -= 1;
                    SSkips -= 1;
                } else {
                    break;
                }
            }

            while (TPointer >= 0) {
                if (T.charAt(TPointer) == '#') {
                    TSkips += 1;
                    TPointer -= 1;
                } else if (TSkips > 0) {
                    TPointer -= 1;
                    TSkips -= 1;
                } else {
                    break;
                }
            }

            if (SPointer >= 0 && TPointer >= 0 && S.charAt(SPointer) != T.charAt(TPointer)) {
                return false;
            }

            if ((SPointer >= 0) != (TPointer >= 0)) {
                return false;
            }
            SPointer -= 1;
            TPointer -= 1;
        }
        return true;
    }
}
