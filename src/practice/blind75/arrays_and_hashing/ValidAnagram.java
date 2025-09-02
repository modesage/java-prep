package practice.blind75.arrays_and_hashing;
//https://leetcode.com/problems/valid-anagram/description/
//Given two strings s and t, return true if t is an anagram of s, and false otherwise.
import java.util.HashMap;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> freqMap = new HashMap<>();
        if(s.length() != t.length()){
            return false;
        }
        for(int x = 0; x < s.length(); x++){
            char i = s.charAt(x);
            if(!freqMap.containsKey(i)){
                freqMap.put(i, 1);
            }
            else{
                int freq = freqMap.get(i);
                freqMap.put(i, freq + 1);
            }
        }
        for(int x = 0; x < t.length(); x++){
            char i = t.charAt(x);
            if(freqMap.get(i) == null || freqMap.get(i) == 0){
                return false;
            }
            int freq = freqMap.get(i);
            freqMap.put(i, freq - 1);
        }
        return true;
    }
}
