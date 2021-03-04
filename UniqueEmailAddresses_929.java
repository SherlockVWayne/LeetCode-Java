package LeetCode;

import java.util.HashSet;

public class UniqueEmailAddresses_929 {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> uniqueEmails = new HashSet();

        for (String email : emails) {
            int splitPosition = email.indexOf("@");
            String localName = email.substring(0, splitPosition);
            String domainName = email.substring(splitPosition);

            if (localName.contains("+")) {
                int plusPosition = localName.indexOf("+");
                localName = localName.substring(0, plusPosition);
            }

            localName = localName.replaceAll("\\.", "");
            String newName = localName + domainName;
            uniqueEmails.add(newName);
        }
        return uniqueEmails.size();
    }
}
