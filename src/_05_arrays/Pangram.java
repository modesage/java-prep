package _05_arrays;
//leetcode
//1832. Check if the Sentence Is Pangram
public class Pangram {
    public static void main(String[] args) {
        String sentence = "thequickbrownfoxjumpsoverthelazydog";
        boolean result = checkIfPangram(sentence);
        System.out.println(result);
    }
    public static boolean checkIfPangram(String sentence) {
        if(sentence.length() < 26) {
            return false;
        }
        String ap = "abcdefghijklmnopqrstuvwxyz";
        for(int i=0; i<ap.length(); i++) {
            if(sentence.indexOf(ap.charAt(i)) == -1) {
                return false;
            }
        }
        return true;
    }
}
