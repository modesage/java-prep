package practice.blind75.arrays_and_hashing;
//https://leetcode.com/problems/encode-and-decode-strings/description/
//Design an algorithm to encode a list of strings to a single string.
//The encoded string is then decoded back to the original list of strings.
import java.util.ArrayList;
import java.util.List;
//Time complexity: O(N)
//Space complexity: O(N)
public class EncodeDecodeStrings {
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder("");
        for(String str : strs){
            sb.append(str.length()).append("#").append(str);
        }
        return sb.toString();
    }
    public List<String> decode(String str) {
        List<String> decodedStrs = new ArrayList<>();
        int i = 0;
        while(i < str.length()){
            int j = i;
            while(str.charAt(j) != '#'){
                j++;
            }
            int length = Integer.parseInt(str.substring(i, j));
            i = j + 1;
            String decodedStr = str.substring(i, i + length);
            decodedStrs.add(decodedStr);
            i = i + length;
        }
        return decodedStrs;
    }
}
