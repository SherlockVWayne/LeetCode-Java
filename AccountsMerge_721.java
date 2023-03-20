package LeetCode;

import java.util.*;

public class AccountsMerge_721 {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<Integer, Set<String>> emailToAccounts = new HashMap<>();
        // key: accountId
        // value: list of unique emails of this accountId

        Map<String, Integer> emailGroup = new HashMap<>();
        // key: email
        // value: accountId


        for (int i = 0; i < accounts.size(); i++) {
            int accountId = i;
            List<String> accountDetails = accounts.get(accountId);
            // list of emails of this accountId
            emailToAccounts.computeIfAbsent(accountId, k -> new HashSet<>());

            for (int j = 1; j < accountDetails.size(); j++) {
                String email = accountDetails.get(j);

                if (emailGroup.containsKey(email) && emailGroup.get(email) != accountId) {
                    int prevAccountId = emailGroup.get(email);

                    emailToAccounts.get(accountId).addAll(emailToAccounts.get(prevAccountId));

                    for (String e : emailToAccounts.get(prevAccountId)) {
                        emailGroup.put(e, accountId);
                    }
                }

                emailGroup.put(email, accountId); // map each unique email with its accountId
                emailToAccounts.get(accountId).add(email);
            }
        }

        emailToAccounts.clear();
        for (Map.Entry<String, Integer> entry : emailGroup.entrySet()) {
            int accountId = entry.getValue();
            String email = entry.getKey();
            emailToAccounts.computeIfAbsent(accountId,
                    k -> new TreeSet<>(
                            (a, b) -> a.compareTo(b)
                    ));

            emailToAccounts.get(accountId).add(email);
        }

        List<List<String>> ans = new ArrayList<>();
        for (Map.Entry<Integer, Set<String>> entry : emailToAccounts.entrySet()) {
            int accountId = entry.getKey();
            Set<String> emails = entry.getValue();
            String name = accounts.get(accountId).get(0);

            List<String> list = new ArrayList<>();
            list.add(name);
            list.addAll(emails);

            ans.add(list);
        }
        return ans;
    }
}
