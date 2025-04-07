package _23_graphs.mst_disjoint_set;
import java.util.*;

// https://leetcode.com/problems/accounts-merge/description/
public class AccountsMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);

        // This map will record the first account index where an email was seen.
        // Key: email address, Value: account index in the 'accounts' list.
        HashMap<String, Integer> mapMailNode = new HashMap<>();

        // Loop through all accounts to build unions based on shared emails.
        for (int i = 0; i < n; i++) {
            // Each account's first element is the name, so start from index 1 for emails.
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String mail = accounts.get(i).get(j);
                // If the email is not already mapped, add it with the current account index.
                if (!mapMailNode.containsKey(mail)) {
                    mapMailNode.put(mail, i);
                } else {
                    // Email already exists, so union the current account with the account
                    // where this email was first encountered.
                    ds.unionBySize(i, mapMailNode.get(mail));
                }
            }
        }

        // Prepare an array to store merged emails for each account.
        // Each index corresponds to the ultimate parent (representative) of a merged group.
        ArrayList<String>[] mergedMail = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            mergedMail[i] = new ArrayList<>();
        }

        // Group emails by their representative account.
        // For each email, find the ultimate parent (representative) account and add the email to that group.
        for (Map.Entry<String, Integer> entry : mapMailNode.entrySet()) {
            String mail = entry.getKey();
            int parentIndex = ds.findUltParent(entry.getValue());
            mergedMail[parentIndex].add(mail);
        }

        // Build the final result list.
        List<List<String>> ans = new ArrayList<>();
        // Iterate over all potential representative accounts.
        for (int i = 0; i < n; i++) {
            // If no emails have been grouped under this representative, skip.
            if (mergedMail[i].isEmpty()) continue;

            // Sort the emails lexicographically as required by the problem.
            Collections.sort(mergedMail[i]);

            // Create a temporary list for the merged account.
            List<String> temp = new ArrayList<>();
            // The first element should be the name. All accounts merged under the same parent share the same name,
            // so we use the name from the account at index i.
            temp.add(accounts.get(i).get(0));
            // Add all sorted emails to the merged account.
            temp.addAll(mergedMail[i]);

            // Add the merged account to the final result.
            ans.add(temp);
        }
        return ans;
    }
}
