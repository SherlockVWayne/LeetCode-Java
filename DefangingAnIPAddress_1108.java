package LeetCode;

public class DefangingAnIPAddress_1108 {
    public String defangIPaddr(String address) {
        String[] addressArray = address.split("\\.");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < addressArray.length; i++) {
            sb.append(addressArray[i]);
            if (i != addressArray.length - 1) {
                sb.append("[.]");
            }
        }
        return sb.toString();
    }
}
