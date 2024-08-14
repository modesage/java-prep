package _05_arrays;

import java.util.List;
import java.util.Objects;

//leetcode
//1773. Count Items Matching a Rule
public class CountItemsMatchingRule {
    public static void main(String[] args) {
        List<List<String>> items = List.of(
                List.of("phone", "blue", "pixel"),
                List.of("computer", "silver", "lenovo"),
                List.of("phone", "gold", "iphone")
        );
        String ruleKey = "type";
        String ruleValue = "phone";

        int result = countMatches(items, ruleKey, ruleValue);
        System.out.println(result);
    }
    public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int j = -1;

        if(Objects.equals(ruleKey, "type")) j = 0;
        else if(Objects.equals(ruleKey, "color")) j = 1;
        else if(Objects.equals(ruleKey, "name")) j = 2;

        int count = 0;

        for (List<String> item : items) {
            if(Objects.equals(ruleValue, (item.get(j)))) count += 1;
        }

        return count;
    }
}
