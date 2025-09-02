package practice.blind75.arrays_and_hashing;
//https://leetcode.com/problems/group-anagrams/description/
//Given an array of strings strs, group the anagrams together. You can return the answer in any order.
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ls = new ArrayList<>();
        HashMap<String, List<String>> hm = new HashMap<>();
        for(String str : strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);
            if(!hm.containsKey(sortedStr)){
                hm.put(sortedStr, new ArrayList<>());
            }
            hm.get(sortedStr).add(str);
        }
        return new ArrayList<>(hm.values());
    }
}
